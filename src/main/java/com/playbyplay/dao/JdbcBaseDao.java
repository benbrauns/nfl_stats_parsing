package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvRowSet;
import com.playbyplay.dao.importutil.ImportLogger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import javax.sql.RowSet;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class JdbcBaseDao implements BaseDao {
    public final String RELEASES_BASE_URL = "https://github.com/nflverse/nflverse-data/releases/download/";
    protected final JdbcTemplate jdbcTemplate;

    private Class<?> objectType;

    public JdbcBaseDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public JdbcBaseDao(DataSource dataSource, Class<?> objectType) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.objectType = objectType;
    }

    public List<String> getColumnNames() {
        List<String> cols = new ArrayList<>();
        String sql =
                "SELECT attname            AS col\n" +
                "       -- more attributes?\n" +
                "FROM   pg_attribute\n" +
                "WHERE  attrelid = 'public.play'::regclass  -- table name optionally schema-qualified\n" +
                "AND    attnum > 0\n" +
                "AND    NOT attisdropped\n" +
                "ORDER  BY attnum;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        try {
            while (rowSet.next()) {
                cols.add(rowSet.getString("col"));
            }
        } catch (Exception e) {
            Logger.logError(e);
        }

        return cols;
    }

    public boolean urlExists(String address) {
        try {
            URL url = new URL(address);
            HttpURLConnection huc = (HttpURLConnection)url.openConnection();
            huc.setRequestMethod("HEAD");
            int responseCode = huc.getResponseCode();
            if (responseCode != 404) {
                return true;
            }
        } catch (Exception e){
            Logger.logError(e);
        }
        return false;
    }

    protected String addIlikeFormat(String val) {
        return "%" + val + "%";
    }

    protected Integer validateInteger(Integer intVal) {
        if (intVal == null) {
            return -1;
        }
        else {
            return intVal;
        }
    }

    public String validateString(String stringVal) {
        if (stringVal == null) {
            return "";
        }
        else return stringVal;
    }

    private String generateFindSql(Class<?> type, List<Field> fields) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ");
        sql.append(type.getSimpleName());
        for (int i = 0; i < fields.size(); i++) {
            if (i == 0) {
                sql.append(" WHERE ");
            } else {
                sql.append(" AND ");
            }
            sql.append(fields.get(i).getName());
            sql.append(" = ?");
        }
        return sql.toString();
    }

    protected <T> void insertObjectList(Class<T> type, List<T> objects) {
        for (T object : objects) {
            insertObject(type, object);
        }
    }

    protected <T> void insertObject(Class<T> type, T objectToInsert) {
        String sql = generateInsertSql(type, objectToInsert);
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            statement = connection.prepareStatement(sql);
            Field[] fields = getNonNullFields(type, objectToInsert);
            int i = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                    Object obj = field.get(objectToInsert);
                    if (obj != null) {
                        statement.setBoolean(i, (boolean)obj);
                    } else {
                        statement.setNull(i, Types.BOOLEAN);
                    }
                }
                else if (field.getType() == String.class) {
                    Object obj = field.get(objectToInsert);
                    if (obj != null) {
                        statement.setString(i, (String)obj);
                    } else {
                        statement.setNull(i, Types.VARCHAR);
                    }
                }
                else if (field.getType() == Double.class) {
                    statement.setDouble(i, field.getDouble(objectToInsert));
                }
                else if (field.getType() == Integer.class) {
                    Object obj = field.get(objectToInsert);
                    if (obj != null) {
                        statement.setInt(i, (int)obj);
                    } else {
                        statement.setNull(i, Types.VARCHAR);
                    }
                }
                else if (field.getType() == BigDecimal.class) {
                    Object obj = field.get(objectToInsert);
                    if (obj != null) {
                        statement.setBigDecimal(i, (BigDecimal)obj);
                    } else {
                        statement.setNull(i, Types.NUMERIC);
                    }
                }
                else if (field.getType() == LocalDate.class) {
                    Object obj = field.get(objectToInsert);
                    if (obj != null) {
                        Date date = Date.valueOf((LocalDate)obj);
                        statement.setDate(i, date);
                    } else {
                        statement.setNull(i, Types.DATE);
                    }
                }
                else if (field.getType() == LocalDateTime.class) {
                    Object obj = field.get(objectToInsert);
                    if (obj != null) {
                        Timestamp timestamp = Timestamp.valueOf((LocalDateTime)obj);
                        statement.setTimestamp(i, timestamp);
                    } else {
                        statement.setNull(i, Types.TIMESTAMP);
                    }

                }
                field.setAccessible(false);
                i++;
            }
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.logError(e);
        } finally {
            if (statement != null) try { statement.close(); } catch (Exception ignored) {}
            if (connection != null) try { connection.close(); } catch (Exception ignored) {}
        }
    }


    private String generateInsertSql(Class<?> type, Object objectToInsert) {
        Field[] fields = getNonNullFields(type, objectToInsert);
        StringBuilder sqlBuilder = new StringBuilder().append("INSERT INTO ");
        sqlBuilder.append(type.getSimpleName().toLowerCase(Locale.ROOT));
        sqlBuilder.append(" (");

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equalsIgnoreCase("desc")) {
                sqlBuilder.append("play_");
            }
            sqlBuilder.append(fields[i].getName());
            if (i < fields.length - 1) {
                sqlBuilder.append(", ");
            } else {
                sqlBuilder.append(") VALUES (");
            }
        }

        for (int i = 0; i < fields.length; i++) {
            sqlBuilder.append("?");
            if (i < fields.length - 1) {
                sqlBuilder.append(", ");
            } else {
                sqlBuilder.append(");");
            }
        }

        return sqlBuilder.toString();
    }

    protected <T> List<T> objectListMapper(Class<T> type, SqlRowSet rowSet) {
        List<T> newList = new ArrayList<>();
        try {
            while (rowSet.next()) {
                newList.add(objectMapper(type, rowSet));
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return newList;
    }

    protected <T> T objectMapper(Class<T> type, SqlRowSet resultSet) {
        try {
            T newObj = type.getDeclaredConstructor().newInstance();
            List<Field> presentFields = getPresentFields(type, resultSet);
            for (Field field : presentFields) {
                field.setAccessible(true);
                if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                    field.set(newObj, resultSet.getBoolean(field.getName()));
                } else if (field.getType() == String.class) {
                    field.set(newObj, resultSet.getString(field.getName()));
                } else if (field.getType() == Double.class) {
                    field.set(newObj, resultSet.getDouble(field.getName()));
                } else if (field.getType() == Integer.class) {
                    field.set(newObj, resultSet.getInt(field.getName()));
                } else if (field.getType() == BigDecimal.class) {
                    field.set(newObj, resultSet.getBigDecimal(field.getName()));
                } else if (field.getType() == LocalDate.class) {
                    Date date = resultSet.getDate(field.getName());
                    if (date != null) {
                        field.set(newObj, date.toLocalDate());
                    }
                } else if (field.getType() == LocalDateTime.class) {
                    Timestamp timestamp = resultSet.getTimestamp(field.getName());
                    if (timestamp != null) {
                        LocalDateTime dt = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneOffset.of(ZoneOffset.SHORT_IDS.get("EST")));
                        field.set(newObj, dt);
                    }
                }
                field.setAccessible(false);
            }
            return newObj;
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }

    protected List<Field> getPresentFields(Class<?> type, SqlRowSet resultSet) {
        Field[] fields = type.getDeclaredFields();
        List<Field> presentFields = new ArrayList<>();
        for (Field field : fields) {
            try {
                resultSet.findColumn(field.getName());
                presentFields.add(field);
            } catch (Exception ignored) {}
        }
        return presentFields;
    }

    protected List<Field> getPresentFields(Class<?> type, Set<String> params) {
        Field[] fields = type.getDeclaredFields();
        List<Field> presentFields = new ArrayList<>();
        for (Field field : fields) {
            if (params.contains(field.getName())) {
                presentFields.add(field);
            }
        }
        return presentFields;
    }

    protected Field[] getNonNullFields(Class<?> type, Object object) {
        Field[] fields = type.getDeclaredFields();
        List<Field> nonNull = new ArrayList<>();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.get(object) != null) {
                    nonNull.add(field);
                }
            } catch (Exception ignored) {}
            finally {
                field.setAccessible(false);
            }
        }
        return nonNull.toArray(Field[]::new);
    }
}

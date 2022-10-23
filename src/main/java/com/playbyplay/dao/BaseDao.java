package com.playbyplay.dao;

import com.playbyplay.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    public final String RELEASES_BASE_URL = "https://github.com/nflverse/nflverse-data/releases/download/";
    protected final JdbcTemplate jdbcTemplate;

    public BaseDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean columnExists(ResultSet resultSet, String columnName) {
        int count = 0;
        try {
            ResultSetMetaData data = resultSet.getMetaData();
            for (int i = 0; i < data.getColumnCount(); i++) {
                if (data.getColumnName(i).equalsIgnoreCase(columnName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return false;
    }

    protected Integer validateInteger(Integer intVal) {
        if (intVal == null) {
            return -1;
        }
        else {
            return intVal;
        }
    }

    protected String validateString(String stringVal) {
        if (stringVal == null) {
            return "";
        }
        else return stringVal;
    }


    public void updateDatabase() {

    }
}

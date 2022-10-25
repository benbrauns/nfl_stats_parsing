package com.playbyplay.dao.importutil;

import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class CsvRowSet implements SqlRowSet {

    private static final Character DELIMINATOR = ',';
    private String currentLine = null;
    private String[] currentLineArr = null;
    private BufferedReader in;
    private Map<String, Integer> columnNameIndexes = new HashMap<>();

    public CsvRowSet(URL url) {
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            if ((currentLine = in.readLine()) != null) {
                setColumnNameIndexes(currentLine);
                splitLine();
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
    }

    private void setColumnNameIndexes(String line) {
        try {
            if (!line.contains(",")) {
                throw new IllegalArgumentException("File column names didn't include comma separators");
            }
            String[] columnNames = line.split(DELIMINATOR.toString());
            for (int i = 0; i < columnNames.length; i++) {
                columnNameIndexes.put(columnNames[i], i);
            }
            currentLineArr = new String[columnNames.length];
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
    }

    @Override
    public boolean next() {
        if (currentLine != null) {
            try {
                currentLine = in.readLine();
                if (currentLine != null) {
                    splitLine();
                }
                else {
                    currentLineArr = null;
                    in.close();
                }
            } catch (Exception e) {
                ImportLogger.logError(e);
            }
        }
        return currentLine != null;
    }

    private SimpleDateFormat getDateFormat(String colVal) {
        if (colVal.contains("/") && colVal.substring(colVal.lastIndexOf("/")).length() == 5) {
            return new SimpleDateFormat("MM/dd/yyyy");
        } else if (colVal.contains("-") && colVal.substring(0, colVal.indexOf("-")).length() == 4) {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
        Exception e = new Exception("Couldn't find date formatter for value of {" + colVal + "}");
        ImportLogger.logError(e);
        return null;
    }

    public boolean validColName(String columnName) {
        try {
            if (this.columnNameIndexes.containsKey(columnName)) {
                return true;
            } else {
                String message = "Column name {" + columnName + "} doesn't exist.";
                throw new IllegalArgumentException(message);
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return false;
    }

    private String getColValue(String columnName) {
        int index = columnNameIndexes.get(columnName);
        try {
            return currentLineArr[index].replace("\"", "");
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }

    @Override
    public boolean wasNull() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public String getString(int columnIndex) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public boolean getBoolean(int columnIndex) throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public byte getByte(int columnIndex) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public short getShort(int columnIndex) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public int getInt(int columnIndex) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public long getLong(int columnIndex) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public float getFloat(int columnIndex) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public double getDouble(int columnIndex) throws InvalidResultSetAccessException {
        return 0;
    }


    @Override
    public Date getDate(int columnIndex) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Time getTime(int columnIndex) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Timestamp getTimestamp(int columnIndex) throws InvalidResultSetAccessException {
        return null;
    }

    private void splitLine() {
        currentLineArr = new String[columnNameIndexes.size()];
        Arrays.fill(currentLineArr, "");

        try {
            if (!currentLine.contains(",")) {
                throw new Exception("Line does not contain a comma");
            }
            else {
                boolean quoteOpened = false;
                int currentIndex = 0;
                int currentColumn = 0;
                for (int i = 0; i < currentLine.length(); i++) {
                    char c = currentLine.charAt(i);
                    if (!quoteOpened && c == DELIMINATOR) {
                        currentLineArr[currentColumn] = currentLine.substring(currentIndex, i);
                        currentIndex = i + 1;
                        currentColumn++;
                    } else if (!quoteOpened && c == '\"') {
                        quoteOpened = true;
                    } else if (c == '\"') {
                        quoteOpened = false;
                    }
                }
                //it doesn't fill in the last one
                if (currentLineArr.length > 0) {
                    currentLineArr[currentColumn] = currentLine.substring(currentIndex).replace("\n", "");
                }
            }
        }
        catch (Exception e) {
            ImportLogger.logError(e);
        }
    }

    @Override
    public String getString(String columnName) {
        try {
            if (validColName(columnName)) {
                String colVal = getColValue(columnName);
                if (colVal == null) {
                    return null;
                } else if (colVal.isBlank()) {
                    return null;
                } else {
                    return colVal;
                }
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }

    @Override
    public boolean getBoolean(String columnLabel) throws InvalidResultSetAccessException {
        try {
            if (validColName(columnLabel)) {
                String colVal = getColValue(columnLabel);
                if (colVal == null) {
                    return false;
                } else if (colVal.isBlank()) {
                    return false;
                }
                else {
                    BigDecimal val = new BigDecimal(colVal);
                    return val.intValue() == 1;
                }
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return false;
    }

    @Override
    public byte getByte(String columnLabel) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public short getShort(String columnLabel) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public int getInt(String columnName) {
        try {
            if (validColName(columnName)) {
                String colVal = "";
                try {
                    colVal = getColValue(columnName);
                    if (colVal == null || colVal.isBlank()) {
                        return 0;
                    } else {
                        return Integer.parseInt(colVal);
                    }
                } catch (Exception e) {
                    String message = "Integer could not be parsed for value {" + colVal + "}";
                    throw new Exception(message);
                }
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return 0;
    }

    @Override
    public long getLong(String columnLabel) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public float getFloat(String columnLabel) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public double getDouble(String columnLabel) throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public java.sql.Date getDate(String columnName) {
        try {
            if (validColName(columnName)) {

                String colVal = getColValue(columnName);
                if (colVal.isEmpty()) {
                    return null;
                }
                SimpleDateFormat format = getDateFormat(colVal);
                if (format != null) {
                    return new Date(format.parse(colVal).getTime());
                }
                return null;
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }

    @Override
    public Time getTime(String columnLabel) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Timestamp getTimestamp(String columnLabel) throws InvalidResultSetAccessException {
        try {
            if (validColName(columnLabel)) {
                String colVal = getColValue(columnLabel);
                if (colVal == null) {
                    return null;
                } else if (colVal.isBlank() || !validColName("game_date")) {
                    return null;
                } else{
                    return Timestamp.valueOf(getColValue("game_date") + " " + colVal);
                }
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }

    @Override
    public SqlRowSetMetaData getMetaData() {
        return null;
    }

    @Override
    public Object getObject(int columnIndex) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Object getObject(String columnLabel) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public int findColumn(String columnLabel) throws InvalidResultSetAccessException {
        if (columnNameIndexes.containsKey(columnLabel)) {
            return columnNameIndexes.get(columnLabel);
        } else {
            throw new InvalidResultSetAccessException("Column doesn't exist", "", new SQLException(""));
        }
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public BigDecimal getBigDecimal(String columnLabel) throws InvalidResultSetAccessException {
        try {
            if (validColName(columnLabel)) {
                String colVal = getColValue(columnLabel);
                if (colVal == null) {
                    return null;
                } else if (colVal.equalsIgnoreCase("NA") || colVal.equalsIgnoreCase("")) {
                    return null;
                } else {
                    return new BigDecimal(colVal);
                }
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }


    @Override
    public Date getDate(int i, Calendar calendar) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Date getDate(String s, Calendar calendar) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public String getNString(int i) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public String getNString(String s) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Object getObject(int i, Map<String, Class<?>> map) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Object getObject(String s, Map<String, Class<?>> map) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public <T> T getObject(int i, Class<T> aClass) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public <T> T getObject(String s, Class<T> aClass) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Time getTime(int i, Calendar calendar) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Time getTime(String s, Calendar calendar) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Timestamp getTimestamp(int i, Calendar calendar) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public Timestamp getTimestamp(String s, Calendar calendar) throws InvalidResultSetAccessException {
        return null;
    }

    @Override
    public boolean absolute(int i) throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public void afterLast() throws InvalidResultSetAccessException {

    }

    @Override
    public void beforeFirst() throws InvalidResultSetAccessException {

    }

    @Override
    public boolean first() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public int getRow() throws InvalidResultSetAccessException {
        return 0;
    }

    @Override
    public boolean isAfterLast() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public boolean isBeforeFirst() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public boolean isFirst() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public boolean isLast() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public boolean last() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public boolean previous() throws InvalidResultSetAccessException {
        return false;
    }

    @Override
    public boolean relative(int i) throws InvalidResultSetAccessException {
        return false;
    }
}

package com.playbyplay.dao.importutil;

import org.springframework.cglib.core.Local;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    private static final Character DELIMINATOR = ',';
    private String currentLine = null;
    private String[] currentLineArr = null;
    private BufferedReader in;
    private Map<String, Integer> columnNameIndexes = new HashMap<>();

    public CsvReader(URL url) {
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

    public boolean nextLine() {
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

    private void splitLine() {
        currentLineArr = new String[columnNameIndexes.size()];
        for (int i = 0; i < currentLineArr.length; i++) {
            currentLineArr[i] = "";
        }

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
            }
        }
        catch (Exception e) {
            ImportLogger.logError(e);
        }
    }

    public String getString(String columnName) {
        try {
            if (validColName(columnName)) {
                return getColValue(columnName);
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }

    public Integer getInt(String columnName) {
        try {
            if (validColName(columnName)) {
                String colVal = "";
                try {
                    colVal = getColValue(columnName);
                    if (colVal == null || colVal.isBlank()) {
                        return null;
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
        return null;
    }

    public LocalDate getLocalDate(String columnName) {
        try {
            if (validColName(columnName)) {
                String colVal = getColValue(columnName);
                if (colVal.isEmpty()) {
                    return null;
                }
                DateTimeFormatter formatter = getDateFormat(colVal);
                if (formatter != null) {
                    return LocalDate.parse(colVal, formatter);
                }
                return null;
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }

    private DateTimeFormatter getDateFormat(String colVal) {

        if (colVal.contains("/") && colVal.substring(colVal.lastIndexOf("/")).length() == 5) {
            return DateTimeFormatter.ofPattern("MM/dd/yyyy");
        } else if (colVal.contains("-") && colVal.substring(0, colVal.indexOf("-")).length() == 4) {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }
        Exception e = new Exception("Couldn't find date formatter for value of {" + colVal + "}");
        ImportLogger.logError(e);
        return null;
    }

    public URL getUrl(String columnName) {
        try {
            if (validColName(columnName)) {
                String colVal = getColValue(columnName);
                try {
                    URL url = new URL(colVal);
                    return url;
                } catch (Exception e){
                    return null;
                }
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
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

//    public String get(String columnName) {
//        try {
//            if (validColName(columnName)) {
//
//            } else {
//                throw new IllegalArgumentException("Column name doesn't exist");
//            }
//        } catch (Exception e) {
//            ImportLogger.logError(e);
//        }
//        return null;
//    }
}

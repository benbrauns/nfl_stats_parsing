package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvReader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DataImporter {
    public final String RELEASES_BASE_URL = "https://github.com/nflverse/nflverse-data/releases/download/";
    protected final JdbcTemplate jdbcTemplate;

    public DataImporter(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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

    public void updateDatabase() {

    }
}

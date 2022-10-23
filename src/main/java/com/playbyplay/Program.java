package com.playbyplay;

import com.playbyplay.dao.JdbcPlayerDao;
import com.playbyplay.dao.JdbcTeamDao;
import com.playbyplay.dao.PlayerDao;
import com.playbyplay.dao.TeamDao;
import com.playbyplay.dao.importutil.DataImporter;
import org.apache.commons.dbcp2.BasicDataSource;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter();
        dataImporter.updateDatabase();

    }


}

package com.playbyplay.dao.importutil;

import com.playbyplay.dao.*;
import org.apache.commons.dbcp2.BasicDataSource;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DataImporter {



    public void updateDatabase() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/NFL_PBP");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        TeamDao teamDao = new JdbcTeamDao(dataSource);
        teamDao.createTeams();

        GameDao gameDao = new JdbcGameDao(dataSource);
        gameDao.importGames(getPbpLinks());

//        PlayerDao playerImporter = new JdbcPlayerDao(dataSource);
//        playerImporter.updatePlayersFromSourceCsv();
    }

    private List<String> getPbpLinks() {
        String linkFront = "https://github.com/nflverse/nflverse-data/releases/download/pbp/play_by_play_";
        List<String> years = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (Integer i = 1999; i <= currentYear; i++) {
            String address = (linkFront + i.toString() + ".csv");
            if (urlExists(address)) {
                years.add(address);
            }
        }
        return years;
    }

    private boolean urlExists(String address) {
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
}
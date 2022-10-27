package com.playbyplay.dao.importutil;

import com.playbyplay.dao.*;
import com.playbyplay.model.Game;
import com.playbyplay.model.Play;
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
        List<String> pbpLinks = getPbpLinks();
        GameDao gameDao = new JdbcGameDao(dataSource);
        TeamDao teamDao = new JdbcTeamDao(dataSource);
        RosterDao rosterDao = new JdbcRosterDao(dataSource);
        PlayerDao playerImporter = new JdbcPlayerDao(dataSource);
        PlayDao playDao = new JdbcPlayDao(dataSource);


        teamDao.createTeams();


        playerImporter.updatePlayersFromSourceCsv();

        rosterDao.importPlays(getRosterLinks());

        gameDao.importGames(pbpLinks);


        playDao.importPlays(pbpLinks);


    }

    private List<String> getPbpLinks() {
        String linkFront = "https://github.com/nflverse/nflverse-data/releases/download/pbp/play_by_play_";
        List<String> years = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        //TODO: change this to 1999 leaving as 2022 so it only imports one year
        for (Integer i = 1999; i <= currentYear; i++) {
            String address = (linkFront + i.toString() + ".csv");
            if (urlExists(address)) {
                years.add(address);
            }
        }
        return years;
    }

    private List<String> getRosterLinks() {
        String linkFront = "https://github.com/nflverse/nflverse-data/releases/download/weekly_rosters/roster_weekly_";
        List<String> years = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        //TODO: change this to 2002 leaving as 2022 so it only imports one year
        for (Integer i = 2022; i <= currentYear; i++) {
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

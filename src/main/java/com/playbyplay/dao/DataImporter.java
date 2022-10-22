package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvReader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataImporter {
    private final String RELEASES_BASE_URL = "https://github.com/nflverse/nflverse-data/releases/download/";
    private final JdbcTemplate jdbcTemplate;
    private URL playersUrl;


    public DataImporter(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            playersUrl = new File("C:\\Users\\Student\\side-projects\\NFL_PBP\\src\\main\\resources\\players.csv").toURI().toURL();
        } catch (Exception e) {
            Logger.logError(e);
        }


    }

    public void updateDatabase() {
        updatePlayers();
    }



    public void updatePlayers() {
        String address = RELEASES_BASE_URL + "players/players.csv";

        //TODO: enable this but I just don't want to keep hitting the github page with requests
        //if (urlExists(address)) {
            try {
                //TODO: uncomment this when ready for production
                //playersUrl = new URL(address);
                CsvReader reader = new CsvReader(playersUrl);
                List<Player> players = playerListMapper(reader);
                int numBefore = countPlayers();
                for (Player player : players) {
                    insertPlayer(player);
                }
                Logger.logPlayersAdded(countPlayers() - numBefore);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        //}
    }

    private Integer countPlayers() {
        String sql =
                "SELECT COUNT(*) " +
                "FROM player;";
        return jdbcTemplate.queryForObject(sql, Integer.class);
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

    private int playerExists(Player player) {
        String sql =
                "SELECT * " +
                "FROM player " +
                "WHERE gsis_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, player.getGsis_id());
        if (rowSet.next()) {
//            Exception e = new Exception("Player {" + player + "} is already in database");
//            Logger.logError(e);
            return rowSet.getInt("player_id");
        }
        return -1;

    }


    private int insertPlayer(Player player) {
        if (player.getGsis_id().equals("")) {
            Exception e = new Exception("Player {" + player + "} has no gsid_id");
            Logger.logError(e);
            return -1;
        }
        Integer id = playerExists(player);
        if (id != -1) {
            return id;
        }

        String sql =
                "INSERT INTO player (status, display_name, first_name, last_name, esb_id, gsis_id, suffix, birth_date, college_name, position_group, position, jersey_number, height, weight, team_abbr, team_seq, current_team_id, football_name, entry_year, rookie_year, draft_club, college_conference, status_description_abbr, status_short_description, gsis_it_id, short_name, smart_id, headshot, draft_number, uniform_number, draft_round, season)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                        "RETURNING player_id;";
        id = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                player.getStatus(),
                player.getDisplay_name(),
                player.getFirst_name(),
                player.getLast_name(),
                player.getEsb_id(),
                player.getGsis_id(),
                player.getSuffix(),
                player.getBirth_date(),
                player.getCollege_name(),
                player.getPosition_group(),
                player.getPosition(),
                player.getJersey_number(),
                player.getHeight(),
                player.getWeight(),
                player.getTeam_abbr(),
                player.getTeam_seq(),
                player.getCurrent_team_id(),
                player.getFootball_name(),
                player.getEntry_year(),
                player.getRookie_year(),
                player.getDraft_club(),
                player.getCollege_conference(),
                player.getStatus_description_abbr(),
                player.getStatus_short_description(),
                player.getGsis_it_id(),
                player.getShort_name(),
                player.getSmart_id(),
                player.getHeadshotString(),
                player.getDraft_number(),
                player.getUniform_number(),
                player.getDraft_round(),
                player.getSeason()
        );
        return id;
    }


    private List<Player> playerListMapper(CsvReader reader) {
        List<Player> players = new ArrayList<>();
        while (reader.nextLine()) {
            players.add(mapPlayer(reader));
        }
        return players;
    }


    private Player mapPlayer(CsvReader reader) {
        Player player = new Player();
        player.setStatus(reader.getString("status"));
        player.setDisplay_name(reader.getString("display_name"));
        player.setFirst_name(reader.getString("first_name"));
        player.setLast_name(reader.getString("last_name"));
        player.setEsb_id(reader.getString("esb_id"));
        player.setGsis_id(reader.getString("gsis_id"));
        player.setSuffix(reader.getString("suffix"));
        player.setBirth_date(reader.getLocalDate("birth_date"));
        player.setCollege_name(reader.getString("college_name"));
        player.setPosition_group(reader.getString("position_group"));
        player.setPosition(reader.getString("position"));
        player.setJersey_number(reader.getInt("jersey_number"));
        player.setHeight(reader.getString("height"));
        player.setWeight(reader.getInt("weight"));
        player.setTeam_abbr(reader.getString("team_abbr"));
        player.setTeam_seq(reader.getString("team_seq"));
        player.setCurrent_team_id(reader.getString("current_team_id"));
        player.setFootball_name(reader.getString("football_name"));
        player.setEntry_year(reader.getInt("entry_year"));
        player.setRookie_year(reader.getInt("rookie_year"));
        player.setDraft_club(reader.getString("draft_club"));
        player.setCollege_conference(reader.getString("college_conference"));
        player.setStatus_description_abbr(reader.getString("status_description_abbr"));
        player.setStatus_short_description(reader.getString("status_short_description"));
        player.setGsis_it_id(reader.getInt("gsis_it_id"));
        player.setShort_name(reader.getString("short_name"));
        player.setSmart_id(reader.getString("smart_id"));
        //TODO: bug that returns all headshot urls as null
        player.setHeadshot(reader.getUrl("headshot"));
        player.setDraft_number(reader.getInt("draft_number"));
        player.setUniform_number(reader.getString("uniform_number"));
        player.setDraft_round(reader.getInt("draft_round"));
        player.setSeason(reader.getInt("season"));


        return player;
    }


}

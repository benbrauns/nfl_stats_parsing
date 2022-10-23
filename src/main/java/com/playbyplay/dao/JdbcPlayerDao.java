package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvReader;
import com.playbyplay.model.Player;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class JdbcPlayerDao extends BaseDao implements PlayerDao {
    private URL playersUrl;
    public JdbcPlayerDao(DataSource dataSource) {
        super(dataSource);
        try {
            playersUrl = new File("C:\\Users\\Student\\side-projects\\NFL_PBP\\src\\main\\resources\\players.csv").toURI().toURL();
        } catch (Exception e) {
            Logger.logError(e);
        }
    }

    @Override
    public void updatePlayersFromSourceCsv() {
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
            Logger.logError(e);
        }
        //}
    }

    private Integer countPlayers() {
        String sql =
                "SELECT COUNT(*) " +
                        "FROM player;";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    @Override
    public String playerExists(Player player) {
        String sql =
                "SELECT * " +
                        "FROM player " +
                        "WHERE gsis_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, player.getGsis_id());
        if (rowSet.next()) {
            return rowSet.getString("gsis_id");
        }
        return "";
    }

    @Override
    public String insertPlayer(Player player) {
        if (player.getGsis_id() == null) {
            return "";
        }
        else if (player.getGsis_id().equals("")) {
            Exception e = new Exception("Player {" + player + "} has no gsid_id");
            Logger.logError(e);
            return "";
        }
        String id = playerExists(player);
        if (!id.isBlank()) {
            return id;
        }

        String sql =
                "INSERT INTO player (status, display_name, first_name, last_name, esb_id, gsis_id, suffix, birth_date, college_name, position_group, position, jersey_number, height, weight, team_abbr, team_seq, current_team_id, football_name, entry_year, rookie_year, draft_club, college_conference, status_description_abbr, status_short_description, gsis_it_id, short_name, smart_id, headshot, draft_number, uniform_number, draft_round, season)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                        "RETURNING player_id;";
        id = jdbcTemplate.queryForObject(
                sql,
                String.class,
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
                player.getHeadshot(),
                player.getDraft_number(),
                player.getUniform_number(),
                player.getDraft_round(),
                player.getSeason()
        );
        return id;
    }


    private List<Player> playerListMapper(ResultSet reader) {
        List<Player> players = new ArrayList<>();
        try {
            while (reader.next()) {
                players.add(mapPlayer(reader));
            }
        } catch (Exception e) {
            Logger.logError(e);
        }

        return players;
    }


    private Player mapPlayer(ResultSet reader) {
        Player player= new Player();
        try {
            player.setStatus(reader.getString("status"));
            player.setDisplay_name(reader.getString("display_name"));
            player.setFirst_name(reader.getString("first_name"));
            player.setLast_name(reader.getString("last_name"));
            player.setEsb_id(reader.getString("esb_id"));
            player.setGsis_id(reader.getString("gsis_id"));
            player.setSuffix(reader.getString("suffix"));
            Date birthDate = reader.getDate("birth_date");
            if (birthDate != null) {
                player.setBirth_date(birthDate.toLocalDate());
            }
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
            player.setHeadshot(reader.getString("headshot"));
            player.setDraft_number(reader.getInt("draft_number"));
            player.setUniform_number(reader.getString("uniform_number"));
            player.setDraft_round(reader.getInt("draft_round"));
            player.setSeason(reader.getInt("season"));
        } catch (Exception e) {
            Logger.logError(e);
        }
        return player;
    }
}

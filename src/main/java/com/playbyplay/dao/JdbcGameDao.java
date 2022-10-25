package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvRowSet;
import com.playbyplay.model.Game;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Date;
import java.util.*;

public class JdbcGameDao extends BaseDao implements GameDao {

    private JdbcTeamDao teamDao;

    public JdbcGameDao(DataSource dataSource) {
        super(dataSource);
        teamDao = new JdbcTeamDao(dataSource);
    }

    public void importGames(List<String> pbpLinks) {
        try {
            validateTeamsExist();
            String currentYear = getCurrentYear().toString();
            for (String year : pbpLinks) {
                if (!currentYear.equals("-1") && !year.contains(currentYear)) {
                    continue;
                }
                URL url = new URL(year);
                try (CsvRowSet reader = new CsvRowSet(url)) {
                    Map<String, Game> games = gameMapMapper(reader);
                    insertObjectList(Game.class, new ArrayList<>(games.values()));
                    Logger.logGameYearAdded(year);
                } catch (Exception e) {
                    Logger.logError(e);
                }
            }

        } catch (Exception e) {
            Logger.logError(e);
        }
    }

    private boolean gameExists(Game game) {
        String sql =
                "SELECT game_id " +
                "FROM game " +
                "WHERE game_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, game.getGame_id());
        return rowSet.next();
    }

    private void validateTeamsExist() throws Exception {
        int teamCount = teamDao.countTeams();
        if (teamCount == 0) {
            teamDao.createTeams();
        } else if (teamCount != 32) {
            throw new Exception("Error with team creation. Stopping Game import");
        }
    }

    public Integer getCurrentYear() {
        String sql =
                "SELECT MAX(season)\n" +
                "FROM game;";
        Integer max = jdbcTemplate.queryForObject(sql, Integer.class);
        return validateInteger(max);
    }

    private Map<String, Game> gameMapMapper(CsvRowSet reader) {
        Map<String, Game> games = new HashMap<>();
        try {
            while (reader.next()) {
                if (!games.containsKey(reader.getString("game_id"))) {
                    games.put(reader.getString("game_id"), objectMapper(Game.class, reader));
                }
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return games;
    }

}

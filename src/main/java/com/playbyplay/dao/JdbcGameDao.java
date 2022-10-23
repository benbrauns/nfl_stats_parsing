package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvReader;
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
                try (CsvReader reader = new CsvReader(url)) {
                    Map<String, Game> games = gameMapMapper(reader);
                    insertGameCollection(games.values());
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

    @Override
    public String insertGame(Game game) {
        if (gameExists(game)) return "";
        String sql =
                "INSERT INTO game (game_id, home_team, away_team, season, season_type, week, game_date) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                        "RETURNING game_id;";
        String id = jdbcTemplate.queryForObject(sql, String.class, game.getGame_id(), game.getHome_team(), game.getAway_team(), game.getSeason(), game.getSeason_type(), game.getWeek(), game.getGame_date());
        return validateString(id);
    }

    @Override
    public List<String> insertGameList(List<Game> games) {
        List<String> gameIds = new ArrayList<>();
        for (Game game : games) {
            gameIds.add(insertGame(game));
        }
        return gameIds;
    }

    private List<String> insertGameCollection(Collection<Game> games) {
        List<Game> gameList = new ArrayList<>(games);
        return insertGameList(gameList);
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


    private List<Integer> addedYears() {
        String sql =
                "SELECT DISTINCT season\n" +
                "FROM game;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        List<Integer> years = new ArrayList<>();
        try {
            years.add(rowSet.getInt("season"));
        } catch (Exception e) {
            Logger.logError(e);
        }
        return years;
    }

    private Map<String, Game> gameMapMapper(CsvReader reader) {
        Map<String, Game> games = new HashMap<>();
        try {
            while (reader.next()) {
                if (!games.containsKey(reader.getString("game_id"))) {
                    games.put(reader.getString("game_id"), gameMapper(reader));
                }
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return games;
    }


    private Game gameMapper(CsvReader reader) {
        Game game = new Game();
        try {
            game.setGame_id(reader.getString("game_id"));
            game.setHome_team(reader.getString("home_team"));
            game.setAway_team(reader.getString("away_team"));
            game.setSeason(reader.getInt("season"));
            game.setSeason_type(reader.getString("season_type"));
            game.setWeek(reader.getInt("week"));
            Date date = reader.getDate("game_date");
            if (date != null) {
               game.setGame_date(date.toLocalDate());
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return game;
    }

}

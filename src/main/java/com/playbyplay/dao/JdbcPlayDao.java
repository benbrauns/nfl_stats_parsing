package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvRowSet;
import com.playbyplay.model.Play;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.TreeMap;


public class JdbcPlayDao extends JdbcBaseDao implements PlayDao {
    JdbcGameDao gameDao;

    public JdbcPlayDao(DataSource dataSource) {
        super(dataSource);
        gameDao = new JdbcGameDao(dataSource);
    }

    @Override
    public void importPlays(List<String> pbpLinks) {
        try {
            for (String year : pbpLinks) {
                URL url = new URL(year);
                try {
                    CsvRowSet reader = new CsvRowSet(url);
                    List<Play> plays = objectListMapper(Play.class, reader);
                    insertObjectList(Play.class, plays);
                    Logger.logGameYearAdded(year);
                } catch (Exception e) {
                    Logger.logError(e);
                }
            }

        } catch (Exception e) {
            Logger.logError(e);
        }
    }

    @Override
    public List<Play> list() {
        String sql =
                "SELECT * " +
                "FROM play " +
                "LIMIT 50;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        return objectListMapper(Play.class, rowSet);
    }

    @Override
    public List<Play> list(int amount) {
        String sql =
                "SELECT * " +
                        "FROM play " +
                        "LIMIT ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, amount);
        return objectListMapper(Play.class, rowSet);
    }

    @Override
    public TreeMap<Integer, Integer> getYearlyPassingYardsByPlayer(String playerId) {
        String sql =
                "SELECT game.season, SUM(passing_yards) as yards " +
                "FROM play " +
                "JOIN game ON play.game_id = game.game_id " +
                "WHERE play.passer_player_id = ? " +
                "GROUP BY game.season";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, playerId);
        return mapYearlyIntRowSetToTreeMap(rowSet);
    }

    @Override
    public TreeMap<Integer, Integer> getYearlyRushingYardsByPlayer(String playerId) {
        String sql =
                "SELECT game.season, SUM(rushing_yards) as yards " +
                "FROM play " +
                "JOIN game ON play.game_id = game.game_id " +
                "WHERE play.rusher_player_id = ? " +
                "GROUP BY game.season";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, playerId);
        return mapYearlyIntRowSetToTreeMap(rowSet);
    }

    @Override
    public TreeMap<Integer, BigDecimal> getYearlyRushingEpaByPlayer(String playerId) {
        String sql =
                "SELECT game.season, SUM(epa) as yards " +
                        "FROM play " +
                        "JOIN game ON play.game_id = game.game_id " +
                        "WHERE play.rusher_player_id = ? " +
                        "AND rush_attempt = true " +
                        "GROUP BY game.season";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, playerId);
        return mapYearlyDecimalRowSetToTreeMap(rowSet);
    }

    private TreeMap<Integer, BigDecimal> mapYearlyDecimalRowSetToTreeMap(SqlRowSet rowSet) {
        TreeMap<Integer, BigDecimal> yards_by_year = new TreeMap<>();
        try {
            while (rowSet.next()) {
                yards_by_year.put(rowSet.getInt("season"), rowSet.getBigDecimal("yards"));
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return yards_by_year;
    }

    private TreeMap<Integer, Integer> mapYearlyIntRowSetToTreeMap(SqlRowSet rowSet) {
        TreeMap<Integer, Integer> yards_by_year = new TreeMap<>();
        try {
            while (rowSet.next()) {
                yards_by_year.put(rowSet.getInt("season"), rowSet.getInt("yards"));
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return yards_by_year;
    }
}

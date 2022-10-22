package com.playbyplay.dao;

import com.playbyplay.model.Play;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class JdbcPlayDao implements PlayDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Play test() {
        String sql =
                "SELECT * " +
                "FROM play " +
                "LIMIT 1;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        return playMapper(rowSet);
    }


    public int getPlayCountForTeamYear(String team, int year) {
        String sql =
                "SELECT COUNT(*) " +
                "FROM play " +
                "WHERE home_team = ?;";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, team);
        if (count != null) {
            return count;
        } else {
            return -1;
        }
    }

    private List<Play> playListMapper(SqlRowSet rowSet) {
        List<Play> plays = new ArrayList<>();
        while (rowSet.next()) {
            plays.add(playMapper(rowSet));
        }
        return plays;
    }

    private Play playMapper(SqlRowSet rowSet) {

        if (rowSet.next()) {
            Play play = new Play();
//            play.setPlay_id(rowSet.getDouble("play_id"));
//            play.setGame_id(rowSet.getString("game_id"));
//            play.setOld_game_id(rowSet.getString("old_game_id"));
//            play.setHome_team(rowSet.getString("home_team"));
//            play.setAway_team(rowSet.getString("away_team"));
//            play.setSeason_type(rowSet.getString("season_type"));
//            play.setWeek(rowSet.getInt("week"));
//            play.setPosTeam(rowSet.getString("posteam"));
//            play.setPosTeam_type(rowSet.getString("posteam_type"));
//            play.setDefTeam(rowSet.getString("defteam"));
//            play.setSide_of_field(rowSet.getString("side_of_field"));
//            play.setYardline_100(rowSet.getDouble("yardline_100"));
//            play.setGame_date(rowSet.getString("game_date"));
//            play.setQuarter_seconds_remaining(rowSet.getDouble("quarter_seconds_remaining"));
//            play.setHalf_seconds_remaining(rowSet.getDouble("half_seconds_remaining"));
//            play.setGame_seconds_remaining(rowSet.getDouble("game_seconds_remaining"));
//            play.setGame_half(rowSet.getString("game_half"));
//            play.setQuarter_end(rowSet.getDouble("quarter_end"));
            return play;
        }
        return null;
    }
}

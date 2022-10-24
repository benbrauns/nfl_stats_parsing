package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvReader;
import com.playbyplay.dao.importutil.ImportLogger;
import com.playbyplay.model.Game;
import com.playbyplay.model.Play;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JdbcPlayDao extends BaseDao implements PlayDao {
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
                try (CsvReader reader = new CsvReader(url)) {
                    List<Play> plays = playListMapper(reader);
                    plays.forEach(this::insertPlay);
                    System.out.println(plays.size());
                    Logger.logGameYearAdded(year);
                } catch (Exception e) {
                    Logger.logError(e);
                }
            }

        } catch (Exception e) {
            Logger.logError(e);
        }
    }

    private Map.Entry<String, Integer> insertPlay(Play play) {
        String sql =
                "INSERT INTO play (play_id, game_id, posteam, defteam, yardline_100, game_seconds_remaining, drive, qtr, down, ydstogo, ydsnet, play_desc, play_type, yards_gained, pass_location, run_location, run_gap, timeout_team, posteam_timeouts_remaining, defteam_timeouts_remaining, posteam_score, defteam_score, td_player_id, passer_player_id, air_yards, yards_after_catch, passing_yards, receiver_player_id, receiving_yards, rusher_player_id, rushing_yards, interception_player_id, punt_returner_player_id, kickoff_returner_player_id, punter_player_id, kicker_player_id, kick_distance, opp_fg_prob, opp_safety_prob, opp_td_prob, fg_prob, safety_prob, td_prob, extra_point_prob, two_point_conversion_prob, ep, epa, air_epa, yac_epa, wp, def_wp, wpa, vegas_wpa, vegas_wp, air_wpa, yac_wpa, timeout, shotgun, no_huddle, qb_dropback, qb_kneel, qb_spike, qb_scramble, punt_blocked, touchback, interception, fumble, fumble_forced, fumble_out_of_bounds, fumble_lost, solo_tackle, safety, penalty, qb_hit, rush_attmept, pass_attempt, sack, touchdown)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, \n" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                "RETURNING play_id, game_id;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,
                    play.getPlay_id(),
                    play.getGame_id(),
                    play.getPosteam(),
                    play.getDefteam(),
                    play.getYardline_100(),
                    play.getGame_seconds_remaining(),
                    play.getDrive(),
                    play.getQtr(),
                    play.getDown(),
                    play.getYdstogo(),
                    play.getYdsnet(),
                    play.getPlay_desc(),
                    play.getPlay_type(),
                    play.getYards_gained(),
                    play.getPass_location(),
                    play.getRun_location(),
                    play.getRun_gap(),
                    play.getTimeout_team(),
                    play.getPosteam_timeouts_remaining(),
                    play.getDefteam_timeouts_remaining(),
                    play.getPosteam_score(),
                    play.getDefteam_score(),
                    play.getTd_player_id(),
                    play.getPasser_player_id(),
                    play.getAir_yards(),
                    play.getYards_after_catch(),
                    play.getPassing_yards(),
                    play.getReceiver_player_id(),
                    play.getReceiving_yards(),
                    play.getRusher_player_id(),
                    play.getRushing_yards(),
                    play.getInterception_player_id(),
                    play.getPunt_returner_player_id(),
                    play.getKickoff_returner_player_id(),
                    play.getPunter_player_id(),
                    play.getKicker_player_id(),
                    play.getKick_distance(),
                    play.getOpp_fg_prob(),
                    play.getOpp_safety_prob(),
                    play.getOpp_td_prob(),
                    play.getFg_prob(),
                    play.getSafety_prob(),
                    play.getTd_prob(),
                    play.getExtra_point_prob(),
                    play.getTwo_point_conversion_prob(),
                    play.getEp(),
                    play.getEpa(),
                    play.getAir_epa(),
                    play.getYac_epa(),
                    play.getWp(),
                    play.getDef_wp(),
                    play.getWpa(),
                    play.getVegas_wpa(),
                    play.getVegas_wp(),
                    play.getAir_wpa(),
                    play.getYac_wpa(),
                    play.getTimeout(),
                    play.getShotgun(),
                    play.getNo_huddle(),
                    play.getQb_dropback(),
                    play.getQb_kneel(),
                    play.getQb_spike(),
                    play.getQb_scramble(),
                    play.getPunt_blocked(),
                    play.getTouchback(),
                    play.getInterception(),
                    play.getFumble(),
                    play.getFumble_forced(),
                    play.getFumble_out_of_bounds(),
                    play.getFumble_lost(),
                    play.getSolo_tackle(),
                    play.getSafety(),
                    play.getPenalty(),
                    play.getQb_hit(),
                    play.getRush_attmept(),
                    play.getPass_attempt(),
                    play.getSack(),
                    play.getTouchdown()
            );

            if (rowSet.next()) {
                return new AbstractMap.SimpleEntry<>(rowSet.getString("game_id"), rowSet.getInt("play_id"));
            }
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }


    private List<Play> playListMapper(ResultSet rowSet) {
        List<Play> plays = new ArrayList<>();
        try {
            while (rowSet.next()) {
                plays.add(playMapper(rowSet));
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return plays;
    }

    private Play playMapper(ResultSet rowSet) {
        try {
            Play play = new Play();
            play.setPlay_id(rowSet.getInt("play_id"));
            play.setGame_id(rowSet.getString("game_id"));
            play.setPosteam(rowSet.getString("posteam"));
            play.setDefteam(rowSet.getString("defteam"));
            play.setYardline_100(rowSet.getInt("yardline_100"));
            play.setGame_seconds_remaining(rowSet.getInt("game_seconds_remaining"));
            play.setDrive(rowSet.getInt("drive"));
            play.setQtr(rowSet.getInt("qtr"));
            play.setDown(rowSet.getInt("down"));
            play.setYdstogo(rowSet.getInt("ydstogo"));
            play.setYdsnet(rowSet.getInt("ydsnet"));
            play.setPlay_desc(rowSet.getString("desc"));
            play.setPlay_type(rowSet.getString("play_type"));
            play.setYards_gained(rowSet.getInt("yards_gained"));
            play.setPass_location(rowSet.getString("pass_location"));
            play.setRun_location(rowSet.getString("run_location"));
            play.setRun_gap(rowSet.getString("run_gap"));
            play.setTimeout_team(rowSet.getString("timeout_team"));
            play.setPosteam_timeouts_remaining(rowSet.getInt("posteam_timeouts_remaining"));
            play.setDefteam_timeouts_remaining(rowSet.getInt("defteam_timeouts_remaining"));
            play.setPosteam_score(rowSet.getInt("posteam_score"));
            play.setDefteam_score(rowSet.getInt("defteam_score"));
            play.setTd_player_id(rowSet.getString("td_player_id"));
            play.setPasser_player_id(rowSet.getString("passer_player_id"));
            play.setAir_yards(rowSet.getInt("air_yards"));
            play.setYards_after_catch(rowSet.getInt("yards_after_catch"));
            play.setPassing_yards(rowSet.getInt("passing_yards"));
            play.setReceiver_player_id(rowSet.getString("receiver_player_id"));
            play.setReceiving_yards(rowSet.getInt("receiving_yards"));
            play.setRusher_player_id(rowSet.getString("rusher_player_id"));
            play.setRushing_yards(rowSet.getInt("rushing_yards"));
            play.setInterception_player_id(rowSet.getString("interception_player_id"));
            play.setPunt_returner_player_id(rowSet.getString("punt_returner_player_id"));
            play.setKickoff_returner_player_id(rowSet.getString("kickoff_returner_player_id"));
            play.setPunter_player_id(rowSet.getString("punter_player_id"));
            play.setKicker_player_id(rowSet.getString("kicker_player_id"));
            play.setKick_distance(rowSet.getInt("kick_distance"));
            play.setOpp_fg_prob(rowSet.getBigDecimal("opp_fg_prob"));
            play.setOpp_safety_prob(rowSet.getBigDecimal("opp_safety_prob"));
            play.setOpp_td_prob(rowSet.getBigDecimal("opp_td_prob"));
            play.setFg_prob(rowSet.getBigDecimal("fg_prob"));
            play.setSafety_prob(rowSet.getBigDecimal("safety_prob"));
            play.setTd_prob(rowSet.getBigDecimal("td_prob"));
            play.setExtra_point_prob(rowSet.getBigDecimal("extra_point_prob"));
            play.setTwo_point_conversion_prob(rowSet.getBigDecimal("two_point_conversion_prob"));
            play.setEp(rowSet.getBigDecimal("ep"));
            play.setEpa(rowSet.getBigDecimal("epa"));
            play.setAir_epa(rowSet.getBigDecimal("air_epa"));
            play.setYac_epa(rowSet.getBigDecimal("yac_epa"));
            play.setWp(rowSet.getBigDecimal("wp"));
            play.setWpa(rowSet.getBigDecimal("wpa"));
            play.setVegas_wpa(rowSet.getBigDecimal("vegas_wpa"));
            play.setVegas_wp(rowSet.getBigDecimal("vegas_wp"));
            play.setAir_wpa(rowSet.getBigDecimal("air_wpa"));
            play.setYac_epa(rowSet.getBigDecimal("yac_wpa"));
            play.setTimeout(rowSet.getBoolean("timeout"));
            play.setShotgun(rowSet.getBoolean("shotgun"));
            play.setNo_huddle(rowSet.getBoolean("no_huddle"));
            play.setQb_dropback(rowSet.getBoolean("qb_dropback"));
            play.setQb_kneel(rowSet.getBoolean("qb_kneel"));
            play.setQb_spike(rowSet.getBoolean("qb_spike"));
            play.setQb_scramble(rowSet.getBoolean("qb_scramble"));
            play.setPunt_blocked(rowSet.getBoolean("punt_blocked"));
            play.setTouchback(rowSet.getBoolean("touchback"));
            play.setInterception(rowSet.getBoolean("interception"));
            play.setFumble(rowSet.getBoolean("fumble"));
            play.setFumble_forced(rowSet.getBoolean("fumble_forced"));
            play.setFumble_out_of_bounds(rowSet.getBoolean("fumble_out_of_bounds"));
            play.setFumble_lost(rowSet.getBoolean("fumble_lost"));
            play.setSolo_tackle(rowSet.getBoolean("solo_tackle"));
            play.setSafety(rowSet.getBoolean("safety"));
            play.setPenalty(rowSet.getBoolean("penalty"));
            play.setQb_hit(rowSet.getBoolean("qb_hit"));
            play.setRush_attmept(rowSet.getBoolean("rush_attempt"));
            play.setPass_attempt(rowSet.getBoolean("pass_attempt"));
            play.setSack(rowSet.getBoolean("sack"));
            play.setTouchdown(rowSet.getBoolean("touchdown"));
            return play;
        } catch (Exception e) {
            ImportLogger.logError(e);
        }
        return null;
    }
}

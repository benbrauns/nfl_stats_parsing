package com.playbyplay.dao;

import com.playbyplay.model.Play;
import com.playbyplay.model.Player;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeMap;

public interface PlayDao extends BaseDao {
    void importPlays(List<String> pbpLinks);

    /**
     * @return list of all the plays with a limit of 50
     */
    List<Play> list();

    /**
     * @param amount the number of plays to return
     * @return list of the amount of plays
     */
    List<Play> list(int amount);

    TreeMap<Integer, Integer> getYearlyPassingYardsByPlayer(String playerId);

    TreeMap<Integer, Integer> getYearlyRushingYardsByPlayer(String playerId);

    TreeMap<Integer, BigDecimal> getYearlyRushingEpaByPlayer(String playerId);

    //TreeMap<Integer, Integer> getYearlyRushGameCountByPlayer(String playerId);



}

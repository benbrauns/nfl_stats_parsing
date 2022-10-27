package com.playbyplay.model.stats;

import com.playbyplay.dao.PlayDao;
import com.playbyplay.model.Player;

import java.util.TreeMap;

public class RushingStats extends Stats implements PlayerStats{
    public RushingStats(String playerId, PlayDao playDao) {
        super(playerId, playDao);
        getRushingStats();
    }

    public void getRushingStats() {
        super.setYardsPerYear(playDao.getYearlyRushingYardsByPlayer(playerId));
        super.setEpaPerYear(playDao.getYearlyRushingEpaByPlayer(playerId));
    }



}

package com.playbyplay.model.stats;

import com.playbyplay.dao.PlayDao;

public class PassingStats extends Stats implements PlayerStats {

    public PassingStats(String playerId, PlayDao playDao) {
        super(playerId, playDao);
        super.setYardsPerYear(playDao.getYearlyPassingYardsByPlayer(playerId));
    }

}

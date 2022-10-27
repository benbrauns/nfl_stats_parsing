package com.playbyplay.model.stats;

import com.playbyplay.dao.PlayDao;

import java.math.BigDecimal;
import java.util.TreeMap;

public abstract class Stats {
    protected String playerId;
    private TreeMap<Integer, Integer> yardsPerYear;
    private TreeMap<Integer, BigDecimal> epaPerYear;
    protected PlayDao playDao;

    public TreeMap<Integer, BigDecimal> getEpaPerYear() {
        return epaPerYear;
    }

    public void setEpaPerYear(TreeMap<Integer, BigDecimal> epaPerYear) {
        this.epaPerYear = epaPerYear;
    }

    public TreeMap<Integer, Integer> getYardsPerYear() {
        return yardsPerYear;
    }

    public void setYardsPerYear(TreeMap<Integer, Integer> yardsPerYear) {
        this.yardsPerYear = yardsPerYear;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Stats(String playerId, PlayDao playDao) {
        this.playerId = playerId;
        this.playDao = playDao;
    }


}

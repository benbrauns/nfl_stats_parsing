package com.playbyplay.model;

import java.time.LocalDate;

public class Game {
    private String game_id;
    private String home_team;
    private String away_team;
    private int season;
    private String season_type;
    private int week;
    private LocalDate game_date;

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getSeason_type() {
        return season_type;
    }

    public void setSeason_type(String season_type) {
        this.season_type = season_type;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public LocalDate getGame_date() {
        return game_date;
    }

    public void setGame_date(LocalDate game_date) {
        this.game_date = game_date;
    }
}

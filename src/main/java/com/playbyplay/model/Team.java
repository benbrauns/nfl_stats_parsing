package com.playbyplay.model;

public class Team {
    private int team_id;
    private String name;
    private String abbr;
    private String conference;
    private String divison;

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivison() {
        return divison;
    }

    public void setDivison(String divison) {
        this.divison = divison;
    }


    public Team() {

    };

    public Team(String name, String abbr, String conference, String divison) {
        this.name = name;
        this.abbr = abbr;
        this.conference = conference;
        this.divison = divison;
    }
}

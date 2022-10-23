package com.playbyplay.model;
import java.net.URL;
import java.time.LocalDate;

public class Player {
    private String status;
    private String display_name;
    private String first_name;
    private String last_name;
    private String esb_id;
    private String gsis_id;
    private String suffix;
    private LocalDate birth_date;
    private String college_name;
    private String position_group;
    private String position;
    private Integer jersey_number;
    //feet, inches
    private String height;
    private Integer weight;
    private String team_abbr;
    private String team_seq;
    private String current_team_id;
    private String football_name;
    private Integer entry_year;
    private Integer rookie_year;
    private String draft_club;
    private String college_conference;
    private String status_description_abbr;
    private String status_short_description;
    private Integer gsis_it_id;
    private String short_name;
    private String smart_id;
    private String headshot;
    private Integer draft_number;
    private String uniform_number;
    private Integer draft_round;
    private Integer season;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEsb_id() {
        return esb_id;
    }

    public void setEsb_id(String esb_id) {
        this.esb_id = esb_id;
    }

    public String getGsis_id() {
        return gsis_id;
    }

    public void setGsis_id(String gsis_id) {
        this.gsis_id = gsis_id;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getPosition_group() {
        return position_group;
    }

    public void setPosition_group(String position_group) {
        this.position_group = position_group;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getJersey_number() {
        return jersey_number;
    }

    public void setJersey_number(Integer jersey_number) {
        this.jersey_number = jersey_number;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getTeam_abbr() {
        return team_abbr;
    }

    public void setTeam_abbr(String team_abbr) {
        this.team_abbr = team_abbr;
    }

    public String getTeam_seq() {
        return team_seq;
    }

    public void setTeam_seq(String team_seq) {
        this.team_seq = team_seq;
    }

    public String getCurrent_team_id() {
        return current_team_id;
    }

    public void setCurrent_team_id(String current_team_id) {
        this.current_team_id = current_team_id;
    }

    public String getFootball_name() {
        return football_name;
    }

    public void setFootball_name(String football_name) {
        this.football_name = football_name;
    }

    public Integer getEntry_year() {
        return entry_year;
    }

    public void setEntry_year(Integer entry_year) {
        this.entry_year = entry_year;
    }

    public Integer getRookie_year() {
        return rookie_year;
    }

    public void setRookie_year(Integer rookie_year) {
        this.rookie_year = rookie_year;
    }

    public String getDraft_club() {
        return draft_club;
    }

    public void setDraft_club(String draft_club) {
        this.draft_club = draft_club;
    }

    public String getCollege_conference() {
        return college_conference;
    }

    public void setCollege_conference(String college_conference) {
        this.college_conference = college_conference;
    }

    public String getStatus_description_abbr() {
        return status_description_abbr;
    }

    public void setStatus_description_abbr(String status_description_abbr) {
        this.status_description_abbr = status_description_abbr;
    }

    public String getStatus_short_description() {
        return status_short_description;
    }

    public void setStatus_short_description(String status_short_description) {
        this.status_short_description = status_short_description;
    }

    public Integer getGsis_it_id() {
        return gsis_it_id;
    }

    public void setGsis_it_id(Integer gsis_it_id) {
        this.gsis_it_id = gsis_it_id;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getSmart_id() {
        return smart_id;
    }

    public void setSmart_id(String smart_id) {
        this.smart_id = smart_id;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public Integer getDraft_number() {
        return draft_number;
    }

    public void setDraft_number(Integer draft_number) {
        this.draft_number = draft_number;
    }

    public String getUniform_number() {
        return uniform_number;
    }

    public void setUniform_number(String uniform_number) {
        this.uniform_number = uniform_number;
    }

    public Integer getDraft_round() {
        return draft_round;
    }

    public void setDraft_round(Integer draft_round) {
        this.draft_round = draft_round;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }


    @Override
    public String toString() {
        return this.display_name;
    }
}

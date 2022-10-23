package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvReader;
import com.playbyplay.model.Team;

import javax.sql.DataSource;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTeamDao extends BaseDao implements TeamDao {


    public JdbcTeamDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createTeams() {
        File teamFile = new File("src/main/resources/teams.csv");
        try (CsvReader reader = new CsvReader(teamFile.toURI().toURL())) {
            List<Team> teams = teamListMapper(reader);
            insertTeamList(teams);
        } catch (Exception e) {
            Logger.logError(e);
        }
    }

    @Override
    public Integer getTeamIdFromAbbr(String abbr) {
        //System.out.println(abbr);
        try {
            String sql =
                    "SELECT team_id " +
                            "FROM team " +
                            "WHERE abbr = ?;";
            Integer team_id = jdbcTemplate.queryForObject(sql, Integer.class, abbr);
            return validateInteger(team_id);
        } catch (Exception e) {
            Logger.logError(e);
        }
        return -1;
    }

    @Override
    public Integer countTeams() {
        String sql =
                "SELECT COUNT(*) " +
                "FROM team;";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return validateInteger(count);
    }

    private List<Team> teamListMapper(ResultSet rowSet) {
        List<Team> teams = new ArrayList<>();
        try {
            while (rowSet.next()) {
                teams.add(teamMapper(rowSet));
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
        return teams;
    }

    private Team teamMapper(ResultSet rowSet) {
        Team team = new Team();
        try {
            try {
                rowSet.findColumn("team_id");
                team.setTeam_id(rowSet.getInt("team_id"));
            } catch (Exception e) {
                //This is just here so that we can use one mapping method for
                //the initial creation of the teams too
                team.setTeam_id(0);
            }
            team.setName(rowSet.getString("name"));
            team.setAbbr(rowSet.getString("abbr"));
            team.setConference(rowSet.getString("conference"));
            team.setDivison(rowSet.getString("division"));
        } catch (Exception e) {
            Logger.logError(e);
        }
        return team;
    }

    @Override
    public Boolean teamExists(Team team) {
        String sql =
                "SELECT COUNT(*) " +
                "FROM team " +
                "WHERE abbr = ?;";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, team.getAbbr());
        if (count == null) return false;
        return count > 0;
    }

    @Override
    public Integer insertTeam(Team team) {
        if (teamExists(team)) {
            return -1;
        }

        String sql =
                "INSERT INTO team (name, abbr, conference, division) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING team_id;";
        Integer team_id = jdbcTemplate.queryForObject(sql, Integer.class, team.getName(), team.getAbbr(), team.getConference(), team.getDivison());
        return validateInteger(team_id);
    }

    @Override
    public List<Integer> insertTeamList(List<Team> teams) {
        List<Integer> team_ids = new ArrayList<>();
        for (Team team : teams) {
            team_ids.add(insertTeam(team));
        }
        return team_ids;
    }
}

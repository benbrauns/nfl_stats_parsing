package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvRowSet;
import com.playbyplay.model.Team;

import javax.sql.DataSource;
import java.io.File;
import java.util.List;

public class JdbcTeamDao extends BaseDao implements TeamDao {


    public JdbcTeamDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createTeams() {
        File teamFile = new File("src/main/resources/teams.csv");
        try (CsvRowSet reader = new CsvRowSet(teamFile.toURI().toURL())) {
            List<Team> teams = objectListMapper(Team.class, reader);
            insertObjectList(Team.class, teams);
        } catch (Exception e) {
            Logger.logError(e);
        }
    }

    @Override
    public Integer countTeams() {
        String sql =
                "SELECT COUNT(*) " +
                "FROM team;";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return validateInteger(count);
    }
}

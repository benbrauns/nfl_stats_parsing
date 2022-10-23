package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvReader;
import com.playbyplay.model.Team;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

public interface TeamDao {
    /**
     * Inserts all of the team rows into the database
     */
    void createTeams();

    /**
     * Takes in a team, adds it to the database, and returns the team_id.
     * Will return -1 if it wasn't added or already exists.
     *
     * @param team a team DAO object
     * @return an Integer of either the team_id or -1
     */
    Integer insertTeam(Team team);

    /**
     * Takes a list of teams, adds them to the database, and returns a list of
     * team_id's corresponding to each item in the list. Will return -1 if it wasn't added or already exists.
     *
     * @param teams a list of Team to be added to the database
     * @return a List of Integer of either the team_id or -1
     */
    List<Integer> insertTeamList(List<Team> teams);

    /**
     * Takes a team and uses its abbreviation to check if it already exists in the database
     *
     * @param team the team to check
     * @return whether that records has been added to the database
     */
    Boolean teamExists(Team team);

    /**
     * Takes the string of team abbreviation and returns the team_id
     *
     * @param abbr 'GB', 'KC', 'DEN'
     * @return Integer of the team_id
     */
    Integer getTeamIdFromAbbr(String abbr);

    /**
     * @return Integer count of teams in the database
     */
    Integer countTeams();
}

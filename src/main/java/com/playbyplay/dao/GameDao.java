package com.playbyplay.dao;

import com.playbyplay.model.Game;

import java.util.List;

public interface GameDao {

    /**
     * Takes in a list of links to the play by play data and parses that data for
     * the games to be imported into the database
     * @param pbpLinks
     */
    void importGames(List<String> pbpLinks);

    String insertGame(Game game);

    List<String> insertGameList(List<Game> games);


}

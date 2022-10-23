package com.playbyplay.dao;

import com.playbyplay.model.Player;

public interface PlayerDao {
    /**
     * Uses the nflfastR github repository to check for players not in the database.
     * If it finds any it adds them.
     */
    void updatePlayersFromSourceCsv();

    /**
     * Get the player_id of a player if they exist and -1 if they don't
     *
     * @param player
     * @return int player_id if they exist and -1 if they dont
     */
    int playerExists(Player player);


    /**
     * Inserts a player into the database returns the player_id of the inserted player's player_id. If the player already is in the database return -1
     * @param player
     * @return an integer for the player_id of the inserted player
     */
    int insertPlayer(Player player);
}

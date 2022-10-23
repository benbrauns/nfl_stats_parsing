package com.playbyplay.dao;

import com.playbyplay.model.Player;

public interface PlayerDao {
    /**
     * Uses the nflfastR github repository to check for players not in the database.
     * If it finds any it adds them.
     */
    void updatePlayersFromSourceCsv();

    /**
     * @param player
     * @return String gsis_id if they exist and empty if they don't
     */
    String playerExists(Player player);


    /**
     * @param player
     * @return String gsis_id for the inserted player or empty for error
     */
    String insertPlayer(Player player);
}

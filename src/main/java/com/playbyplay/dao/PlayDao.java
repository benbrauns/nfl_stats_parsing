package com.playbyplay.dao;

import com.playbyplay.model.Play;

import java.util.List;

public interface PlayDao extends BaseDao {
    void importPlays(List<String> pbpLinks);

    /**
     * @return list of all the plays with a limit of 50
     */
    List<Play> list();

    /**
     * @param amount the number of plays to return
     * @return list of the amount of plays
     */
    List<Play> list(int amount);



}

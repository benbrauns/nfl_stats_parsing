package com.playbyplay.controller;

import com.playbyplay.dao.JdbcPlayDao;
import com.playbyplay.dao.JdbcPlayerDao;
import com.playbyplay.dao.PlayDao;
import com.playbyplay.dao.PlayerDao;
import com.playbyplay.model.stats.PassingStats;
import com.playbyplay.model.stats.PlayerStats;
import com.playbyplay.model.stats.RushingStats;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private PlayerDao playerDao;
    private PlayDao playDao;

    public StatsController() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/NFL_PBP");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        playDao = new JdbcPlayDao(dataSource);
        playerDao = new JdbcPlayerDao(dataSource);
    }

    @RequestMapping(path = "/passing/yearly/{playerId}", method = RequestMethod.GET)
    public PlayerStats getYearlyPassingYards(@PathVariable String playerId) {
        if (playerId.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "player_id not found");
        }
        return new PassingStats(playerId, playDao);
    }

    @RequestMapping(path = "/rushing/yearly/{playerId}", method = RequestMethod.GET)
    public PlayerStats getYearlyRushingStats(@PathVariable String playerId) {
        if (playerId.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "player_id not found");
        }
        return new RushingStats(playerId, playDao);
    }

    @RequestMapping(path = "/receiving/yearly/{playerId}", method = RequestMethod.GET)
    public PlayerStats getYearlyReceivingStats(@PathVariable String playerId) {
        if (playerId.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "player_id not found");
        }
        return new RushingStats(playerId, playDao);
    }
}

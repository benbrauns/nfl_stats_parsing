package com.playbyplay.controller;


import com.playbyplay.dao.JdbcPlayDao;
import com.playbyplay.dao.JdbcPlayerDao;
import com.playbyplay.dao.PlayDao;
import com.playbyplay.dao.PlayerDao;
import com.playbyplay.model.Player;
import com.playbyplay.model.stats.PassingStats;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.TreeMap;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerDao playerDao;
    private PlayDao playDao;

    public PlayerController() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/NFL_PBP");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        playDao = new JdbcPlayDao(dataSource);
        playerDao = new JdbcPlayerDao(dataSource);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Player> list(@RequestParam(name = "display_name",defaultValue = "")  String displayName) {
        if (!displayName.isBlank()) {
            return playerDao.listByDisplayName(displayName);
        }
        return playerDao.list();
    }
}

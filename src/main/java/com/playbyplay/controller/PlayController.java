package com.playbyplay.controller;

import com.playbyplay.dao.JdbcPlayDao;
import com.playbyplay.dao.PlayDao;
import com.playbyplay.model.Play;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plays")
public class PlayController {

    private PlayDao playDao;

    public PlayController() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/NFL_PBP");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        playDao = new JdbcPlayDao(dataSource);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Play> list(@RequestParam(defaultValue = "0") Integer count) {
        if (count != 0) {
            return playDao.list(count);
        }
        return playDao.list();
    }

    @RequestMapping(path = "/find", method = RequestMethod.GET)
    public String list(@RequestParam MultiValueMap<String, String> params) {
        StringBuilder out = new StringBuilder();
        for (Map.Entry<String, List<String>> param : params.entrySet()) {
            out.append(param.getKey());
            out.append(" = ");
            for (String val : param.getValue()) {
                out.append(val);
            }
            out.append("\n");
        }
        return out.toString();
    }


}

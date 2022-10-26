package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvRowSet;
import com.playbyplay.model.Play;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;


public class JdbcPlayDao extends JdbcBaseDao implements PlayDao {
    JdbcGameDao gameDao;

    public JdbcPlayDao(DataSource dataSource) {
        super(dataSource);
        gameDao = new JdbcGameDao(dataSource);
    }

    @Override
    public void importPlays(List<String> pbpLinks) {
        try {
            for (String year : pbpLinks) {
                URL url = new URL(year);
                try {
                    CsvRowSet reader = new CsvRowSet(url);
                    List<Play> plays = objectListMapper(Play.class, reader);
                    insertObjectList(Play.class, plays);
                    Logger.logGameYearAdded(year);
                } catch (Exception e) {
                    Logger.logError(e);
                }
            }

        } catch (Exception e) {
            Logger.logError(e);
        }
    }

    @Override
    public List<Play> list() {
        String sql =
                "SELECT * " +
                "FROM play " +
                "LIMIT 50;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        return objectListMapper(Play.class, rowSet);
    }

    @Override
    public List<Play> list(int amount) {
        String sql =
                "SELECT * " +
                        "FROM play " +
                        "LIMIT ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, amount);
        return objectListMapper(Play.class, rowSet);
    }
}

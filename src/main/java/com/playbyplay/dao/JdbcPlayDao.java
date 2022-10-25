package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvRowSet;
import com.playbyplay.dao.importutil.ImportLogger;
import com.playbyplay.model.Play;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JdbcPlayDao extends BaseDao implements PlayDao {
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
                try (CsvRowSet reader = new CsvRowSet(url)) {
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
}

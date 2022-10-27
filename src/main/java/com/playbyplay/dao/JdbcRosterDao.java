package com.playbyplay.dao;

import com.playbyplay.Logger;
import com.playbyplay.dao.importutil.CsvRowSet;
import com.playbyplay.model.Game;
import com.playbyplay.model.Roster;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcRosterDao extends JdbcBaseDao implements RosterDao{
    public JdbcRosterDao(DataSource dataSource) {
        super(dataSource);
    }

    public void importPlays(List<String> rosterLinks) {
        try {
            for (String year : rosterLinks) {
                URL url = new URL(year);
                try {
                    CsvRowSet reader = new CsvRowSet(url);
                    List<Roster> rosters = objectListMapper(Roster.class, reader);
                    insertObjectList(Roster.class, rosters);
                } catch (Exception e) {
                    Logger.logError(e);
                }
            }

        } catch (Exception e) {
            Logger.logError(e);
        }
    }

}

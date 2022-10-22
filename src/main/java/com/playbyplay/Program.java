package com.playbyplay;

import com.playbyplay.dao.DataImporter;
import com.playbyplay.dao.JdbcPlayDao;
import com.playbyplay.model.Play;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class Program {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/NFL_PBP");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        DataImporter dataImporter = new DataImporter(dataSource);
        dataImporter.updateDatabase();





    }
}

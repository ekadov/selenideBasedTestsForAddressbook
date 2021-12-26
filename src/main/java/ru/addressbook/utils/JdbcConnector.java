package ru.addressbook.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcConnector {

    private static final Logger LOGGER = LogManager.getLogger(JdbcConnector.class);
    private static JdbcTemplate jdbcTemplate;

    private JdbcConnector() {
        throw new IllegalStateException();
    }

    private static DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(ConfProperties.getJdbcDriver());
        dataSource.setUrl(ConfProperties.getDbUrl());
        dataSource.setUsername(ConfProperties.getDbUsername());
        dataSource.setPassword(ConfProperties.getDbPassword());
        return dataSource;
    }

    public static JdbcTemplate getJdbcTemplate() {
        try {
            jdbcTemplate = new JdbcTemplate(mysqlDataSource());
        } catch (Exception e) {
            LOGGER.error("Error connecting to database");
        }
        return jdbcTemplate;
    }
}

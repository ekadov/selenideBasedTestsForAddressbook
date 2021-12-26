package ru.addressbook.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataPreparation {

    public static void clearDataFromAddressbookTable() {
        SqlQueries sqlQuery = new SqlQueries();
        JdbcConnector.getJdbcTemplate().execute(sqlQuery.getClearAddressbookTable());
    }

    public static void addNewContactToDatabase(int id) {
        SqlQueries sqlQuery = new SqlQueries();
        JdbcConnector.getJdbcTemplate().execute(sqlQuery.getAddNewContact(id));
    }

}

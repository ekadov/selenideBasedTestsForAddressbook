package ru.addressbook.utils;

public class SqlQueries {

    private static final String SELECT_FIRST_NAMES = "SELECT firstname FROM addressbook;";
    private static final String SELECT_LAST_NAMES = "SELECT lastname FROM addressbook;";
    private static final String CLEAR_ADDRESSBOOK_TABLE = "TRUNCATE TABLE addressbook;";
    private int id;
    private final String ADD_NEW_CONTACT = "INSERT INTO addressbook VALUES" +
            "(0, " +
            id +
            ", " +
            "'" + GenerateData.generateFirstName() + "', " +
            "'', " +
            "'" + GenerateData.generateLastName() + "', " +
            "'" + GenerateData.generateNickName() + "', " +
            "'', '', '', " +
            "NULL, NULL, NULL, " +
            "'', '', '', '', '', '', '', '', '', '', '', 0, '-', '', 0, '-', '', '', '', '', '', NULL, NULL, " +
            "'" + GenerateData.generateCurrentDate() + "', " +
            "'" + GenerateData.generateCurrentDate() + "', " +
            "NULL, " +
            "NULL, NULL, NULL);";

    public String getSelectFirstNames() {
        return SELECT_FIRST_NAMES;
    }

    public String getSelectLastNames() {
        return SELECT_LAST_NAMES;
    }

    public String getClearAddressbookTable() {
        return CLEAR_ADDRESSBOOK_TABLE;
    }

    public String getAddNewContact(int id) {
        this.id = id;
        return ADD_NEW_CONTACT;
    }

}

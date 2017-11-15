package com.sabel.sqlite.login;

import java.sql.*;

public class LoginService {

    private static final String URL = "jdbc:sqlite:d:\\wagenhuberg\\sqlite\\personen.sqlite";

    private Connection connection;

    public LoginService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public boolean login(String loginname, String password) throws SQLException {

        String sqlLoginName = "select loginname from login where loginname = " + loginname;
        String sqlPassword = "select password from login where loginname = " + loginname;

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sqlLoginName);

        //String loginNameFromDB = null;
        String passwwordFromDB = null;

        if (resultSet.next()) {
            //loginNameFromDB = resultSet.getString(loginname);
            ResultSet resultSet2 = statement.executeQuery(sqlPassword);
            passwwordFromDB = resultSet2.getString("password");
            if (password == passwwordFromDB) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws SQLException{
        LoginService loginService = new LoginService();
        loginService.login("wagenhuber","guenther");
    }
}

package com.sabel.sqlite.login;

import javax.swing.*;
import java.sql.*;

public class LoginService {

    private static final String URL = "jdbc:sqlite:\\d:Personen.sqlite";

    private Connection connection;

    public LoginService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    //unsicher: SQL Injektion möglich!!!
    public boolean login(String loginname, String password) throws SQLException {
        String sql = "SELECT loginname, password FROM login WHERE loginname = '" + loginname.toLowerCase() + "' AND password = '" + password + "'";
        System.out.println(sql);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.next();
    }

    //Sicher: mit Prepared Statements!
    public boolean einloggen(String loginname, String password) throws SQLException {
        String sql = "SELECT loginname, password FROM login WHERE loginname = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, loginname.toLowerCase());
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public boolean einloggen(Login login){

    }

    public static void main(String[] args) throws SQLException {
        LoginService loginService = new LoginService();
        String sqlInjection = "' OR '1' = '1";
//        if (loginService.login("root", sqlInjection)) {
//            System.out.println("Login erfolgreich!");
//        } else {
//            System.out.println("Kein Login!");
//        }
//        boolean isLoggedIn = false;
//        do {
//            String loginname = JOptionPane.showInputDialog(null, "Bitte Loginname eingeben: ");
//            String password = JOptionPane.showInputDialog(null, "Bitte Passwort eingeben: ");
//            isLoggedIn = loginService.login(loginname, password);
//        } while (!isLoggedIn);
//        System.out.println("Login erfolgreich");

        if (loginService.einloggen("Maier", sqlInjection)){
            System.out.println("Login erfolgreich!");
        } else {
            System.out.println("Kein Login!");
        }


        loginService.close();
    }
}
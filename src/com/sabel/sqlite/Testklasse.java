package com.sabel.sqlite;

import java.sql.*;

public class Testklasse {

    public static void main(String[] args) throws SQLException {

        Person person = new Person("Wagenhuber", 1985);
        Person person1 = new Person("Mustermann", 1950);


        System.out.println(person);
        System.out.println(person1);


        Connection connection = DriverManager.getConnection("jdbc:sqlite:d:\\wagenhuberg\\sqlite\\test.sqlite");
        Statement statement = connection.createStatement();

        statement.executeUpdate("INSERT INTO Person VALUES(" + person.getId() + ", '" + person.getNachname() + "', " + person.getJahrgang() + ")");
        statement.executeUpdate("INSERT INTO Person VALUES(" + person1.getId() + ", '" + person1.getNachname() + "', " + person1.getJahrgang() + ")");

        System.out.println("erfolgreich gespeichert");
        statement.close();
        connection.close();

        connection = DriverManager.getConnection("jdbc:sqlite:d:\\wagenhuberg\\sqlite\\test.sqlite");
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, nachname, jahrgang FROM Person");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("nachname");
            int jahrgang = resultSet.getInt("jahrgang");
            System.out.println(id + ": Name: " + name + ", Jahrgang: " + jahrgang);
        }
        resultSet.close();
        statement.close();
        connection.close();


    }

}

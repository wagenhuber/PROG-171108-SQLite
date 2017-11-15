package com.sabel.sqlite;

import java.sql.*;

public class PersonService {

    private static final String URL = "jdbc:sqlite:d:\\wagenhuberg\\sqlite\\personen.sqlite";
    private Statement statement;

    private Connection connection;

    public PersonService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.statement = connection.createStatement();
    }

    public void save(Person person) throws SQLException {

        String sql = "INSERT INTO Person VALUES(" + person.getId() + ", '" + person.getNachname() + "', " + person.getJahrgang() + ")";
        this.statement.executeQuery(sql);
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        statement = null;

        if (connection != null) {
            connection.close();
        }
    }

    public Person readPerson(int id) throws SQLException{
        String sql = "select id, nachname,jahrgang from Person where id = " + id;

        ResultSet resultSet = statement.executeQuery(sql);

        Person person = null;

        if(resultSet.next()){

            int idFromDB = resultSet.getInt(1);
            String name = resultSet.getString("nachname");
            int jahrgang = resultSet.getInt("jahrgang");
            person = new Person(idFromDB, name, jahrgang);
        }

        return person;
    }


}

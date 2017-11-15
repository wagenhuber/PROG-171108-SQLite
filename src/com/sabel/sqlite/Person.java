package com.sabel.sqlite;

public class Person {

    private static int letzteID = 0;

    private int id;
    private String nachname;
    private int jahrgang;


    public Person() {
        super();
        this.id = ++letzteID;
    }

    public Person(int id, String nachname, int jahrgang) {
        this();
        this.nachname = nachname;
        this.jahrgang = jahrgang;
    }

    public int getId() {
        return id;
    }

    public String getNachname() {
        return nachname;
    }

    public int getJahrgang() {
        return jahrgang;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (jahrgang != person.jahrgang) return false;
        return nachname != null ? nachname.equals(person.nachname) : person.nachname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + jahrgang;
        return result;
    }

    @Override
    public String toString() {
        return "Person: " + this.id + ", Name: " + nachname + ", Jahrgang: " + this.jahrgang;
    }
}

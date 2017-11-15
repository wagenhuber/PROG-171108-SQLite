package com.sabel.sqlite.login;

public class Login {


    private String loginname;
    private String password;

    public Login(String loginname, String password) {
        this.loginname = loginname;
        this.password = password;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login = (Login) o;

        if (loginname != null ? !loginname.equals(login.loginname) : login.loginname != null) return false;
        return password != null ? password.equals(login.password) : login.password == null;
    }

    @Override
    public int hashCode() {
        int result = loginname != null ? loginname.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package ru.artsok.dao.entitys;


public class Order {
    private long dataJulian;
    private String login;

    public Order(long dataJulian, String login) {
        this.dataJulian = dataJulian;
        this.login = login;
    }

    public long getDataJulian() {
        return dataJulian;
    }

    public void setDataJulian(long dataJulian) {
        this.dataJulian = dataJulian;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

package ru.artsok.dao.entitys;


public class Orders {
    private int idOrder;
    private String textOrder;
    private int quantity;

    public Orders(int idOrder, int quantity, String textOrder) {
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.textOrder = textOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTextOrder() {
        return textOrder;
    }

    public void setTextOrder(String textOrder) {
        this.textOrder = textOrder;
    }
}

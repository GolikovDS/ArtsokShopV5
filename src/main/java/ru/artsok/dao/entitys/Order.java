package ru.artsok.dao.entitys;


public class Order {
    private String name;
    private String type;
    private int quantity;

    public Order() {
    }

    public Order(OrderBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.quantity = builder.quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public static class OrderBuilder {
        private String name;
        private String type;
        private int quantity;

        public OrderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public OrderBuilder type(String type) {
            this.type = type;
            return this;
        }

        public OrderBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }


}

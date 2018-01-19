package ru.artsok.dao.entitys.interfaces;


import ru.artsok.dao.entitys.Order;
import ru.artsok.dao.entitys.Orders;

import java.util.List;

public interface OrderDao {
    public int setOrder(Order order, Orders orders);
    public void addOrder(Orders orders);
    public List<Orders> getOrdersById();
    public List<Orders> getOrdersByLogin();

}

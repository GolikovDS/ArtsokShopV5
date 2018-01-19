package ru.artsok.dao.implementes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import ru.artsok.dao.entitys.Order;
import ru.artsok.dao.entitys.Orders;
import ru.artsok.dao.entitys.interfaces.OrderDao;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {


    private JdbcTemplate jdbcTemplate;


    public OrderDaoImpl() {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        DataSource dataSource = (DataSource)rootContext.getBean("dataSourceS");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public int setOrder(Order order, Orders orders) {
        int id =
                jdbcTemplate.update("INSERT INTO [order](data_julian, login) VALUE(?, ?)", order.getDataJulian(), order.getLogin());
        jdbcTemplate.update("INSERT INTO [orders](text_order, quantity, id_order) VALUE(?, ?, ?)", orders.getTextOrder(), orders.getQuantity(), id);
        return 0;
    }

    @Override
    public void addOrder(Orders orders) {
//        jdbcTemplate.update("INSERT INTO [orders](text_order, quantity, id_order) VALUE(?, ?, ?)", orders.getTextOrder(), orders.getQuantity(), orders.getIdOrder());
    }

    @Override
    public List<Orders> getOrdersById() {
        return null;
    }

    @Override
    public List<Orders> getOrdersByLogin() {
        return null;
    }
}

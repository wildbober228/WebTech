package DAO;

import junit.framework.TestCase;
import models.Order;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoTest extends TestCase {

    public void testAddOrder() {
    }

    public void testUpdateOrder() {
    }

    public void testList_NO_NULL() throws SQLException {
        OrderDao orderDao = new OrderDao();
        ArrayList<Order> expected = (ArrayList<Order>) orderDao.list();
        Assert.assertNotNull(expected);
    }

    public void testGetById() throws SQLException {
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getById(11111);
        Assert.assertEquals(order,null);
    }
}
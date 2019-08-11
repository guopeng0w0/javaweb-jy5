package dao;

import common.ResponstCode;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Order;
import pojo.list;
import utils.PoolUTil;

import java.util.List;

public class OrderDao {
    //订单list
    public List<Order> selecOrdertAll(String pageSize, String pageNum) {
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        List<Order> li = null;
        try {
            li = q.query("select * from orders", new BeanListHandler<Order>(Order.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }

    //按订单号查询
    public Order selecOrdertAll(Integer ordorNo) {
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        Order order = null;
        try {
            order = q.query("select * from orders where orderNo = ?", new BeanHandler<Order>(Order.class),ordorNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    //订单详情
    public Order selectIdAll(Integer orderNo) {
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        Order order = null;
        String sql = "select * from orders where orderNo = ? and payment = ?";
        try {
            order = q.query(sql, new BeanHandler<Order>(Order.class),orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    //订单发货
    public Order sendGoods(Integer orderNo ) {
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        Order order = null;
        String sql = "select status from orders where orderNo = ?";
        try {
            order = q.query(sql, new BeanHandler<Order>(Order.class),orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
}

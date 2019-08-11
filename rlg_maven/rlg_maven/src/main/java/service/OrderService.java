package service;

import common.ResponstCode;
import dao.OrderDao;
import pojo.Order;

import java.util.List;

public class OrderService {
    OrderDao od = new OrderDao();

    //订单list
    public ResponstCode selectOrderAll(String pageSize, String pageNum) {
        ResponstCode rs= new ResponstCode();

        List<Order> list = od.selecOrdertAll(pageSize,pageNum);
        rs.setData(list);
        return rs;
    }

    //按订单号查询
    public ResponstCode selectId(String orderNo) {
        ResponstCode rs= new ResponstCode();
        Order order = od.selecOrdertAll(Integer.parseInt(orderNo));
        if (order==null){
            rs.setStatus(1);
            rs.setMsg("没有找到订单");
            return rs;
        }
        rs.setData(order);
        return rs;
    }

    //订单详情
    public ResponstCode selectOrderAll(String orderNo) {
        ResponstCode rs= new ResponstCode();
        Order order = od.selecOrdertAll(Integer.parseInt(orderNo));
        if (order==null){
            rs.setStatus(1);
            rs.setMsg("没有找到订单");
            return rs;
        }
        rs.setData(order);
        return rs;
    }

    //订单发货
    public ResponstCode sendGoods(String orderNo) {
        ResponstCode rs = new ResponstCode();
        Order order = od.sendGoods(Integer.parseInt(orderNo));
        if (order==null){
            rs.setStatus(0);
            rs.setMsg("发货失败");
        }
        rs.setStatus(10);
        rs.setMsg("发货成功");
        rs.setData(order);
        return rs;
    }
}

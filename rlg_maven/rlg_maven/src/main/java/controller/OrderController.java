package controller;

import common.ResponstCode;
import service.OrderService;
import utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderController",value = "/manage/order/*")
public class OrderController extends HttpServlet {
    OrderService os = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求路径信息
        String pathInfo = request.getPathInfo();
        String path = PathUTil.getPath(pathInfo);

        //创建统一返回对象
        ResponstCode rs = new ResponstCode();      //判断是什么样的请求
        switch (path){
                //产品列表
            case "list":
                rs = listDo(request);
                break;
                //按订单号查询
            case "search":
                rs = searchDo(request);
                break;
               //订单详情
            case "detail":
                rs = detailDo(request);
                break;
                //订单发货
            case "send_goods":
                rs = sendDo(request);
        break;
    }
        response.getWriter().write(rs.toString());
    }

    //订单list
    private ResponstCode listDo(HttpServletRequest request) {
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        ResponstCode rs = os.selectOrderAll(pageSize,pageNum);
        return rs;

    }

    //订单详情按订单号查询
    private ResponstCode searchDo(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        ResponstCode rs = os.selectId(orderNo);
        return rs;
    }

    //订单详情
    private ResponstCode detailDo(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        ResponstCode rs = os.selectOrderAll(orderNo);
        return rs;
    }

    //订单发货
    private ResponstCode sendDo(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        ResponstCode rs = os.sendGoods(orderNo);
        return rs;
    }
}

package controller;

import common.ResponstCode;
import pojo.Users;
import service.ProductService;
import utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProductController",value = "/manage/product/*")
public class ProductController extends HttpServlet {
    //网业务层传输数据
    ProductService ps = new ProductService();

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
            case "list":
                rs = listDo(request);
                break;
            case "search":
                rs = searchDo(request);
                break;
            case "set_sale_status":
                rs = statusDo(request);
                break;
            case "detail":
                rs = detailDo(request);
                break;
            case "save":
                rs = saveDo(request);
                break;

        }
        //将数据传给前端
        response.getWriter().write(rs.toString());
    }

    //新增OR更新产品
    private ResponstCode saveDo(HttpServletRequest request) {
        //获取前端传来的数据
        String detail = request.getParameter("detail");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String id = request.getParameter("id");

        ResponstCode rs =  ps.upDateAll(detail,price,stock,id);
        return rs;

    }

    //产品详情
    private ResponstCode detailDo(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        ResponstCode rs =  ps.selectAll(productId);
        return rs;
    }

    //产品list
    private ResponstCode listDo(HttpServletRequest request) {
        ResponstCode rs = new ResponstCode();

        //获取session对象，保存是否登录成功的信息
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        //如果用户不存在
        if (user == null){
            rs.setStatus(3);
            rs.setMsg("用户未登录，请登录后操作");
            return rs;
        }
        //如果用户不是管理员
        if (user.getType() != 1){
            rs.setStatus(4);
            rs.setMsg("你没有操作权限");
            return rs;
        }
        //获取前端传来的数据
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        rs = ps.selectProductAll(pageSize,pageNum);
        //往业务层传输数据
        return rs;

    }

    //产品搜索
    private ResponstCode searchDo(HttpServletRequest request) {
        //获取前端传来的数据
        String productId = request.getParameter("productId");
        String productName  = request.getParameter("productName");

        ResponstCode rs = ps.selectAll(productId, productName);
        return rs;
    }

    //产品上下架
    private ResponstCode statusDo(HttpServletRequest request) {
        ResponstCode rs = new ResponstCode();

        //获取session对象，保存是否登录成功的信息
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        //判断用户是否存在,若不存在
        if (user == null){
            rs.setStatus(3);
            rs.setMsg("用户未登录，请登录后操作");
            return rs;
        }
        //如果用户不是管理员
        if (user.getType() != 1){
            rs.setStatus(4);
            rs.setMsg("你有操作权限");
            return rs;
        }
        //获取前端传来的数据
        String productId = request.getParameter("productId");
        String status = request.getParameter("status");
        rs = ps.idStatus(productId,status);
        return rs;
    }

}

package controller;


import common.RequestCode;
import pojo.Users;
import service.UsersService;
import utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//控制层
@WebServlet("/manage/user/*")
public class UsersController extends HttpServlet {
    //往业务层传输数据
    UsersService us = new UsersService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求路径信息
        String pathInfo = request.getPathInfo();
        String path = PathUTil.getPath(pathInfo);

        //创建统一返回对象
        RequestCode rs = null;
        //判断是什么样的请求
        switch (path){
            case "list":
                rs = listDo(request);
                break;
            case "login":
                rs = loginDo(request);
                break;
            case "disableuser":
                rs = disableuserDo(request);
                break;
        }
        //将数据传给前端
        response.getWriter().write(rs.toString());
    }

    //禁用用户
    private RequestCode disableuserDo(HttpServletRequest request) {
        String id = request.getParameter("id");

        RequestCode rs = us.selectOne(id);
        return rs;
    }

    //用户登录
    private RequestCode loginDo(HttpServletRequest request){
        //获取前端传来的数据
        String username = request.getParameter("username");
        String password  = request.getParameter("password");

        RequestCode rs = us.selectOne(username,password );

        //登录时创建session对象
        HttpSession session = request.getSession();
        session.setAttribute("user",rs.getData());

        //调用业务层处理业务
        return rs;
    }

    //获取所有用户列表的信息
    private RequestCode listDo(HttpServletRequest request){
        RequestCode rs = new RequestCode();

        //获取session对象，保存是否登录成功的信息
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        //如果用户不存在
        if (user == null){
            rs.setStatus(3);
            rs.setMsg("请登录后操作");
            return rs;
        }
        //如果用户不是管理员
        if (user.getType() != 1){
            rs.setStatus(4);
            rs.setMsg("米有操作权限");
            return rs;
        }
        //获取前端传来的数据
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        rs = us.selectAll(pageSize,pageNum);
        //往业务层传输数据
        return rs;
    }



}

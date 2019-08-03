package service;

import common.Const;
import common.RequestCode;
import dao.UserDao;
import pojo.Users;

import java.util.List;
//业务层
public class UsersService {
    UserDao ud = new UserDao();

    //用户登录
    public RequestCode selectOne(String username, String password) {
        //判断登录是否成功
        RequestCode rs = new RequestCode();
        if (username==null || username.equals("") || password==null || password.equals("") ){
            rs.setStatus(1);
            rs.setMsg("账户或密码错误");
            return rs;
        }

        //判断用户是否是管理员(前提是查找是否有这样一个用户，去数据层查找)
        Users u = ud.selectOne(username,password);
        //如果用户不存在
        if (u == null){
            rs.setStatus(1);
            rs.setMsg("账户或密码错误");
            return rs;
        }
        //如果用户存在判断是否是管理员
        if (u.getType() != 1){
            rs.setStatus(2);
            rs.setMsg("没有访问权限");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(u);
        return rs;
    }

    //获取所有用户列表的信息
    public RequestCode selectAll(String pageSize, String pageNum) {
        //对传进的数据进行非空判断
        if (pageSize==null || pageSize.equals("")){
            pageSize="10";
        }
        if (pageNum==null || pageNum.equals("")){
            pageNum="1";
        }

        //调用数据层
        List<Users> li = ud.selectAll(pageSize, pageNum);

        //创建RequestCode对象
        RequestCode rs = new RequestCode();
        rs.setStatus(0);
        //将集合中元素添加到RequestCode对象中
        rs.setData(li);
        return rs;
    }

    //禁用用户
    public RequestCode selectOne(String uids) {
        //判断为空
        RequestCode rs = new RequestCode();
        if (uids == null || uids.equals("") ){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMsg(Const.USER_PARAMETER_MSG);
            return rs;
        }

        //将字符串转成数值
        Integer id = null;
        try {
            id= Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStatus(2);
            rs.setMsg("输入非法参数");
            return rs;
        }

        //查找是否有这样一个用户，去数据层查找)
        Users u = ud.selectOne(id);
        //如果用户不存在
        if (u == null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMsg(Const.USER_NO_MSG);
            return rs;
        }
        //如果用户存在，判断禁用情况,1表示已经被禁用
        if (u.getStats() == 1){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMsg(Const.USER_DISABLE_MSG);
            return rs;
        }
       //若没有，则禁用
        int row = ud.updateByUid(id);
        if (row < 0){
            rs.setStatus(Const.USER_UPDATE_CODE);
            rs.setMsg(Const.USER_UPDATE_MSG);
        }
        rs.setStatus(0);
        rs.setMsg("用户禁用成功");
        rs.setData(row);
        return rs;
    }
}

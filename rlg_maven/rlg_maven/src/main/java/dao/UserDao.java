package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Users;
import utils.PoolUTil;

import java.util.List;
    //数据层
    public class UserDao {

        //根据用户名密码查找u用户
        public Users selectOne(String username, String password) {
            QueryRunner q = new QueryRunner(PoolUTil.getCom());
            String sql = "select * from users where uname = ? and upsw = ?";
            Users u = null;
            try {
                u = q.query(sql, new BeanHandler<Users>(Users.class), username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return u;
        }

        //查询用户的所有信息
        public List<Users> selectAll(String pageSize, String pageNum) {
            //连接数据库，查询数据
            QueryRunner q = new QueryRunner(PoolUTil.getCom());
            List<Users> li = null;
            try {
                li = q.query("select * from users", new BeanListHandler<Users>(Users.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return li;
        }


        //根据id查找u用户
        public Users selectOne(Integer id) {
            QueryRunner q = new QueryRunner(PoolUTil.getCom());
            String sql = "select * from users where uid = ?";
            Users u = null;
            try {
                u = q.query(sql, new BeanHandler<Users>(Users.class),id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return u;
        }

        //禁用用户
        public int updateByUid(Integer id) {

            QueryRunner q = new QueryRunner(PoolUTil.getCom());
            String sql = "update users set stats = 1 where uid = ?";
            int row= 0;
            try {
                row = q.update(sql,id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return row;
        }
    }

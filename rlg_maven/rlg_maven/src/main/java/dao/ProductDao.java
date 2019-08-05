package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.list;
import utils.PoolUTil;
import java.sql.SQLException;
import java.util.List;

public class ProductDao {

    //产品list
    public List<list> selectProductAll(String pageSize, String pageNum) {
        //连接数据库，查询数据
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        List<list> li = null;
        try {
            li = q.query("select * from list", new BeanListHandler<list>(list.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }

    //产品搜索
    public List<list> selectProduct(String productName) {
        //连接数据库，查询数据
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from list where name like ?";
        String productName1 = "%"+productName+"%";
        List<list> li = null;
        try {
            li = q.query(sql,new BeanListHandler<list>(list.class),productName1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
    public list selectProduct(Integer productId) {
        //连接数据库，查询数据
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from list where id = ?";
        list li = null;
        try {
            li = q.query(sql,new BeanHandler<list>(list.class),productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //商品上下架
    public int updateByUid(Integer productId,Integer status) {
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        String sql = "update list set status = ? where id = ?";
        int row= 0;
        try {
            row = q.update(sql,productId,status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }


    public list selectProductAll(Integer productId) {
        //连接数据库，查询数据
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from product where id = ?";
        list li = null;
        try {
            li =q.query(sql,new BeanHandler<list>(list.class),productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}








package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Product;
import utils.PoolUTil;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    //获取商品的所有信息
    public List<Product> selectAll(String pageSize, String pageNum) {

        //连接数据库，查询数据
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        List<Product> li = null;
        try {
            li = q.query("select * from product", new BeanListHandler<Product>(Product.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }

    //商品上下架
    public int updateByUid(Integer i) {
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        String sql = "update status set stats = 1 where uid = ?";
        int row= 0;
        try {
            row = q.update(sql,i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    //搜索商品
    public List<Product> selectProduct(Integer productId, String productName) {
        //连接数据库，查询数据
        QueryRunner q = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from product where id = ? and name like ?";
        String productName1 = "%"+productName+"%";
        List<Product> li = null;
        try {
            li = q.query(sql,new BeanListHandler<Product>(Product.class),productId,productName1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}








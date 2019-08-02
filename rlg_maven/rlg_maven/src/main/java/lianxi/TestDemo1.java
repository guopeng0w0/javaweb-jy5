package lianxi;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class TestDemo1 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource cb = new ComboPooledDataSource();
        //dbutils连接池
        QueryRunner qr = new QueryRunner(cb);
        List<student> query = qr.query("select * from studentt", new BeanListHandler<student>(student.class));
        for (student s : query){
            System.out.println(s.toString());
        }
        //c3p0连接池
//        Connection cn = cb.getConnection();
//        PreparedStatement ps = cn.prepareStatement("select * from studentt;");
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()){
//            System.out.println(rs.getInt(  1)+rs.getString(2)+rs.getString(3));
  //      }
    }
}

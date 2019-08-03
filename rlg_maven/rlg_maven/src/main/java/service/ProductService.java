package service;

import common.RequestCode;
import dao.ProductDao;
import pojo.Product;

import java.util.List;

public class ProductService {
    //往数据层传输数据
   ProductDao pd = new ProductDao();


    //搜索产品信息
   public RequestCode selectProduct(String productId, String productName) {
       RequestCode rs= new RequestCode();
       //对传进的数据进行非空判断
       if (productId==null || productId.equals("") || productName==null ||productName.equals("")){
           rs.setStatus(10);
           rs.setMsg("用户未登录,请登录");
       }
       List<Product> pt = pd.selectProduct(Integer.parseInt(productId), productName);
       rs.setData(pt);
       return rs;
   }


    //获取产品的所有信息
    public RequestCode selectAll(String productId, String productName) {
        //对传进的数据进行非空判断


        //调用数据层
        List<Product> li = pd.selectProduct(Integer.parseInt(productId), productName);

        //创建RequestCode对象
        RequestCode rs= new RequestCode();
        rs.setStatus(0);
        //将集合中元素添加到RequestCode对象中
        rs.setData(li);
       return rs;
    }

    //商品上下架
    public RequestCode idStatus(String productId, String status) {
        RequestCode rs = new RequestCode();
        //对传进的数据进行非空判断
        if (productId==null || productId.equals("")){
            productId="10";
        }
        if (status==null || status.equals("")){
            status="1";
        }

        //将字符串转换成数值
        Integer i = Integer.parseInt(productId, Integer.parseInt(status));

        //根据商品id
        int row = pd.updateByUid(i);
        if (row > 0){
            rs.setStatus(0);
            rs.setMsg("修改产品状态成功");
            return rs;
        }
        rs.setStatus(1);
        rs.setMsg("修改产品状态失败");
        return rs;
    }
}

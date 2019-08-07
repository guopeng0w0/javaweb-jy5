package service;

import common.ResponstCode;
import dao.ProductDao;
import pojo.list;

import java.util.List;

public class ProductService {
    //往数据层传输数据
   ProductDao pd = new ProductDao();

    //产品list
    public ResponstCode selectProductAll(String pageSize, String pageNum) {
        ResponstCode rs= new ResponstCode();
       //对传进的数据进行非空判断
       if (pageSize==null || pageSize.equals("")){
           pageSize="10";
           rs.setMsg("用户未登录，请登录");
       }
       if (pageNum==null || pageNum.equals("")){
           pageNum="1";
           rs.setMsg("用户未登录，请登录");
       }
       List<list> p = pd.selectProductAll(pageSize,pageNum);
       rs.setStatus(0);
       rs.setData(p);
       return rs;
   }

    //产品搜索
    public ResponstCode selectAll(String productId, String productName) {
        ResponstCode rs= new ResponstCode();
        //对传进的数据进行非空判断
        if (productId == null ||productId.equals("")){
            rs.setMsg("输入的参数为空");
        }else {
            list li = pd.selectProduct(Integer.parseInt(productId));
            rs.setData(li);
        }
        if (productName == null ||productName.equals("")){
            rs.setMsg("输入的参数为空");
        }else {
            List<list> li = pd.selectProduct(productName);
            rs.setData(li);
        }
       return rs;
    }

    //商品上下架
    public ResponstCode idStatus(String productId, String status) {
        ResponstCode rs = new ResponstCode();
        //对传进的数据进行非空判断
//        if (productId==null || productId.equals("")){
//            productId="10";
//        }
//        if (status==null || status.equals("")){
//            status="1";
//        }

        //根据商品id，和status管理
        int row = pd.updateByUid(Integer.parseInt(productId), Integer.parseInt(status));
        if (row > 0){
            rs.setStatus(0);
            rs.setMsg("修改产品状成功");
            return rs;
        }
        rs.setStatus(1);
        rs.setMsg("修改产品状态失败");
        return rs;
    }

    //产品详情
    public ResponstCode selectAll(String productId) {
        ResponstCode rs= new ResponstCode();
        if (productId == null ||productId.equals("")){
            rs.setStatus(1);
            rs.setMsg("没有权限");
        }
        list li = pd.selectProductAll(Integer.parseInt(productId));
        rs.setData(li);
        return rs;
    }

    //新增OR更新产品
    public ResponstCode upDateAll( String id,String detail, String price, String stock) {
        ResponstCode rs = new ResponstCode();
        if (id == null || id.equals("")){
            //执行新增商品的方法
           rs =  pd.insertProduc(Integer.parseInt(id),detail,price,Integer.parseInt(stock));
        }
        return rs;
    }
}


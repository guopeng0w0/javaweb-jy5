package utils;

public class PathUTil {
    public  static  String getPath(String path){
        //获取请求路径信息
        String rl = path.replace(".", "/");
        String[] ar =  rl.split("/");
       return ar[1];
    }
}

package pojo;

public class Users {
    private Integer uid;
    private String uname;
    private String upsw;
    private String phone;
    private Integer type = 0;   //区分账户是管理员还是用户  0是用户，1是管理员
    private Integer stats = 0;  //区分用户是否被禁用

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpsw() {
        return upsw;
    }

    public void setUpsw(String upsw) {
        this.upsw = upsw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upsw='" + upsw + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                ", stats=" + stats +
                '}';
    }
}

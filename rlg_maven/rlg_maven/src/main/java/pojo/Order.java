package pojo;

import java.util.Date;

public class Order {
    private Integer orderNo;
    private String payment;
    private Integer paymentType;
    private String paymentTypeDesc;
    private String postage;
    private String status;
    private String statusDesc;
    private Date paymentTime;
    private Date endTime;
    private Date closeTime;
    private Date createTime;

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public String getPostage() {
        return postage;
    }

    public void setPostage(String postage) {
        this.postage = postage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", payment='" + payment + '\'' +
                ", paymentType=" + paymentType +
                ", paymentTypeDesc='" + paymentTypeDesc + '\'' +
                ", postage='" + postage + '\'' +
                ", status='" + status + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", paymentTime=" + paymentTime +
                ", endTime=" + endTime +
                ", closeTime=" + closeTime +
                ", createTime=" + createTime +
                '}';
    }
}

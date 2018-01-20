package cc.openkit.kitPay.weichart.model;

import java.util.Date;

/**
 * Created by benhailong on 2017/11/1.
 */
public class PayRecord {

    // 这里是保存订单记录
    // 获取用户信息
//            AppCustomer appCustomer=(AppCustomer) request.getSession().getAttribute("appCustomer");
//            payRecord.setPhone(appCustomer.getPhone());
//            payRecord.setUserid(userid);
//            payRecord.setSerialId(Long.valueOf(out_trade_no));
//            payRecord.setType((byte)2);
//            payRecord.setGenerateTime(new Date());
//            payRecord.setTotalAmount(Float.valueOf(total_fee)/100);

    // 添加的业务逻辑
//            payRecordService.insert(payRecord);

    private String userid;
    private String phone;
    private Long serialId;
    private byte type;
    private Date generateTime;
    private Date payTime;
    private Float totalAmount;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}

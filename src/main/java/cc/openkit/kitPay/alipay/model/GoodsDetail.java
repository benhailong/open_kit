package cc.openkit.kitPay.alipay.model;

public class GoodsDetail {
    // 是否必选     最大长度    描述  示例
    // 必填	32	商品的编号	apple-01
    private String goodsId;
    // 可选	32	支付宝定义的统一商品编号	20010001
    private String alipayGoodsId;
    // 必填	256	商品名称	ipad
    private String goodsName;
    // 必填	10	商品数量	1
    private int quantity;
    // 必填	9	商品单价，单位为元	2000
    private double price;
    // 可选	24	商品类目	34543238
    private String goodsCategory;
    // 可选	1000	商品描述信息	特价手机
    private String body;
    // 可选	400	商品的展示地址	http://www.alipay.com/xxx.jpg
    private String showUrl;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAlipayGoodsId() {
        return alipayGoodsId;
    }

    public void setAlipayGoodsId(String alipayGoodsId) {
        this.alipayGoodsId = alipayGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }
}

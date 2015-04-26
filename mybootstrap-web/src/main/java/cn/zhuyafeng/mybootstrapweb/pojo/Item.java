package cn.zhuyafeng.mybootstrapweb.pojo;

import org.apache.solr.client.solrj.beans.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// 指定表名
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item extends BasePojo {

    // 商品id
    @Field("id")
    private Long id;
    // 商品名称
    @Field("title")
    private String title;
    // 商品卖点
    @Field("sellPoint")
    private String sellPoint;
    // 商品价格
    @Field("price")
    private Long price;
    // 库存数量
    
    private Integer num;
    //商品图片路径
    @Field("image")
    private String image;
    
    //条形码
    private String barcode;
    //
    @Field("cid")
    private Long cid;
    //商品状态
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", title=" + title + ", sellPoint=" + sellPoint + ", price=" + price
                + ", num=" + num + ", image=" + image + ", barcode=" + barcode + ", cid=" + cid + ", status="
                + status + "]";
    }

}

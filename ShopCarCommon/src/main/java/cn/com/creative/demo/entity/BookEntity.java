package cn.com.creative.demo.entity;
import java.io.Serializable;
import java.lang.reflect.Proxy;

public class BookEntity implements Serializable {
    private Integer bkId;

    private String bkName;

    private String bkImage;

    private Double bkPrice;

    private static final long serialVersionUID = 1L;

    public Integer getBkId() {
        return bkId;
    }

    public void setBkId(Integer bkId) {
        this.bkId = bkId;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName == null ? null : bkName.trim();
    }

    public String getBkImage() {
        return bkImage;
    }

    public void setBkImage(String bkImage) {
        this.bkImage = bkImage == null ? null : bkImage.trim();
    }

    public Double getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(Double bkPrice) {
        this.bkPrice = bkPrice;
    }
}
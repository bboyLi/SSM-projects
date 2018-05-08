package com.demo.pojo;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/1 14:08
 */
public class PhoneArea {

    private String carrier;     //江苏移动
    private String province;     //江苏
    private String catName;     //中国移动
    private String telString;   //手机号

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getTelString() {
        return telString;
    }

    public void setTelString(String telString) {
        this.telString = telString;
    }

    @Override
    public String toString() {
        return "PhoneArea{" +
                "carrier='" + carrier + '\'' +
                ", province='" + province + '\'' +
                ", catName='" + catName + '\'' +
                ", telString='" + telString + '\'' +
                '}';
    }
}

package com.example.ruby.fhapp.mvp.model.map;

public class BannerMapBean {
    public String Appid;
    public String sign;

    public BannerMapBean(String appid, String sign) {
        Appid = appid;
        this.sign = sign;
    }

    public BannerMapBean() {

    }

    public String getAppid() {
        return Appid;
    }

    public void setAppid(String appid) {
        Appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}

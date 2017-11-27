package cn.uc.yiqibang.beans;

import java.util.Date;

public class BaseVerificationCode {
    private Integer id;

    private String mobile;

    private String code;

    private Short type;

    private Date createtime;

    private Date expirationtime;

    public BaseVerificationCode(Integer id, String mobile, String code, Short type, Date createtime, Date expirationtime) {
        this.id = id;
        this.mobile = mobile;
        this.code = code;
        this.type = type;
        this.createtime = createtime;
        this.expirationtime = expirationtime;
    }

    public BaseVerificationCode() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getExpirationtime() {
        return expirationtime;
    }

    public void setExpirationtime(Date expirationtime) {
        this.expirationtime = expirationtime;
    }
}
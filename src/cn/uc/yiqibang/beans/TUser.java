package cn.uc.yiqibang.beans;

import java.util.Date;

public class TUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Integer id;


	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_username
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private String uUsername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_nickname
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private String uNickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_password
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private String uPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_sex
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Boolean uSex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_bindtel
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private String uBindtel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_email
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private String uEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_heading
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private String uHeading;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_state
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Boolean uState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_createtime
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Date uCreatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_birthday
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Date uBirthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_remark
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private String uRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_update
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Date uUpdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_provinceid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Integer uProvinceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_cityid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Integer uCityid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.u_areaid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    private Integer uAreaid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_username
     *
     * @return the value of t_user.u_username
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public String getuUsername() {
        return uUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_username
     *
     * @param uUsername the value for t_user.u_username
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_nickname
     *
     * @return the value of t_user.u_nickname
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public String getuNickname() {
        return uNickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_nickname
     *
     * @param uNickname the value for t_user.u_nickname
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_password
     *
     * @return the value of t_user.u_password
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_password
     *
     * @param uPassword the value for t_user.u_password
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_sex
     *
     * @return the value of t_user.u_sex
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Boolean getuSex() {
        return uSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_sex
     *
     * @param uSex the value for t_user.u_sex
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuSex(Boolean uSex) {
        this.uSex = uSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_bindtel
     *
     * @return the value of t_user.u_bindtel
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public String getuBindtel() {
        return uBindtel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_bindtel
     *
     * @param uBindtel the value for t_user.u_bindtel
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuBindtel(String uBindtel) {
        this.uBindtel = uBindtel == null ? null : uBindtel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_email
     *
     * @return the value of t_user.u_email
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public String getuEmail() {
        return uEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_email
     *
     * @param uEmail the value for t_user.u_email
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_heading
     *
     * @return the value of t_user.u_heading
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public String getuHeading() {
        return uHeading;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_heading
     *
     * @param uHeading the value for t_user.u_heading
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuHeading(String uHeading) {
        this.uHeading = uHeading == null ? null : uHeading.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_state
     *
     * @return the value of t_user.u_state
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Boolean getuState() {
        return uState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_state
     *
     * @param uState the value for t_user.u_state
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuState(Boolean uState) {
        this.uState = uState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_createtime
     *
     * @return the value of t_user.u_createtime
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Date getuCreatetime() {
        return uCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_createtime
     *
     * @param uCreatetime the value for t_user.u_createtime
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuCreatetime(Date uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_birthday
     *
     * @return the value of t_user.u_birthday
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Date getuBirthday() {
        return uBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_birthday
     *
     * @param uBirthday the value for t_user.u_birthday
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuBirthday(Date uBirthday) {
        this.uBirthday = uBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_remark
     *
     * @return the value of t_user.u_remark
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public String getuRemark() {
        return uRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_remark
     *
     * @param uRemark the value for t_user.u_remark
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuRemark(String uRemark) {
        this.uRemark = uRemark == null ? null : uRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_update
     *
     * @return the value of t_user.u_update
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Date getuUpdate() {
        return uUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_update
     *
     * @param uUpdate the value for t_user.u_update
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuUpdate(Date uUpdate) {
        this.uUpdate = uUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_provinceid
     *
     * @return the value of t_user.u_provinceid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Integer getuProvinceid() {
        return uProvinceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_provinceid
     *
     * @param uProvinceid the value for t_user.u_provinceid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuProvinceid(Integer uProvinceid) {
        this.uProvinceid = uProvinceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_cityid
     *
     * @return the value of t_user.u_cityid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Integer getuCityid() {
        return uCityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_cityid
     *
     * @param uCityid the value for t_user.u_cityid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuCityid(Integer uCityid) {
        this.uCityid = uCityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.u_areaid
     *
     * @return the value of t_user.u_areaid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public Integer getuAreaid() {
        return uAreaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.u_areaid
     *
     * @param uAreaid the value for t_user.u_areaid
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    public void setuAreaid(Integer uAreaid) {
        this.uAreaid = uAreaid;
    }

	@Override
	public String toString() {
		return "TUser [id=" + id + ", uUsername=" + uUsername + ", uNickname=" + uNickname + ", uPassword=" + uPassword
				+ ", uSex=" + uSex + ", uBindtel=" + uBindtel + ", uEmail=" + uEmail + ", uHeading=" + uHeading
				+ ", uState=" + uState + ", uCreatetime=" + uCreatetime + ", uBirthday=" + uBirthday + ", uRemark="
				+ uRemark + ", uUpdate=" + uUpdate + ", uProvinceid=" + uProvinceid + ", uCityid=" + uCityid
				+ ", uAreaid=" + uAreaid + "]";
	}
    
   /* public TUser(String uUsername, String uPassword) {
//		super();
    	this.uUsername = uUsername;
    	this.uPassword = uPassword;
    }*/
    
    
    
}
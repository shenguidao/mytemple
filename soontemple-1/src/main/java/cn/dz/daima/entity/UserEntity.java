package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
   /**
    * user 实体类
    * Thu May 09 16:11:56 CST 2019 tom
    */ 
@TableName("user")
public class UserEntity{
 	/**id*/
 	@TableField("id")
	private int id;
 	/**login_user_name*/
 	@TableField("login_user_name")
	private String loginUserName;
 	/**login_user_password*/
 	@TableField("login_user_password")
	private String loginUserPassword;
 	/**active*/
 	@TableField("active")
	private Integer active;
 	/**update_time*/
 	@TableField("update_time")
	private Date updateTime;
 	/**create_time*/
 	@TableField("create_time")
	private Date createTime;
 	/**real_name*/
 	@TableField("real_name")
	private String realName;
 	/**mobile*/
 	@TableField("mobile")
	private String mobile;
 	/**location_bo_id*/
 	@TableField("location_bo_id")
	private int locationBoId;
 	/**location_bo_item_id*/
 	@TableField("location_bo_item_id")
	private int locationBoItemId;
 	/**uuid*/
 	@TableField("uuid")
	private String uuid;
 	/**uupassword*/
 	@TableField("uupassword")
	private String uupassword;
 	/**mail*/
 	@TableField("mail")
	private String mail;
 	/**did*/
 	@TableField("did")
	private String did;
 	/**sign*/
 	@TableField("sign")
	private String sign;
 	/**mac*/
 	@TableField("mac")
	private String mac;
 	/**pushtoken*/
 	@TableField("pushtoken")
	private String pushtoken;
 	/**isBind*/
 	@TableField("isBind")
	private int isBind;
 	/**profit_center*/
 	@TableField("profit_center")
	private String profitCenter;
 	/**create_user_id*/
 	@TableField("create_user_id")
	private int createUserId;
 	/**update_user_id*/
 	@TableField("update_user_id")
	private int updateUserId;
 	/**weChatBarCodeImagePath*/
 	@TableField("weChatBarCodeImagePath")
	private String weChatBarCodeImagePath;
 	/**userHeaderImagePath*/
 	@TableField("userHeaderImagePath")
	private String userHeaderImagePath;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setLoginUserName(String loginUserName){
	this.loginUserName=loginUserName;
	}
	public String getLoginUserName(){
		return loginUserName;
	}
	public void setLoginUserPassword(String loginUserPassword){
	this.loginUserPassword=loginUserPassword;
	}
	public String getLoginUserPassword(){
		return loginUserPassword;
	}
	public void setActive(Integer active){
	this.active=active;
	}
	public Integer getActive(){
		return active;
	}
	public void setUpdateTime(Date updateTime){
	this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}
	public void setCreateTime(Date createTime){
	this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setRealName(String realName){
	this.realName=realName;
	}
	public String getRealName(){
		return realName;
	}
	public void setMobile(String mobile){
	this.mobile=mobile;
	}
	public String getMobile(){
		return mobile;
	}
	public void setLocationBoId(int locationBoId){
	this.locationBoId=locationBoId;
	}
	public int getLocationBoId(){
		return locationBoId;
	}
	public void setLocationBoItemId(int locationBoItemId){
	this.locationBoItemId=locationBoItemId;
	}
	public int getLocationBoItemId(){
		return locationBoItemId;
	}
	public void setUuid(String uuid){
	this.uuid=uuid;
	}
	public String getUuid(){
		return uuid;
	}
	public void setUupassword(String uupassword){
	this.uupassword=uupassword;
	}
	public String getUupassword(){
		return uupassword;
	}
	public void setMail(String mail){
	this.mail=mail;
	}
	public String getMail(){
		return mail;
	}
	public void setDid(String did){
	this.did=did;
	}
	public String getDid(){
		return did;
	}
	public void setSign(String sign){
	this.sign=sign;
	}
	public String getSign(){
		return sign;
	}
	public void setMac(String mac){
	this.mac=mac;
	}
	public String getMac(){
		return mac;
	}
	public void setPushtoken(String pushtoken){
	this.pushtoken=pushtoken;
	}
	public String getPushtoken(){
		return pushtoken;
	}
	public void setIsBind(int isBind){
	this.isBind=isBind;
	}
	public int getIsBind(){
		return isBind;
	}
	public void setProfitCenter(String profitCenter){
	this.profitCenter=profitCenter;
	}
	public String getProfitCenter(){
		return profitCenter;
	}
	public void setCreateUserId(int createUserId){
	this.createUserId=createUserId;
	}
	public int getCreateUserId(){
		return createUserId;
	}
	public void setUpdateUserId(int updateUserId){
	this.updateUserId=updateUserId;
	}
	public int getUpdateUserId(){
		return updateUserId;
	}
	public void setWeChatBarCodeImagePath(String weChatBarCodeImagePath){
	this.weChatBarCodeImagePath=weChatBarCodeImagePath;
	}
	public String getWeChatBarCodeImagePath(){
		return weChatBarCodeImagePath;
	}
	public void setUserHeaderImagePath(String userHeaderImagePath){
	this.userHeaderImagePath=userHeaderImagePath;
	}
	public String getUserHeaderImagePath(){
		return userHeaderImagePath;
	}
}


package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
   /**
    * t_kgt_gift_coupon 实体类
    * Fri Mar 15 10:13:36 CST 2019 tom
    */ 
@TableName("t_kgt_gift_coupon")
public class GiftCouponEntity{
 	/**id*/
 	@TableField("id")
	private int id;
 	/**名称*/
 	@TableField("name")
	private String name;
 	/**券编码*/
 	@TableField("code")
	private String code;
 	/**用户抽奖记录id*/
 	@TableField("user_gift_id")
	private String userGiftId;
 	/**备注*/
 	@TableField("remark")
	private String remark;
 	/**数据修改时间*/
 	@TableField("update_time")
	private Date updateTime;
 	/**数据修改人ID*/
 	@TableField("update_user_id")
	private int updateUserId;
 	/**数据创建时间*/
 	@TableField("create_time")
	private Date createTime;
 	/**数据创建人ID*/
 	@TableField("create_user_id")
	private int createUserId;
 	/**数据状态(字典关联项：common.active)*/
 	@TableField("active")
	private int active;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setCode(String code){
	this.code=code;
	}
	public String getCode(){
		return code;
	}
	public void setUserGiftId(String userGiftId){
	this.userGiftId=userGiftId;
	}
	public String getUserGiftId(){
		return userGiftId;
	}
	public void setRemark(String remark){
	this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setUpdateTime(Date updateTime){
	this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}
	public void setUpdateUserId(int updateUserId){
	this.updateUserId=updateUserId;
	}
	public int getUpdateUserId(){
		return updateUserId;
	}
	public void setCreateTime(Date createTime){
	this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCreateUserId(int createUserId){
	this.createUserId=createUserId;
	}
	public int getCreateUserId(){
		return createUserId;
	}
	public void setActive(int active){
	this.active=active;
	}
	public int getActive(){
		return active;
	}
}


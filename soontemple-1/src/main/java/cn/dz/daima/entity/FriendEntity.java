package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
   /**
    * wx_friend 实体类
    * Fri Mar 15 17:44:02 CST 2019 tom
    */ 
@TableName("wx_friend")
public class FriendEntity{
 	/**id*/
 	@TableField("id")
	private int id;
 	/**NickName*/
 	@TableField("NickName")
	private String NickName;
 	/**RemarkName*/
 	@TableField("RemarkName")
	private String RemarkName;
 	/**UserName*/
 	@TableField("UserName")
	private String UserName;
 	/**HeadImgUrl*/
 	@TableField("HeadImgUrl")
	private String HeadImgUrl;
 	/**create_time*/
 	@TableField("create_time")
	private Date createTime;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setNickName(String NickName){
	this.NickName=NickName;
	}
	public String getNickName(){
		return NickName;
	}
	public void setRemarkName(String RemarkName){
	this.RemarkName=RemarkName;
	}
	public String getRemarkName(){
		return RemarkName;
	}
	public void setUserName(String UserName){
	this.UserName=UserName;
	}
	public String getUserName(){
		return UserName;
	}
	public void setHeadImgUrl(String HeadImgUrl){
	this.HeadImgUrl=HeadImgUrl;
	}
	public String getHeadImgUrl(){
		return HeadImgUrl;
	}
	public void setCreateTime(Date createTime){
	this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
}


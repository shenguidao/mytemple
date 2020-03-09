package cn.dz.daima.entity;

import java.util.Date;
import java.sql.*;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * store 实体类
    * Thu May 09 16:19:03 CST 2019 tom
    */ 
@TableName("store")
@Data
public class StoreEntity{
 	/**id*/
 	@TableField("id")
	private int id;
 	/**code*/
 	@TableField("code")
	private String code;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**update_time*/
 	@TableField("update_time")
	private Date updateTime;
 	/**update_user_id*/
 	@TableField("update_user_id")
	private int updateUserId;
 	/**create_time*/
 	@TableField("create_time")
	private Date createTime;
 	/**create_user_id*/
 	@TableField("create_user_id")
	private int createUserId;
 	/**active*/
 	@TableField("active")
	private String active;
 	/**city_id*/
 	@TableField("city_id")
	private int cityId;
 	/**address*/
 	@TableField("address")
	private String address;
 	/**lng_lat*/
 	@TableField("lng_lat")
	private String lngLat;
 	/**retail_type*/
 	@TableField("retail_type")
	private String retailType;
 	/**store_system*/
 	@TableField("store_system")
	private String storeSystem;
 	/**is_hcp*/
 	@TableField("is_hcp")
	private String isHcp;
 	/**sr_id*/
 	@TableField("sr_id")
	private int srId;
 	/**t_bo_baoxiaocity*/
 	@TableField("t_bo_baoxiaocity")
	private String tBoBaoxiaocity;
 	/**联系人*/
 	@TableField("contacts")
	private String contacts;
 	/**联系方式*/
 	@TableField("contacts_phone")
	private String contactsPhone;
}


package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_bo_sku_retail 实体类
    * Wed Jun 19 14:26:53 CST 2019 tom
    */ 
@TableName("t_bo_sku_retail")
@Data
public class SkuRetailEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**权限id*/
 	@TableField("role_id")
	private Integer roleId;
 	/**用户id*/
 	@TableField("user_id")
	private Integer userId;
 	/**产品id*/
 	@TableField("sku_id")
	private Integer skuId;
 	/**门店id*/
 	@TableField("store_id")
	private Integer storeId;
 	/**create_user_id*/
 	@TableField("create_user_id")
	private Integer createUserId;
 	/**create_time*/
 	@TableField("create_time")
	private Date createTime;
 	/**update_user_id*/
 	@TableField("update_user_id")
	private Integer updateUserId;
 	/**update_time*/
 	@TableField("update_time")
	private Date updateTime;
 	/**active*/
 	@TableField("active")
	private Integer active;
}


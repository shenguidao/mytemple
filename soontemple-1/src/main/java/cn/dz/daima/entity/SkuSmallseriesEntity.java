package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_bo_sku_smallseries 实体类
    * Wed Jul 31 17:25:57 CST 2019 tom
    */ 
@TableName("t_bo_sku_smallseries")
@Data
public class SkuSmallseriesEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**编码*/
 	@TableField("code")
	private String code;
 	/**名称*/
 	@TableField("name")
	private String name;
 	/**product_name*/
 	@TableField("product_name")
	private String productName;
 	/**排序*/
 	@TableField("display_index")
	private Integer displayIndex;
 	/**update_time*/
 	@TableField("update_time")
	private Date updateTime;
 	/**update_user_id*/
 	@TableField("update_user_id")
	private Integer updateUserId;
 	/**create_time*/
 	@TableField("create_time")
	private Date createTime;
 	/**create_user_id*/
 	@TableField("create_user_id")
	private Integer createUserId;
 	/**active*/
 	@TableField("active")
	private Integer active;
}


package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_bo_ssm_sr_storeapply_detail 实体类
    * Thu Jun 27 18:02:57 CST 2019 tom
    */ 
@TableName("t_bo_ssm_sr_storeapply_detail")
@Data
public class T_bo_ssm_sr_storeapply_detailEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**t_bo_ssm_sr_storeapply表id*/
 	@TableField("store_applyid")
	private Integer storeApplyid;
 	/**状态(0添加,1待删除,2当前)*/
 	@TableField("status")
	private Integer status;
 	/**门店id*/
 	@TableField("store_id")
	private Integer storeId;
 	/**门店code*/
 	@TableField("store_code")
	private String storeCode;
 	/**门店名称*/
 	@TableField("store_name")
	private String storeName;
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


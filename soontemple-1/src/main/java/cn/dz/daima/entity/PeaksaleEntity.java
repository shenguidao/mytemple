package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_etms_peaksale 实体类
    * Fri Sep 20 11:36:05 CST 2019 tom
    */ 
@TableName("t_etms_peaksale")
@Data
public class PeaksaleEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**高峰日期*/
 	@TableField("date")
	private Date date;
 	/**userId*/
 	@TableField("sr_id")
	private Integer srId;
 	/**sr账号*/
 	@TableField("sr_code")
	private String srCode;
 	/**sr姓名*/
 	@TableField("sr_name")
	private String srName;
 	/**门店id*/
 	@TableField("store_id")
	private Integer storeId;
 	/**门店代码*/
 	@TableField("store_code")
	private String storeCode;
 	/**门店名*/
 	@TableField("store_name")
	private String storeName;
 	/**小品牌id*/
 	@TableField("smallseries_id")
	private Integer smallseriesId;
 	/**小品牌名*/
 	@TableField("smallseries_name")
	private String smallseriesName;
 	/**销量数*/
 	@TableField("sale_num")
	private Integer saleNum;
 	/**签名id*/
 	@TableField("sign_id")
	private Integer signId;
 	/**创建时间*/
 	@TableField("create_time")
	private Date createTime;
 	/**创建人,默认1*/
 	@TableField("create_user_id")
	private Integer createUserId;
 	/**active*/
 	@TableField("active")
	private Integer active;
}


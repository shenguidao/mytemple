package cn.dz.daima.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_validity_confirm 实体类
    * Mon Aug 19 17:59:53 CST 2019 tom
    */ 
@TableName("t_validity_confirm")
@Data
public class ValidityConfirmEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**大区*/
 	@TableField("region")
	private String region;
 	/**区域*/
 	@TableField("distric")
	private String distric;
 	/**考核城市			*/
 	@TableField("city_group")
	private String cityGroup;
 	/**城市*/
 	@TableField("city")
	private String city;
 	/**月份*/
 	@TableField("month")
	private String month;
 	/**类型*/
 	@TableField("type")
	private String type;
 	/**用户id*/
 	@TableField("userId")
	private Integer userId;
 	/**用户名*/
 	@TableField("userName")
	private String userName;
 	/**产品id*/
 	@TableField("skuId")
	private Integer skuId;
 	/**产品名*/
 	@TableField("skuName")
	private String skuName;
 	/**门店id*/
 	@TableField("storeId")
	private Integer storeId;
 	/**门店名称*/
 	@TableField("storeName")
	private String storeName;
 	/**效期<3/1*/
 	@TableField("lessThanOneThird")
	private Integer lessThanOneThird;
 	/**1/3<效期<1/2*/
 	@TableField("lessThanHalf")
	private Integer lessThanHalf;
 	/**效期>1/2*/
 	@TableField("moreThanHalf")
	private Integer moreThanHalf;
 	/**确认字段(0:未确认,1确认)*/
 	@TableField("confirm")
	private Integer confirm;
 	/**门店人员签名url*/
 	@TableField("store_sign")
	private String storeSign;
 	/**销售代表签字url*/
 	@TableField("representative_sign")
	private String representativeSign;
}


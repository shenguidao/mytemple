package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_uni_request 实体类
    * Thu Sep 26 14:02:16 CST 2019 tom
    */ 
@TableName("t_uni_request")
@Data
public class UniRequestEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**接口公司代号*/
 	@TableField("aiCompNo")
	private String aiCompNo;
 	/**本公司代号*/
 	@TableField("compNo")
	private String compNo;
 	/**时间戳*/
 	@TableField("timestamp")
	private String timestamp;
 	/**签名*/
 	@TableField("sign")
	private String sign;
 	/**服务名*/
 	@TableField("serviceId")
	private String serviceId;
 	/**识别结果调用服务类别*/
 	@TableField("returnUrlType")
	private String returnUrlType;
 	/**采集任务批次号ID*/
 	@TableField("visitTaskIdBatch")
	private String visitTaskIdBatch;
 	/**图片识别类型*/
 	@TableField("aiType")
	private String aiType;
 	/**图片类型*/
 	@TableField("imageType")
	private Integer imageType;
 	/**图片ID*/
 	@TableField("imageKeyId")
	private String imageKeyId;
 	/**拼接图片IDLIST*/
 	@TableField("imageKeyIdList")
	private String imageKeyIdList;
 	/**图片URL*/
 	@TableField("imageUrl")
	private String imageUrl;
 	/**request_id*/
 	@TableField("request_id")
	private String requestId;
 	/**task_id*/
 	@TableField("task_id")
	private String taskId;
 	/**创建时间*/
 	@TableField("create_time")
	private Date createTime;
 	/**create_user*/
 	@TableField("create_user")
	private Integer createUser;
 	/**update_time*/
 	@TableField("update_time")
	private Date updateTime;
 	/**update_user*/
 	@TableField("update_user")
	private Integer updateUser;
 	/**avtive*/
 	@TableField("avtive")
	private Integer avtive;
}


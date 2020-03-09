package cn.dz.daima.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_ali_uni_airesults 实体类
    * Sat Sep 28 15:14:11 CST 2019 tom
    */ 
@TableName("t_ali_uni_airesults")
@Data
public class UniAiresultsEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**采集任务批次号*/
 	@TableField("visitTaskIdBranch")
	private String visitTaskIdBranch;
 	/**阿里任务id*/
 	@TableField("taskId")
	private String taskId;
 	/**业务识别状态1-已处理，0-处理中*/
 	@TableField("state")
	private String state;
 	/**图片识别状态：0-识别失败,1-识别成功,2-识别中*/
 	@TableField("aiResults_state")
	private String aiResultsState;
 	/**图片ID*/
 	@TableField("aiResults_imageKeyId")
	private String aiResultsImageKeyId;
 	/**拼接图片IDLIST*/
 	@TableField("aiResults_imageKeyIdList")
	private String aiResultsImageKeyIdList;
 	/**Ai 图片ID*/
 	@TableField("aiResults_aiImageId")
	private String aiResultsAiImageId;
 	/**图片URL地址*/
 	@TableField("aiResults_aiImageUrl")
	private String aiResultsAiImageUrl;
 	/**图片识别类型*/
 	@TableField("aiResults_aiType")
	private String aiResultsAiType;
 	/**图片类型*/
 	@TableField("aiResults_imageType")
	private Integer aiResultsImageType;
 	/**货架总层数*/
 	@TableField("aiResults_imageLayout")
	private String aiResultsImageLayout;
 	/**所在货架层数*/
 	@TableField("layer")
	private Integer layer;
 	/**识别SKU可信度*/
 	@TableField("score")
	private Integer score;
 	/**厂商商品代号*/
 	@TableField("aiProductId")
	private String aiProductId;
 	/**SKU所在图片位置X1坐标*/
 	@TableField("X1")
	private Integer X1;
 	/**SKU所在图片位置X2坐标*/
 	@TableField("X2")
	private Integer X2;
 	/**SKU所在图片位置Y1坐标*/
 	@TableField("Y1")
	private Integer Y1;
 	/**SKU所在图片位置Y2坐标*/
 	@TableField("Y2")
	private Integer Y2;
}


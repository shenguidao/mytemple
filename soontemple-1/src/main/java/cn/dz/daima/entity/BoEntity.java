package cn.dz.daima.entity;

import java.util.Date;
import java.sql.*;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_etms_bo 实体类
    * Mon Mar 02 17:17:02 CST 2020 tom
    */ 
@TableName("t_etms_bo")
@Data
public class BoEntity{
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**code*/
 	@TableField("code")
	private String code;
 	/**type*/
 	@TableField("type")
	private String type;
 	/**table_name*/
 	@TableField("table_name")
	private String tableName;
 	/**check_role*/
 	@TableField("check_role")
	private String checkRole;
 	/**update_time*/
 	@TableField("update_time")
	private Date updateTime;
 	/**create_time*/
 	@TableField("create_time")
	private Date createTime;
 	/**update_user_id*/
 	@TableField("update_user_id")
	private Integer updateUserId;
 	/**create_user_id*/
 	@TableField("create_user_id")
	private Integer createUserId;
 	/**active*/
 	@TableField("active")
	private Integer active;
 	/**target_bo_id*/
 	@TableField("target_bo_id")
	private Integer targetBoId;
 	/**isCache*/
 	@TableField("isCache")
	private Boolean isCache;
 	/**import_type*/
 	@TableField("import_type")
	private Integer importType;
 	/**import_start_row*/
 	@TableField("import_start_row")
	private Integer importStartRow;
 	/**import_start_col*/
 	@TableField("import_start_col")
	private Integer importStartCol;
 	/**import_template_file*/
 	@TableField("import_template_file")
	private String importTemplateFile;
 	/**remark*/
 	@TableField("remark")
	private String remark;
}


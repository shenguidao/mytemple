package cn.dz.daima.entity;

import java.util.Date;
import java.sql.*;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * t_etms_bo_ui_edit 实体类
    * Mon Mar 02 17:17:03 CST 2020 tom
    */ 
@TableName("t_etms_bo_ui_edit")
@Data
public class T_etms_bo_ui_editEntity{
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
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**bo_item_id*/
 	@TableField("bo_item_id")
	private Integer boItemId;
 	/**当前已审核通过的角色（当前审核到达角色链中哪个角色）*/
 	@TableField("current_role_id")
	private Integer currentRoleId;
 	/**申请人*/
 	@TableField("submit_user_id")
	private Integer submitUserId;
 	/**申请时间*/
 	@TableField("submit_time")
	private Date submitTime;
 	/**0：审核中
1：审核通过
2：审核不通过*/
 	@TableField("current_status")
	private Integer currentStatus;
 	/**母id*/
 	@TableField("parent_id")
	private Integer parentId;
 	/**审核人权限*/
 	@TableField("role_id")
	private Integer roleId;
 	/**审核人*/
 	@TableField("verify_user_id")
	private Integer verifyUserId;
 	/**审核时间*/
 	@TableField("verify_time")
	private Date verifyTime;
 	/**审核结果*/
 	@TableField("status")
	private Integer status;
 	/**备注*/
 	@TableField("remark")
	private String remark;
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
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**code*/
 	@TableField("code")
	private String code;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**type*/
 	@TableField("type")
	private String type;
 	/**column_name*/
 	@TableField("column_name")
	private String columnName;
 	/**null_able*/
 	@TableField("null_able")
	private Boolean nullAble;
 	/**sort_able*/
 	@TableField("sort_able")
	private Boolean sortAble;
 	/**filter_able*/
 	@TableField("filter_able")
	private Boolean filterAble;
 	/**unique_able*/
 	@TableField("unique_able")
	private Boolean uniqueAble;
 	/**show_in_detail*/
 	@TableField("show_in_detail")
	private Boolean showInDetail;
 	/**show_in_list*/
 	@TableField("show_in_list")
	private Boolean showInList;
 	/**bo_short_display*/
 	@TableField("bo_short_display")
	private Boolean boShortDisplay;
 	/**bo_union_key*/
 	@TableField("bo_union_key")
	private Boolean boUnionKey;
 	/**co_code*/
 	@TableField("co_code")
	private String coCode;
 	/**co_display_type*/
 	@TableField("co_display_type")
	private String coDisplayType;
 	/**date_display_format*/
 	@TableField("date_display_format")
	private String dateDisplayFormat;
 	/**date_search_format*/
 	@TableField("date_search_format")
	private String dateSearchFormat;
 	/**date_display*/
 	@TableField("date_display")
	private Boolean dateDisplay;
 	/**date_max_value*/
 	@TableField("date_max_value")
	private Date dateMaxValue;
 	/**date_min_value*/
 	@TableField("date_min_value")
	private Date dateMinValue;
 	/**file_dir*/
 	@TableField("file_dir")
	private String fileDir;
 	/**file_type*/
 	@TableField("file_type")
	private String fileType;
 	/**file_name_rule*/
 	@TableField("file_name_rule")
	private String fileNameRule;
 	/**bo_code*/
 	@TableField("bo_code")
	private String boCode;
 	/**bo_display_level*/
 	@TableField("bo_display_level")
	private Integer boDisplayLevel;
 	/**bo_select_type*/
 	@TableField("bo_select_type")
	private String boSelectType;
 	/**number_decimals*/
 	@TableField("number_decimals")
	private Integer numberDecimals;
 	/**number_max_value*/
 	@TableField("number_max_value")
	private String numberMaxValue;
 	/**number_min_value*/
 	@TableField("number_min_value")
	private String numberMinValue;
 	/**number_pre_unit*/
 	@TableField("number_pre_unit")
	private String numberPreUnit;
 	/**number_unit*/
 	@TableField("number_unit")
	private String numberUnit;
 	/**string_regular*/
 	@TableField("string_regular")
	private String stringRegular;
 	/**string_max_length*/
 	@TableField("string_max_length")
	private Integer stringMaxLength;
 	/**string_min_length*/
 	@TableField("string_min_length")
	private Integer stringMinLength;
 	/**string_multi_line*/
 	@TableField("string_multi_line")
	private Boolean stringMultiLine;
 	/**user_role_code*/
 	@TableField("user_role_code")
	private String userRoleCode;
 	/**active*/
 	@TableField("active")
	private Integer active;
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
 	/**idx*/
 	@TableField("idx")
	private Integer idx;
 	/**group_able*/
 	@TableField("group_able")
	private Boolean groupAble;
 	/**carmera_pic_only*/
 	@TableField("carmera_pic_only")
	private Boolean carmeraPicOnly;
 	/**default_value*/
 	@TableField("default_value")
	private String defaultValue;
 	/**bo_pic_type*/
 	@TableField("bo_pic_type")
	private Integer boPicType;
 	/**logic*/
 	@TableField("logic")
	private String logic;
 	/**logic_code*/
 	@TableField("logic_code")
	private String logicCode;
 	/**remark*/
 	@TableField("remark")
	private String remark;
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**code*/
 	@TableField("code")
	private String code;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**type*/
 	@TableField("type")
	private String type;
 	/**column_name*/
 	@TableField("column_name")
	private String columnName;
 	/**null_able*/
 	@TableField("null_able")
	private Boolean nullAble;
 	/**sort_able*/
 	@TableField("sort_able")
	private Boolean sortAble;
 	/**filter_able*/
 	@TableField("filter_able")
	private Boolean filterAble;
 	/**unique_able*/
 	@TableField("unique_able")
	private Boolean uniqueAble;
 	/**show_in_detail*/
 	@TableField("show_in_detail")
	private Boolean showInDetail;
 	/**show_in_list*/
 	@TableField("show_in_list")
	private Boolean showInList;
 	/**bo_short_display*/
 	@TableField("bo_short_display")
	private Boolean boShortDisplay;
 	/**bo_union_key*/
 	@TableField("bo_union_key")
	private Boolean boUnionKey;
 	/**co_code*/
 	@TableField("co_code")
	private String coCode;
 	/**co_display_type*/
 	@TableField("co_display_type")
	private String coDisplayType;
 	/**date_display_format*/
 	@TableField("date_display_format")
	private String dateDisplayFormat;
 	/**date_search_format*/
 	@TableField("date_search_format")
	private String dateSearchFormat;
 	/**date_display*/
 	@TableField("date_display")
	private Boolean dateDisplay;
 	/**date_max_value*/
 	@TableField("date_max_value")
	private Date dateMaxValue;
 	/**date_min_value*/
 	@TableField("date_min_value")
	private Date dateMinValue;
 	/**file_dir*/
 	@TableField("file_dir")
	private String fileDir;
 	/**file_type*/
 	@TableField("file_type")
	private String fileType;
 	/**file_name_rule*/
 	@TableField("file_name_rule")
	private String fileNameRule;
 	/**bo_code*/
 	@TableField("bo_code")
	private String boCode;
 	/**bo_display_level*/
 	@TableField("bo_display_level")
	private Integer boDisplayLevel;
 	/**bo_select_type*/
 	@TableField("bo_select_type")
	private String boSelectType;
 	/**number_decimals*/
 	@TableField("number_decimals")
	private Integer numberDecimals;
 	/**number_max_value*/
 	@TableField("number_max_value")
	private String numberMaxValue;
 	/**number_min_value*/
 	@TableField("number_min_value")
	private String numberMinValue;
 	/**number_pre_unit*/
 	@TableField("number_pre_unit")
	private String numberPreUnit;
 	/**number_unit*/
 	@TableField("number_unit")
	private String numberUnit;
 	/**string_regular*/
 	@TableField("string_regular")
	private String stringRegular;
 	/**string_max_length*/
 	@TableField("string_max_length")
	private Integer stringMaxLength;
 	/**string_min_length*/
 	@TableField("string_min_length")
	private Integer stringMinLength;
 	/**string_multi_line*/
 	@TableField("string_multi_line")
	private Boolean stringMultiLine;
 	/**user_role_code*/
 	@TableField("user_role_code")
	private String userRoleCode;
 	/**active*/
 	@TableField("active")
	private Integer active;
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
 	/**idx*/
 	@TableField("idx")
	private Integer idx;
 	/**group_able*/
 	@TableField("group_able")
	private Boolean groupAble;
 	/**carmera_pic_only*/
 	@TableField("carmera_pic_only")
	private Boolean carmeraPicOnly;
 	/**default_value*/
 	@TableField("default_value")
	private String defaultValue;
 	/**bo_pic_type*/
 	@TableField("bo_pic_type")
	private Integer boPicType;
 	/**logic*/
 	@TableField("logic")
	private String logic;
 	/**logic_code*/
 	@TableField("logic_code")
	private String logicCode;
 	/**remark*/
 	@TableField("remark")
	private String remark;
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**code*/
 	@TableField("code")
	private String code;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**type*/
 	@TableField("type")
	private String type;
 	/**column_name*/
 	@TableField("column_name")
	private String columnName;
 	/**null_able*/
 	@TableField("null_able")
	private Boolean nullAble;
 	/**sort_able*/
 	@TableField("sort_able")
	private Boolean sortAble;
 	/**filter_able*/
 	@TableField("filter_able")
	private Boolean filterAble;
 	/**unique_able*/
 	@TableField("unique_able")
	private Boolean uniqueAble;
 	/**show_in_detail*/
 	@TableField("show_in_detail")
	private Boolean showInDetail;
 	/**show_in_list*/
 	@TableField("show_in_list")
	private Boolean showInList;
 	/**bo_short_display*/
 	@TableField("bo_short_display")
	private Boolean boShortDisplay;
 	/**bo_union_key*/
 	@TableField("bo_union_key")
	private Boolean boUnionKey;
 	/**co_code*/
 	@TableField("co_code")
	private String coCode;
 	/**co_display_type*/
 	@TableField("co_display_type")
	private String coDisplayType;
 	/**date_display_format*/
 	@TableField("date_display_format")
	private String dateDisplayFormat;
 	/**date_search_format*/
 	@TableField("date_search_format")
	private String dateSearchFormat;
 	/**date_display*/
 	@TableField("date_display")
	private Boolean dateDisplay;
 	/**date_max_value*/
 	@TableField("date_max_value")
	private Date dateMaxValue;
 	/**date_min_value*/
 	@TableField("date_min_value")
	private Date dateMinValue;
 	/**file_dir*/
 	@TableField("file_dir")
	private String fileDir;
 	/**file_type*/
 	@TableField("file_type")
	private String fileType;
 	/**file_name_rule*/
 	@TableField("file_name_rule")
	private String fileNameRule;
 	/**bo_code*/
 	@TableField("bo_code")
	private String boCode;
 	/**bo_display_level*/
 	@TableField("bo_display_level")
	private Integer boDisplayLevel;
 	/**bo_select_type*/
 	@TableField("bo_select_type")
	private String boSelectType;
 	/**number_decimals*/
 	@TableField("number_decimals")
	private Integer numberDecimals;
 	/**number_max_value*/
 	@TableField("number_max_value")
	private String numberMaxValue;
 	/**number_min_value*/
 	@TableField("number_min_value")
	private String numberMinValue;
 	/**number_pre_unit*/
 	@TableField("number_pre_unit")
	private String numberPreUnit;
 	/**number_unit*/
 	@TableField("number_unit")
	private String numberUnit;
 	/**string_regular*/
 	@TableField("string_regular")
	private String stringRegular;
 	/**string_max_length*/
 	@TableField("string_max_length")
	private Integer stringMaxLength;
 	/**string_min_length*/
 	@TableField("string_min_length")
	private Integer stringMinLength;
 	/**string_multi_line*/
 	@TableField("string_multi_line")
	private Boolean stringMultiLine;
 	/**user_role_code*/
 	@TableField("user_role_code")
	private String userRoleCode;
 	/**active*/
 	@TableField("active")
	private Integer active;
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
 	/**idx*/
 	@TableField("idx")
	private Integer idx;
 	/**group_able*/
 	@TableField("group_able")
	private Boolean groupAble;
 	/**carmera_pic_only*/
 	@TableField("carmera_pic_only")
	private Boolean carmeraPicOnly;
 	/**default_value*/
 	@TableField("default_value")
	private String defaultValue;
 	/**bo_pic_type*/
 	@TableField("bo_pic_type")
	private Integer boPicType;
 	/**logic*/
 	@TableField("logic")
	private String logic;
 	/**logic_code*/
 	@TableField("logic_code")
	private String logicCode;
 	/**remark*/
 	@TableField("remark")
	private String remark;
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**code*/
 	@TableField("code")
	private String code;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**type*/
 	@TableField("type")
	private String type;
 	/**column_name*/
 	@TableField("column_name")
	private String columnName;
 	/**null_able*/
 	@TableField("null_able")
	private Boolean nullAble;
 	/**sort_able*/
 	@TableField("sort_able")
	private Boolean sortAble;
 	/**filter_able*/
 	@TableField("filter_able")
	private Boolean filterAble;
 	/**unique_able*/
 	@TableField("unique_able")
	private Boolean uniqueAble;
 	/**show_in_detail*/
 	@TableField("show_in_detail")
	private Boolean showInDetail;
 	/**show_in_list*/
 	@TableField("show_in_list")
	private Boolean showInList;
 	/**bo_short_display*/
 	@TableField("bo_short_display")
	private Boolean boShortDisplay;
 	/**bo_union_key*/
 	@TableField("bo_union_key")
	private Boolean boUnionKey;
 	/**co_code*/
 	@TableField("co_code")
	private String coCode;
 	/**co_display_type*/
 	@TableField("co_display_type")
	private String coDisplayType;
 	/**date_display_format*/
 	@TableField("date_display_format")
	private String dateDisplayFormat;
 	/**date_search_format*/
 	@TableField("date_search_format")
	private String dateSearchFormat;
 	/**date_display*/
 	@TableField("date_display")
	private Boolean dateDisplay;
 	/**date_max_value*/
 	@TableField("date_max_value")
	private Date dateMaxValue;
 	/**date_min_value*/
 	@TableField("date_min_value")
	private Date dateMinValue;
 	/**file_dir*/
 	@TableField("file_dir")
	private String fileDir;
 	/**file_type*/
 	@TableField("file_type")
	private String fileType;
 	/**file_name_rule*/
 	@TableField("file_name_rule")
	private String fileNameRule;
 	/**bo_code*/
 	@TableField("bo_code")
	private String boCode;
 	/**bo_display_level*/
 	@TableField("bo_display_level")
	private Integer boDisplayLevel;
 	/**bo_select_type*/
 	@TableField("bo_select_type")
	private String boSelectType;
 	/**number_decimals*/
 	@TableField("number_decimals")
	private Integer numberDecimals;
 	/**number_max_value*/
 	@TableField("number_max_value")
	private String numberMaxValue;
 	/**number_min_value*/
 	@TableField("number_min_value")
	private String numberMinValue;
 	/**number_pre_unit*/
 	@TableField("number_pre_unit")
	private String numberPreUnit;
 	/**number_unit*/
 	@TableField("number_unit")
	private String numberUnit;
 	/**string_regular*/
 	@TableField("string_regular")
	private String stringRegular;
 	/**string_max_length*/
 	@TableField("string_max_length")
	private Integer stringMaxLength;
 	/**string_min_length*/
 	@TableField("string_min_length")
	private Integer stringMinLength;
 	/**string_multi_line*/
 	@TableField("string_multi_line")
	private Boolean stringMultiLine;
 	/**user_role_code*/
 	@TableField("user_role_code")
	private String userRoleCode;
 	/**active*/
 	@TableField("active")
	private Integer active;
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
 	/**idx*/
 	@TableField("idx")
	private Integer idx;
 	/**group_able*/
 	@TableField("group_able")
	private Boolean groupAble;
 	/**carmera_pic_only*/
 	@TableField("carmera_pic_only")
	private Boolean carmeraPicOnly;
 	/**default_value*/
 	@TableField("default_value")
	private String defaultValue;
 	/**bo_pic_type*/
 	@TableField("bo_pic_type")
	private Integer boPicType;
 	/**logic*/
 	@TableField("logic")
	private String logic;
 	/**logic_code*/
 	@TableField("logic_code")
	private String logicCode;
 	/**remark*/
 	@TableField("remark")
	private String remark;
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**code*/
 	@TableField("code")
	private String code;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**type*/
 	@TableField("type")
	private String type;
 	/**column_name*/
 	@TableField("column_name")
	private String columnName;
 	/**null_able*/
 	@TableField("null_able")
	private Boolean nullAble;
 	/**sort_able*/
 	@TableField("sort_able")
	private Boolean sortAble;
 	/**filter_able*/
 	@TableField("filter_able")
	private Boolean filterAble;
 	/**unique_able*/
 	@TableField("unique_able")
	private Boolean uniqueAble;
 	/**show_in_detail*/
 	@TableField("show_in_detail")
	private Boolean showInDetail;
 	/**show_in_list*/
 	@TableField("show_in_list")
	private Boolean showInList;
 	/**bo_short_display*/
 	@TableField("bo_short_display")
	private Boolean boShortDisplay;
 	/**bo_union_key*/
 	@TableField("bo_union_key")
	private Boolean boUnionKey;
 	/**co_code*/
 	@TableField("co_code")
	private String coCode;
 	/**co_display_type*/
 	@TableField("co_display_type")
	private String coDisplayType;
 	/**date_display_format*/
 	@TableField("date_display_format")
	private String dateDisplayFormat;
 	/**date_search_format*/
 	@TableField("date_search_format")
	private String dateSearchFormat;
 	/**date_display*/
 	@TableField("date_display")
	private Boolean dateDisplay;
 	/**date_max_value*/
 	@TableField("date_max_value")
	private Date dateMaxValue;
 	/**date_min_value*/
 	@TableField("date_min_value")
	private Date dateMinValue;
 	/**file_dir*/
 	@TableField("file_dir")
	private String fileDir;
 	/**file_type*/
 	@TableField("file_type")
	private String fileType;
 	/**file_name_rule*/
 	@TableField("file_name_rule")
	private String fileNameRule;
 	/**bo_code*/
 	@TableField("bo_code")
	private String boCode;
 	/**bo_display_level*/
 	@TableField("bo_display_level")
	private Integer boDisplayLevel;
 	/**bo_select_type*/
 	@TableField("bo_select_type")
	private String boSelectType;
 	/**number_decimals*/
 	@TableField("number_decimals")
	private Integer numberDecimals;
 	/**number_max_value*/
 	@TableField("number_max_value")
	private String numberMaxValue;
 	/**number_min_value*/
 	@TableField("number_min_value")
	private String numberMinValue;
 	/**number_pre_unit*/
 	@TableField("number_pre_unit")
	private String numberPreUnit;
 	/**number_unit*/
 	@TableField("number_unit")
	private String numberUnit;
 	/**string_regular*/
 	@TableField("string_regular")
	private String stringRegular;
 	/**string_max_length*/
 	@TableField("string_max_length")
	private Integer stringMaxLength;
 	/**string_min_length*/
 	@TableField("string_min_length")
	private Integer stringMinLength;
 	/**string_multi_line*/
 	@TableField("string_multi_line")
	private Boolean stringMultiLine;
 	/**user_role_code*/
 	@TableField("user_role_code")
	private String userRoleCode;
 	/**active*/
 	@TableField("active")
	private Integer active;
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
 	/**idx*/
 	@TableField("idx")
	private Integer idx;
 	/**group_able*/
 	@TableField("group_able")
	private Boolean groupAble;
 	/**carmera_pic_only*/
 	@TableField("carmera_pic_only")
	private Boolean carmeraPicOnly;
 	/**default_value*/
 	@TableField("default_value")
	private String defaultValue;
 	/**bo_pic_type*/
 	@TableField("bo_pic_type")
	private Integer boPicType;
 	/**logic*/
 	@TableField("logic")
	private String logic;
 	/**logic_code*/
 	@TableField("logic_code")
	private String logicCode;
 	/**remark*/
 	@TableField("remark")
	private String remark;
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**property_id*/
 	@TableField("property_id")
	private Integer propertyId;
 	/**os_type*/
 	@TableField("os_type")
	private Integer osType;
 	/**role*/
 	@TableField("role")
	private Integer role;
 	/**add_able*/
 	@TableField("add_able")
	private Boolean addAble;
 	/**edit_able*/
 	@TableField("edit_able")
	private Boolean editAble;
 	/**show_in_list*/
 	@TableField("show_in_list")
	private Boolean showInList;
 	/**show_in_detail*/
 	@TableField("show_in_detail")
	private Boolean showInDetail;
 	/**null_able*/
 	@TableField("null_able")
	private Boolean nullAble;
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
 	/**idx*/
 	@TableField("idx")
	private Integer idx;
 	/**id*/
 	@TableField("id")
	private Integer id;
 	/**name*/
 	@TableField("name")
	private String name;
 	/**parent_bo_id*/
 	@TableField("parent_bo_id")
	private Integer parentBoId;
 	/**bo_id*/
 	@TableField("bo_id")
	private Integer boId;
 	/**type*/
 	@TableField("type")
	private Integer type;
 	/**idx*/
 	@TableField("idx")
	private Integer idx;
 	/**update_time*/
 	@TableField("update_time")
	private Date updateTime;
 	/**create_time*/
 	@TableField("create_time")
	private Date createTime;
 	/**active*/
 	@TableField("active")
	private Integer active;
}


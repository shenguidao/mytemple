package cn.dz.daima.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
   /**
    * loginlog 实体类
    * Thu May 09 16:17:00 CST 2019 tom
    */ 
@TableName("loginlog")
@Data
public class LoginlogEntity{
 	/**主键ID*/
 	@TableField("id")
	private int id;
 	/**用户ID*/
 	@TableField("user_id")
	private int userId;
 	/**登录时间*/
 	@TableField("login_time")
	private Date loginTime;
 	/**功能设备类型（字典关联项：common.function.ostype）*/
 	@TableField("os_type")
	private boolean osType;
 	/**功能设备信息*/
 	@TableField("os_info")
	private String osInfo;
 	/**系统版本*/
 	@TableField("version")
	private String version;
 	/**MAC地址*/
 	@TableField("mac")
	private String mac;
 	/**IP地址*/
 	@TableField("ip")
	private String ip;
}


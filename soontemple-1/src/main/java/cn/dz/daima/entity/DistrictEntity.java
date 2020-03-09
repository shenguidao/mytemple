package cn.dz.daima.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
   /**
    * t_kgt_district 实体类
    * Thu Mar 14 18:16:36 CST 2019 tom
    */ 
@TableName("t_kgt_district")
public class DistrictEntity{
 	/**id*/
 	@TableField("id")
	private int id;
 	/**地区名*/
 	@TableField("name")
	private String name;
 	/**城市id*/
 	@TableField("city_id")
	private int cityId;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setCityId(int cityId){
	this.cityId=cityId;
	}
	public int getCityId(){
		return cityId;
	}
}


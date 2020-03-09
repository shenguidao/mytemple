package cn.dz.daima.entity;

import java.io.Serializable;

public class RestMap implements Serializable {
	private static final long serialVersionUID = -8567913121391147286L;
	
	public RestMap() {
	}

	public RestMap(String code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/** 返回的编码 */
	private String code;
	
	/** 返回的信息 */
	private String msg;
	
	/** 返回的是一个Object，可以是map，可以list，可以任意的实体类 */
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RestMap [code=" + code + ", msg=" + msg + ", data=" + data
				+ "]";
	}
	
}

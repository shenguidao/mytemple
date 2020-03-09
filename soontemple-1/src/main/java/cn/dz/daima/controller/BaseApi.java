package cn.dz.daima.controller;

import com.offtake.common.REConst;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


/**
 * 基础api，处理一些通用的信息
 * 
 * @author Administrator
 * 
 */
public abstract class BaseApi implements REConst {

	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	protected boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 密码的任何字符不允许出现3次或以上
	 * 
	 * @param str
	 * @return
	 */
	protected boolean pwdCharCount(String str) {
		boolean isBoolean = true;
		for (int i = 0; i < str.length(); i++) {
			String c = String.valueOf(str.charAt(i));
			int charCount = 0;
			for (int j = 0; j < str.length(); j++) {
				String cc = String.valueOf(str.charAt(j));
				if (c.equals(cc)) {
					charCount++;
				}
			}
			if (charCount > 3) {
				isBoolean = false;
				break;
			}
		}
		return isBoolean;
	}

	/**
	 * 获取请求的系统真实路径
	 * 
	 * @param request
	 * @return
	 */
	protected String getContextPath(HttpServletRequest request) {
		String url = request.getScheme() + "://" + request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() // 端口号
				+ request.getContextPath();
		return url;
	}

	/**
	 * 获取百分比
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	protected String getDecimalFormat(Integer num1, Integer num2) {
		// 创建一个数值格式化对象
		DecimalFormat decimalFormat = new DecimalFormat("######0");
		// 求百分比
		String staudyRate = decimalFormat.format((float) num1 / (float) num2
				* 100);
		return staudyRate;
	}

}

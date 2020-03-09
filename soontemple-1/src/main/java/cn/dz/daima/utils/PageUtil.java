package cn.dz.daima.utils;
/**
* @author Bob
* @version 1.0
* 创建时间：2019年1月2日 下午1:48:26
* offtake-common
*/
public class PageUtil {
	/** 获取总页数 */
	public static int getPage(int total,int pageSize) {
		return (total + pageSize -1) / pageSize;
	}
}

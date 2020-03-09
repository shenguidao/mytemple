package cn.dz.daima.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* @author Bob
* @version 1.0
* 创建时间：2019年1月2日 下午4:29:23
* offtake-common
* md5加密
*/
public class MD5Utils {
	public static String MD5Encode(String sourceStr){
		String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            //result = buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}

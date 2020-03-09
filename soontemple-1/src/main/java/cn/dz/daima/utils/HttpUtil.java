package cn.dz.daima.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
* @Description（描述）: http请求，接口url调用，相关公共类
* @Author:         ethan
* @CreateDate:     2019/1/8 11:34
* @UpdateUser:     ethan
* @UpdateDate:     2019/1/8 11:34
* @UpdateRemark:
* @Version:        1.0
*/
public class HttpUtil {

    /**
     * HttpURLConnection POST请求
     * @param url 接口链接
     * @param param 参数
     * @return
     */
    public static String httpUrlConnectionPostxml(String url, String param){
        InputStream is = null;
        BufferedReader br = null;
        HttpURLConnection uRLConnection = null;
        try {
            URL realUrl = new URL(url);
            uRLConnection = (HttpURLConnection)realUrl.openConnection();
            uRLConnection.setDoInput(true);
            uRLConnection.setDoOutput(true);
            uRLConnection.setRequestMethod("POST");
            uRLConnection.setUseCaches(false);
            uRLConnection.setInstanceFollowRedirects(false);
            uRLConnection.setRequestProperty("Content-Type", "application/xml");
            uRLConnection.connect();
            uRLConnection.setConnectTimeout(15000);
            uRLConnection.setReadTimeout(15000);

            DataOutputStream out = new DataOutputStream(uRLConnection.getOutputStream());
            //String content = "username="+username+"&password="+password;
            out.writeBytes(param);
            out.flush();
            out.close();

            is = uRLConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            String response = "";
            String readLine = null;
            while((readLine =br.readLine()) != null){
                //response = br.readLine();
                response = response + readLine;
            }
            is.close();
            br.close();
            uRLConnection.disconnect();
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try{
                if(is!=null){
                    is.close();
                }
                if(br!=null){
                    br.close();
                }
                if(uRLConnection!=null){
                    uRLConnection.disconnect();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static String getXmlInfo(String eaorder) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<orderOutboundRequest version=\"0.1\" login=\"HvUhFfcw\" password=\"RZZEKJKUec0FUtho\">");
        sb.append("<queries>");
        sb.append("<query>");
        sb.append("<attribute>erpNumber</attribute>");
        sb.append("<eq>"+eaorder+"</eq>");
        sb.append("</query>");
       /* sb.append("<query>");
        sb.append("<attribute>pickupSla</attribute>");
        sb.append("<ge>2017-1-1</ge>");
        sb.append("<le>2018-7-31</le>");
        sb.append("</query>");
        sb.append("<query>");
        sb.append("<attribute>customText1</attribute>");
        sb.append("<eq>STANDSP</eq>");
        sb.append("</query>");
        sb.append("<query>");
        sb.append("<attribute>customText14</attribute>");
        sb.append("<eq>2600158714</eq>");
        sb.append("</query>"); */
        sb.append("</queries>");
        sb.append("<includeOrderInfo>true</includeOrderInfo>");
/*	        sb.append("<includeOrderPosition>true</includeOrderPosition>");
        sb.append("<includeLocationHistory>true</includeLocationHistory>");  */
        sb.append("<orderBy>");
        sb.append("<desc>pickupSla</desc>");
        sb.append("</orderBy>");
        sb.append("<start>1</start>");
        sb.append("<count>10</count>");
        sb.append("</orderOutboundRequest>");
        return sb.toString();
    }

}

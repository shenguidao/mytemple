package cn.dz.daima.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InterfaceRequestUtils {

	public static final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded");
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
	public final static String httpGet(String url, String param) {
		 String result = "";
	        BufferedReader in = null;
	        InputStreamReader inStreamReader=null;
	        try {
	            String urlNameString = url + "?" + param;
	            URL realUrl = new URL(urlNameString);
	            // 打开和URL之间的连接
	            URLConnection connection = realUrl.openConnection();
	            // 设置通用的请求属性
	            connection.setRequestProperty("accept", "*/*");
	            //connection.setRequestProperty("connection", "Keep-Alive");
	            connection.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            connection.setConnectTimeout(15000);
	            connection.setReadTimeout(15000);
	            // 建立实际的连接
	            connection.connect();
	            // 获取所有响应头字段
	            Map<String, List<String>> map = connection.getHeaderFields();
	            // 遍历所有的响应头字段
	            for (String key : map.keySet()) {
	                System.out.println(key + "--->" + map.get(key));
	            }
	            // 定义 BufferedReader输入流来读取URL的响应
	            inStreamReader = new InputStreamReader(connection.getInputStream());
	            in = new BufferedReader(inStreamReader);
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送GET请求出现异常！" + e);
	            e.printStackTrace();
	        }
	        // 使用finally块来关闭输入流
	        finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	                if (inStreamReader!=null) {
	                	inStreamReader.close();
					}
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return result;
	}
	
	public final static String MD5Hash(String sourceStr){
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
	
	public final static String httpPost(String url, String param) {
		PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            //conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(15000);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            int statusCode=conn.getResponseCode();
            if (statusCode == 200) {  
            	// 定义BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } else {  
            	return "failure";
            }  
            
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
	}
	
	/**
	 * HttpURLConnection GET请求
	 * @param url 接口链接
	 * @param param 参数
	 * @return
	 */
	public final static String httpUrlConnectionGet(String url, String param){
        String getUrl = url + "?" + param;
        InputStream is = null;
        BufferedReader br = null;
        HttpURLConnection uRLConnection = null;
        try {
        	URL realUrl = new URL(getUrl);
        	uRLConnection = (HttpURLConnection)realUrl.openConnection();
        	// 设置通用的请求属性
        	uRLConnection.setRequestProperty("accept", "*/*");
        	uRLConnection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        	uRLConnection.setConnectTimeout(15000);
            uRLConnection.setReadTimeout(15000);
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
	/**
	 * HttpURLConnection POST请求
	 * @param url 接口链接
	 * @param param 参数
	 * @return
	 */
    public final static String httpUrlConnectionPost(String url, String param){
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
            //Postman-Token: 4ba18b9b-0177-4c75-9297-bad8cd007071
            //Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
            uRLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //uRLConnection.setRequestProperty("Server","Microsoft-IIS/7.5");
            // 设置通用的请求属性
            //uRLConnection.setRequestProperty("accept", "*/*");
            //uRLConnection.setRequestProperty("user-agent",
            //        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            uRLConnection.setConnectTimeout(15000);
            uRLConnection.setReadTimeout(15000);
            uRLConnection.connect();
            
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
    
    /**
	 * httpOkHttpClientPost POST请求
	 * @param url 接口链接
	 * @param param 参数
	 * @return
	 */
    public final static String httpOkHttpClientPost(String url, String param){
    	String result="";
    	Call call = null;
    	Response response = null;
    	try {
    		/*OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
    	    
    	    Request request = new Request.Builder()//创建Request 对象。
    	            .url("http://www.baidu.com")
    	            .post(param.build())//传递请求体
    	            .build();*/
	    	OkHttpClient httpClient = new OkHttpClient.Builder()
	        .connectTimeout(18000, TimeUnit.MILLISECONDS)
	        .readTimeout(18000, TimeUnit.MILLISECONDS)
	        .build();
	    	
	    	RequestBody requestBody = RequestBody.create(JSON, param);
	        Request request = new Request.Builder()
	                .url(url)
	                .post(requestBody)
	                .addHeader("content-type", "application/x-www-form-urlencoded")
	                .addHeader("cache-control", "no-cache")
	                .addHeader("postman-token", "e115bedc-febb-43c7-98f5-86994a12001d")
	                .build();
	        call = httpClient.newCall(request);
            response = call.execute();
			//response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
            	result = response.body().string();
            }
	    	call.cancel();
	    	response.close();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (null!=call) {
				call.cancel();
			}
			if (null!=response) {
				response.close();
			}
		}
        return result;
    }
	
	public final static void executorHuiYao(String url, String param) {
		
	}
}

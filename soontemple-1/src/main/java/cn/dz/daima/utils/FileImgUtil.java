package cn.dz.daima.utils;

//import com.offtake.common.cache.DictCache;
//import org.apache.http.Consts;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.entity.mime.content.StringBody;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;

import java.io.FileNotFoundException;
import java.io.IOException;


public class FileImgUtil {

//	/**
//	 *
//	 * 使用通用方法上传图片
//	 *
//	 * @param file   fileName  fileDir   addPath
//	 * @param fileName
//	 * @throws IOException
//	 * @throws FileNotFoundException
//	 */
//	public static String uploadByte(File file,String fileName,String fileDir,String addPath) throws FileNotFoundException,IOException{
//		        // 1. 创建上传需要的元素类型
//				// 1.1 装载本地上传图片的文件
//		        String url = DictCache.getInstance().getDict("common.offtakeupload.url").getValue();
//		        System.out.println("upload url:"+url);
////				File imageFile = new File("d:/s.png");
//				FileBody imageFileBody = new FileBody(file);
//				// 1.2 装载上传字符串的对象
//				StringBody name = new StringBody(fileName,ContentType.TEXT_PLAIN);
//				StringBody filedir = new StringBody(fileDir,ContentType.TEXT_PLAIN);
//				StringBody addpath = new StringBody(addPath,ContentType.TEXT_PLAIN);
//				// 2. 将所有需要上传元素打包成HttpEntity对象
//				HttpEntity reqEntity = MultipartEntityBuilder.create()
//						.addPart("fileName", name)
//						.addPart("image",imageFileBody)
//						.addPart("fileDir",filedir)
//						.addPart("addPath",addpath)
//						.build();
//				// 3. 创建HttpPost对象，用于包含信息发送post消息
//				HttpPost httpPost = new HttpPost(url);
//				httpPost.setEntity(reqEntity);
//				// 4. 创建HttpClient对象，传入httpPost执行发送网络请求的动作
//				CloseableHttpClient httpClient = HttpClients.createDefault();
//				CloseableHttpResponse response = httpClient.execute(httpPost);
//				// 5. 获取返回的实体内容对象并解析内容
//				HttpEntity resultEntity = response.getEntity();
//				String responseMessage = "";
//				try{
//					if(resultEntity!=null){
//						InputStream is = resultEntity.getContent();
//						BufferedReader br = new BufferedReader(new InputStreamReader(is));
//						StringBuffer sb = new StringBuffer();
//						String line = "";
//						while((line = br.readLine()) != null){
//							sb.append(line);
//						}
//						responseMessage = sb.toString();
//					}
//				    EntityUtils.consume(resultEntity);
//				}finally{
//					if (null != response){
//		                response.close();
//		            }
//				}
//				return fileDir + addPath + responseMessage;
//
//	}
	
//	public static String uploadBytes(byte[] buf,String fileName,String fileDir,String addPath) throws FileNotFoundException,IOException{
//		 //创建HttpClient对象
//       CloseableHttpClient client = HttpClients.createDefault();
//       //构建POST请求   请求地址请更换为自己的。
//       //1)数据字典中获取调用文件上传的接口地址
//		String url = DictCache.getInstance().getDict("common.offtakeupload.url").getValue();
//		HttpPost post = new HttpPost(url);
//       //HttpPost post = new HttpPost(DictFactory.getDictTypeByCode("common.offtakeupload.url").getValue());
//       InputStream inputStream = null;
//       if(fileName.contains("/")){
//    	   fileName = fileName.substring(11);
//       }
//       try {
//           //文件路径请换成自己的
//           //2)
//           inputStream = new ByteArrayInputStream(buf);
//           MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//           builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//           //第一个参数为 相当于 Form表单提交的file框的name值 第二个参数就是我们要发送的InputStream对象了
//           //第三个参数是文件名
//           //3)
//           builder.addBinaryBody("image", inputStream, ContentType.create("multipart/form-data"), fileName);
//           //4)构建请求参数 普通表单项
//           StringBody filedirBody = new StringBody(fileDir,ContentType.MULTIPART_FORM_DATA);
//           StringBody addpathBody = new StringBody(addPath,ContentType.MULTIPART_FORM_DATA);
//           StringBody nameBody = new StringBody(fileName,ContentType.TEXT_PLAIN);
//           builder.addPart("addPath",addpathBody);
//           builder.addPart("fileDir",filedirBody);
//           builder.addPart("fileName",nameBody);
//           HttpEntity entity = builder.build();
//           post.setEntity(entity);
//           //发送请求
//           HttpResponse response = client.execute(post);
//           entity = response.getEntity();
//           if (entity != null) {
//               inputStream = entity.getContent();
//               //转换为字节输入流
//               BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Consts.UTF_8));
//               String body = null;
//               while ((body = br.readLine()) != null) {
//                   System.out.println(body);
//               }
//           }
//       } catch (FileNotFoundException e) {
//           e.printStackTrace();
//       } catch (ClientProtocolException e) {
//           e.printStackTrace();
//       } catch (IOException e) {
//           e.printStackTrace();
//       }finally {
//           if(inputStream != null){
//               try {
//                   inputStream.close();
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//           }
//       }
//		return fileDir + addPath + fileName;
//}

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//FileImgUtil.uploadByte(null);
	}
	
}

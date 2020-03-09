

import cn.dz.daima.utils.CommonBaseUtils;
import cn.dz.daima.utils.CommonUtils;
import cn.dz.daima.utils.DateUtil;


import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import cn.dz.daima.utils.InterfaceRequestUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.apache.commons.lang3.StringUtils;

import org.springframework.jdbc.core.JdbcTemplate;

public class SyncImportOrderListStatusTask {

	private static JdbcTemplate jdbcTemplate;
    private static String date;

	public static void main(String[] args) {


    	try {
    		String time = DateUtil.formateDate(DateUtil.getCurrentDate(), "yyyy-MM-dd HH:mm:ss");
    		System.out.println("SyncImportOrderListStatusTask.process 开始！" + time);
    		//获取当前日期前天的数据
			date = DateUtil.formateDate(DateUtil.addDay(DateUtil.getCurrentDate(), -2),"yyyy-MM-dd");
			//batchUpdateData();
	    	
	    	String backinfo=getOrderListStatusList(1,2000);
	    	
	    	Document doc = null;  
		    doc = DocumentHelper.parseText(backinfo); // 将字符串转为XML  
		    Element rootElt = doc.getRootElement(); // 获取根节点  
		    JSONObject jsonObject=JSONObject.fromObject(rootElt.getTextTrim());
	    	
			System.out.println("任务同步返回"+backinfo);
		    String success=CommonBaseUtils.isNull1(jsonObject.get("Flag"));
		    if("true".equals(success)){

		    	String pagecount=CommonBaseUtils.isNumber1(jsonObject.getString("RecordCount"), "0");
		    	int datacount=Integer.parseInt(pagecount);
		    	int pac=(int) (datacount/2000)+1;
		    	if(datacount>0){
					for(int j=0;j<pac;j++){
						String back_info=getOrderListStatusList(j+1,2000);
						int insert_count = batchInsertData(back_info,j+1);
						if(insert_count < 1){
							continue;
						}
					}
		    		jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
		    				+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '执行成功', now(), 1, '"+ datacount +"');");
		    	}else{
		    		jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
		    				+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '没有数据', now(), 0, 0);");
	    		}
		    	batchUpdateData();
		    }else{
		    	jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
	    				+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '" + jsonObject.get("Message") + "', now(), 0, 0);");
		    }
       	} catch (Exception e) {
			// TODO: handle exception
			jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
    				+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '"+ CommonUtils.getErrorInfo(e).replaceAll("'", "") +"', now(), 0, 0);");
			System.out.println("SyncImportOrderListStatusTask 异常！错误信息:"+CommonUtils.getErrorInfo(e));
			e.printStackTrace();
		}
    }


	public boolean accept(File dir, String name) {
		return false;
	}
	/**
	 * 获得销售数据状态回传数据
	 * @param PageIndex 查询页码
	 * @param PageSize 每页行数
	 * @return
	 */
	public static String getOrderListStatusList(int PageIndex,int PageSize){
		String back_info="";
		try {
			String token="wyethapiservice2015";
			Integer ts=(int) (System.currentTimeMillis() / 1000);
			String str=token+ts;
			String sig=CommonBaseUtils.MD5Hash(str);
			//String date = DateUtil.formateDate(DateUtil.addDay(DateUtil.getCurrentDate(), -2),"yyyy-MM-dd");
			
			//date = "2018-11-18";
			//String EndTime = "2018-11-01";
			
			String jstr="{\"token\":\""+token+"\",\"ts\":"+ts+",\"StartTime\":\""+date+"\"," +"\"sig\":\""+sig+"\"," +
		        		"\"EndTime\":\""+date+"\",\"PageIndex\":\""+PageIndex+"\",\"PageSize\":\""+PageSize+"\"}";
			back_info = InterfaceRequestUtils.httpUrlConnectionPost("http://crmapi.etocrm.com:9999/CRMServiceForMZ.asmx/SyncOrderListStatus","JsonParameter="+jstr+"");
			
			
		} catch (Exception e) {
			 jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', 'getactitvlist异常"+ CommonUtils.getErrorInfo(e).replaceAll("'", "")+"', now(), 0, 0);");
			 e.printStackTrace();
		    // TODO: handle exception
			 return back_info;
	    }
	    return back_info;
	}
	/**
     * 更新购买记录数据
     * @param back_info 接口返回信息
     * @param page 页数
     * @return 执行成功条数
     */
    private static int batchInsertData(String back_info,int page) {
    	try{
    		//String syncDate = DateUtil.formateDate(DateUtil.getCurrentDate(), "yyyy-MM-dd");
			int start=back_info.indexOf("[");
			int end=back_info.indexOf("]");
			back_info=back_info.substring(start, end+1);
			JSONArray jsonArr = JSONArray.fromObject(back_info);
			int srrsize=jsonArr.size();
			if(srrsize>0){
				Connection connection = null;
				connection=getConnectionForMysql();
				connection.setAutoCommit(false);
				String sql="INSERT INTO `t_sync_orderlist_status` (`OrderID`, `srCode`, `Sku`, `Brand`, `MemberStatus`, `syncDate`, `dataFrom`, `creat_time`) VALUES ( ?, ?, ?, ?, ?, ?, ?, NOW());";
				PreparedStatement pst = connection.prepareStatement(sql);
				
				for (int i = 0; i < jsonArr.size(); i++) {
					pst.setString(1, CommonBaseUtils.isNull1(jsonArr.getJSONObject(i).getString("OrderID")));
					pst.setString(2, CommonBaseUtils.isNull1(jsonArr.getJSONObject(i).getString("srCode")));
					
					String Sku = CommonBaseUtils.isNull1(jsonArr.getJSONObject(i).getString("Sku"));
					String Brand = CommonBaseUtils.isNull1(jsonArr.getJSONObject(i).getString("Brand"));
					try {
						Brand=URLDecoder.decode(Brand,"UTF-8");
						Sku=URLDecoder.decode(Sku,"UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pst.setString(3, Sku);
					pst.setString(4, Brand);
					pst.setInt(5, Integer.parseInt(CommonBaseUtils.isNumber1(jsonArr.getJSONObject(i).getString("MemberStatus"), "404")));
					pst.setString(6, date);
					pst.setString(7, CommonBaseUtils.isNull1(jsonArr.getJSONObject(i).getString("DataFrom")));
					pst.addBatch();
					if((i+1) % 200==0){
						pst.executeBatch();
						connection.commit();
						pst.clearBatch();
					}
				}
				if(srrsize % 200 != 0){
					pst.executeBatch();
					connection.commit();
					pst.clearBatch();
				}
				pst.close();
				connection.close();
			}else{
				jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
						+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '页数+"+page+"+为空', now(), 0, 0);");
			}
			jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
					+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '页数 "+page+":同步"+srrsize+"行', now(), 0, 0);");
			return srrsize;
        }catch (Exception e) {
    		jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
    				+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '"+ CommonUtils.getErrorInfo(e).replace("'", "") +"页数"+page+"', now(), 0, 0);");
            System.out.println(e);
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * 更新购买记录数据
     * @param back_info 接口返回信息
     * @param page 页数
     * @return 执行成功条数
     */
    private static int batchUpdateData() {
    	try{
			List<Map<String, Object>> orderList = jdbcTemplate.queryForList(" SELECT `OrderID`, `srCode`, `Sku`, " +
					" IF(IFNULL(LENGTH(`Brand`),0) < 1,DictEntryTitle('new_customer.type',sku.sku_series),Brand) Brand " +
					" , `MemberStatus`, `syncDate`, `dataFrom` FROM t_sync_orderlist_status s " +
					" LEFT JOIN t_bo_sku sku ON s.Sku = sku.`code` " +
					" WHERE syncDate = '" + date + "'; ");
			int orderSize = orderList.size();
			if(null != orderList && orderList.size() > 0){ 
				/*Connection connection = null;  
				connection=getConnectionForMysql();
				connection.setAutoCommit(false);  */
				for (Map<String, Object> map : orderList) {
					String orderid = addSingleQuotationMark(CommonBaseUtils.isNull1(map.get("OrderID")));
					String MemberStatus = CommonBaseUtils.isNumber1(map.get("MemberStatus"), null);
					if ("404".equals(MemberStatus)) {
						MemberStatus = null;
					}
					MemberStatus = addSingleQuotationMark(MemberStatus);
					if(StringUtils.isBlank(orderid)){
						continue;
					}
					String Brand=CommonBaseUtils.isNull1(map.get("Brand"));
					try {
						Brand=URLDecoder.decode(Brand,"UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Brand = addSingleQuotationMark(Brand);
					
					String sql=" UPDATE `t_report_new_customer_offtake` SET customerType = " + MemberStatus + " WHERE `timestamp` = " + orderid + " AND brand = " + Brand + "; ";
					jdbcTemplate.execute(sql);
					List<Map<String, Object>> nc_offtakeList = jdbcTemplate.queryForList(" SELECT id FROM `t_report_new_customer_offtake` WHERE `timestamp` = " + orderid + " AND brand = " + Brand + " ");
					if (null != nc_offtakeList && nc_offtakeList.size() > 0) {
						for (Map<String, Object> map2 : nc_offtakeList) {
							String id = addSingleQuotationMark(CommonBaseUtils.isNull1(map2.get("id")));
							String sql2=" UPDATE t_report_customer_buyhistory SET customer_tpye = " + MemberStatus + " WHERE nc_offtake_id = " + id + " ";
							jdbcTemplate.execute(sql2);
						}
					}
					
				}

				
				//前天的购买记录中customer_tpye=0的数据更新其skuTypeId、skuType
				List<Map<String, Object>> buyhistoryList = jdbcTemplate.queryForList(" SELECT id FROM `t_report_customer_buyhistory` WHERE buyDate = '" + date + "' AND customer_tpye = 0; ");
				for (Map<String, Object> map : buyhistoryList) {
					int id = Integer.parseInt(CommonBaseUtils.isNumber1(map.get("id"), "0"));
					if (id > 0) {
						jdbcTemplate.execute(" UPDATE t_report_customer_buyhistory SET skuType = 'VIP',skuTypeId = '0' WHERE id = " + id + " ");
					}
				}
			}else{
				jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
						+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '没有更新数据', now(), 0, 0);");
			}
			jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
					+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '更新"+orderSize+"行', now(), 0, 0);");
			return orderSize;
        }catch (Exception e) {
    		jdbcTemplate.execute(" INSERT INTO `t_etms_task_execute_log` (`task_name`, `className`, `msg`, `sync_date`, success, `count`) "
    				+ "VALUES ('销量信息状态回传数据任务', 'SyncImportOrderListStatusTask.process', '"+ CommonUtils.getErrorInfo(e).replace("'", "") +"', now(), 0, 0);");
            e.printStackTrace();
            return 0;
        }
    }
    private static String addSingleQuotationMark(String str){
		if (!StringUtils.isBlank(str)) {
			str = "'" + str + "'";
		}
		return str;
	}
	
	public static Connection getConnectionForMysql() {
		Connection con = null; // 创建用于连接数据库的Connection对象
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动
			/*con = DriverManager
					.getConnection(
							"jdbc:mysql://116.62.52.172:3306/etms_offtake_test?useUnicode=true&characterEncoding=UTF-8",
							"root", "Passw0rdo1!");// 创建数据连接*/
			con = DriverManager
					.getConnection(
							"jdbc:mysql://220.248.105.57:3307/etms_offtake?useUnicode=true&characterEncoding=UTF-8",
							"offtake_db_user", "zaq!2wsx");// 创建线上
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return con; // 返回所建立的数据库连接
	}
}

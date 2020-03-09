import cn.dz.daima.controller.UserApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApi.class)
public class serviceJdbc {

    @Test
    public void test() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://10.236.72.41:24330;DatabaseName=POSDB.dbo";
        String user = "offtake_reader";
        String password = "offtake.123";
        Connection con = null;
        Statement st =null;
        ResultSet re = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            st = con.createStatement();
            String sql = "select Date,RetailGroup,RetailerCode,ProductCode,Num from POSDB.dbo.RetailerProductInfo_NKA aa\n" +
                    "where IsDelete = 0 and retailgroup = '孩子王' and DateType = 'day'";
            re=st.executeQuery(sql);
            while (re.next()){
                System.out.println(
                );
                System.out.println(re.getString("RetailGroup") +";"+re.getString("ProductCode") );
            }
        }catch (Exception e){

        }
    }
}

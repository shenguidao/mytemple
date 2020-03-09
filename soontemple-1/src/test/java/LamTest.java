import cn.dz.daima.controller.UserApi;
import cn.dz.daima.entity.Student;
import cn.dz.daima.utils.DateUtil;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApi.class)
public class LamTest {

   @Test
    public void test() throws Exception{
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test2.xlsx");

        try {
                //xie
                ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
                //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
                Sheet sheet1 = new Sheet(1, 0, Student.class);
                sheet1.setSheetName("大区");
                sheet1.setAutoWidth(Boolean.TRUE);
                setHeadMethod(sheet1);
           // List<Map<String, Object>> maps = jdbc.queryForList("select * form user");
           // System.out.println("maps = " + maps);
            List<Student> students = new LinkedList<Student>();
                Student student = new Student();
                student.setRegion("1");
                student.setMTD("2");
                student.setMtdIFFO("3");
                student.setMtdGUM("4");
                student.setGr("5");

                students.add(student);


                writer.write(students, sheet1);
                writer.finish();
                System.out.println("成功");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {

                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    private void setHeadMethod(Sheet sheet1) {
        List<List<String>> list = new ArrayList<>();
        ArrayList<String> a= new ArrayList<>();
        ArrayList<String> b= new ArrayList<>();
        ArrayList<String> c= new ArrayList<>();
        ArrayList<String> d= new ArrayList<>();
        ArrayList<String> e= new ArrayList<>();
        ArrayList<String> f= new ArrayList<>();
        ArrayList<String> g= new ArrayList<>();
        ArrayList<String> h= new ArrayList<>();
        ArrayList<String> i= new ArrayList<>();
        ArrayList<String> j= new ArrayList<>();
        ArrayList<String> k= new ArrayList<>();
        ArrayList<String> l= new ArrayList<>();
        ArrayList<String> m= new ArrayList<>();
        ArrayList<String> n= new ArrayList<>();
        ArrayList<String> o= new ArrayList<>();
        ArrayList<String> p= new ArrayList<>();
        ArrayList<String> q= new ArrayList<>();
        ArrayList<String> r= new ArrayList<>();
        ArrayList<String> s= new ArrayList<>();
        ArrayList<String> t= new ArrayList<>();
        ArrayList<String> u= new ArrayList<>();
        ArrayList<String> v= new ArrayList<>();
        ArrayList<String> w= new ArrayList<>();
        ArrayList<String> x= new ArrayList<>();
        ArrayList<String> y= new ArrayList<>();
        ArrayList<String> z= new ArrayList<>();
        ArrayList<String> aa= new ArrayList<>();
        ArrayList<String> ab= new ArrayList<>();
        ArrayList<String> ac= new ArrayList<>();
        ArrayList<String> ad= new ArrayList<>();
        ArrayList<String> ae= new ArrayList<>();


        a.add("截止日期：");
        a.add("时间进度：");
        a.add("");
        a.add("大区");
        a.add("大区");



        b.add(DateUtil.getStringdate(DateUtil.getCurrentDate()));
        b.add("3%");
        b.add("");
        b.add("8月MTD（KRMB）");
        b.add("8月MTD（KRMB）");

        String[]  arry = {"","","","8月MTD-IFFO（KRMB）","8月MTD-IFFO（KRMB）"};
        addArrayAll(c,arry,list);


        list.add(a);
        list.add(b);

        sheet1.setHead(list);
    }

    private void addArrayAll(ArrayList<String> s,String[]  arry, List<List<String>> list) {
        for (String s1 : arry) {
            s.add(s1);
        }
        list.add(s);
    }


}



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
//不完整版本,只能生成单个,且无法获取注释
public class GenEntity2 {


    private String packageOutPath = "cn.dz.daima.entity";//指定实体生成所在包的路径
    private String authorName = "tom";//作者名字
    private String tablename = "t_kgt_gift";//表名
    private String[] colnames; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*

    //数据库连接
    private static final String URL = "jdbc:mysql://118.31.246.224:3306/sfa_2.0";
    private static final String NAME = "sfa";
    private static final String PASS = "123456";

//    private static final String NAME = "root";
//    private static final String PASS = "m2g123";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    /*
     * 构造函数
     */
    public GenEntity2() {
        //创建连接
        Connection con;
        //查要生成实体类的表
        String sql = "select * from " + tablename;
        PreparedStatement pStemt = null;
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            con = DriverManager.getConnection(URL, NAME, PASS);

            pStemt = con.prepareStatement(sql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            int size = rsmd.getColumnCount();    //统计列
            System.out.println("size = " + size);
            colnames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];

            //这是通过ResultSetMetaData方法来构造
            for (int i = 0; i < size; i++) {
                colnames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
                System.out.println(i);
                if (colTypes[i].equalsIgnoreCase("datetime")) {
                    f_util = true;
                }
                if (colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")) {
                    f_sql = true;
                }
            }

            String content = parse(colnames, colTypes, colSizes);
            try {
                File directory = new File("");
                //得到路径
                String path = this.getClass().getResource("").getPath();

                System.out.println(path);
                //如果是父子项目,directory.getAbsolutePath()只能获取到父项目的src目录,可以自己更具需求变动
                String outputPath = directory.getAbsolutePath() + "/soontemple-1/src/main/java/" + this.packageOutPath.replace(".", "/") + "/" + initcap(tablename) + "Entity" + ".java";
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 功能：生成实体类主体代码
     *
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();
        //包路径,在上面统一配置
        sb.append("package " + this.packageOutPath + ";\r\n");
        sb.append("\r\n");
        //判断是否导入工具包
        if (f_util) {
            sb.append("import java.util.Date;\r\n");
        }
        if (f_sql) {
            sb.append("import java.sql.*;\r\n");
        }
        //tableName的jar包//Mybatis的注解,如果不需要注释即可
        sb.append("import com.baomidou.mybatisplus.annotations.TableName;\r\n");
        sb.append("import com.baomidou.mybatisplus.annotations.TableField;\r\n");
        //Lombok注解,需要打开即可
        //sb.append("import lombok.Data;\r\n");
        //注释部分
        sb.append("   /**\r\n");
        sb.append("    * " + tablename + " 实体类\r\n");
        sb.append("    * " + new Date() + " " + this.authorName + "\r\n");
        sb.append("    */ \r\n");
        //Mybatis的注解,如果不需要注释即可
        sb.append("@TableName(\"" + tablename + "\")");
        //Lombok注解
        //sb.append("@Data");
        //实体部分
        sb.append("\r\npublic class " + initcap(tablename) + "Entity{\r\n");
        processAllAttrs(sb);//属性
        processAllMethod(sb);//get set方法
        sb.append("}\r\n");
        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     *
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colnames.length; i++) {
            sb.append(" \t" + "/**" + colnames[i] + "*/" + "\r\n");
            //Mybatis的注解,如果不需要注释即可
            sb.append(" \t" + "@TableField(\"" + colnames[i] + "\")\r\n");
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + zhuan(colnames[i]) + ";\r\n");
        }

    }

    /**
     * 功能：生成所有方法,如果采用@Data,吧这个方法注释即可
     *
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {

        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tpublic void set" + initcap(zhuan(colnames[i])) + "(" + sqlType2JavaType(colTypes[i]) + " " +
                    zhuan(colnames[i]) + "){\r\n");
            sb.append("\tthis." + zhuan(colnames[i]) + "=" + zhuan(colnames[i]) + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(zhuan(colnames[i])) + "(){\r\n");
            sb.append("\t\treturn " + zhuan(colnames[i]) + ";\r\n");
            sb.append("\t}\r\n");
        }

    }

    /**
     * 功能：将输入字符串的首字母改成大写
     *
     * @param str
     * @return
     */
    private String initcap(String str) {

        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }

        return new String(ch);
    }

    //把_替换掉,并把_后面字母大写
    private String zhuan(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i != ch.length - 1) {
                if (ch[i] == '_') {
                    if (ch[i + 1] >= 'a' && ch[i + 1] <= 'z') {
                        ch[i + 1] = (char) (ch[i + 1] - 32);
                    }
                }
            }
        }
        String s = new String(ch);
        String replace = s.replace("_", "");
        return new String(replace);
    }

    /**
     * 功能：获得列的数据类型
     *
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {

        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return "int";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }

        return null;
    }

    /**
     * 出口
     * TODO
     *
     * @param args
     */
    public static void main(String[] args) {

        new GenEntity2();

    }

}



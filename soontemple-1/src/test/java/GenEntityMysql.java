import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

//自动生成实体类
/*
* 每个列描述都有以下列：
TABLE_CAT String => 表类别（可为null）
TABLE_SCHEM String => 表模式（可为null）
TABLE_NAME String => 表名称
COLUMN_NAME String => 列名称
DATA_TYPE int => 来自 java.sql.Types 的 SQL 类型
TYPE_NAME String => 数据源依赖的类型名称，对于 UDT，该类型名称是完全限定的
COLUMN_SIZE int => 列的大小。
BUFFER_LENGTH 未被使用。
DECIMAL_DIGITS int => 小数部分的位数。对于 DECIMAL_DIGITS 不适用的数据类型，则返回 Null。
NUM_PREC_RADIX int => 基数（通常为 10 或 2）
NULLABLE int => 是否允许使用 NULL。
columnNoNulls - 可能不允许使用NULL值
columnNullable - 明确允许使用NULL值
columnNullableUnknown - 不知道是否可使用 null
REMARKS String => 描述列的注释（可为null）
COLUMN_DEF String => 该列的默认值，当值在单引号内时应被解释为一个字符串（可为null）
SQL_DATA_TYPE int => 未使用
SQL_DATETIME_SUB int => 未使用
CHAR_OCTET_LENGTH int => 对于 char 类型，该长度是列中的最大字节数
ORDINAL_POSITION int => 表中的列的索引（从 1 开始）
IS_NULLABLE String => ISO 规则用于确定列是否包括 null。
YES --- 如果参数可以包括 NULL
NO --- 如果参数不可以包括 NULL
空字符串 --- 如果不知道参数是否可以包括 null
SCOPE_CATLOG String => 表的类别，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为null）
SCOPE_SCHEMA String => 表的模式，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为null）
SCOPE_TABLE String => 表名称，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为null）
SOURCE_DATA_TYPE short => 不同类型或用户生成 Ref 类型、来自 java.sql.Types 的 SQL 类型的源类型（如果 DATA_TYPE 不是 DISTINCT 或用户生成的 REF，则为null）
IS_AUTOINCREMENT String => 指示此列是否自动增加
YES --- 如果该列自动增加
NO --- 如果该列不自动增加
空字符串 --- 如果不能确定该列是否是自动增加参数   */
public class GenEntityMysql {

    private String packageOutPath = "cn.dz.daima.entity";//指定实体生成所在包的路径
    private String authorName = "tom";//作者名字
    private String tablename = "t_etms_bo";//表名,如果是生成单张表,这里要配置
    private ArrayList<String> colnames; // 列名数组
    private ArrayList<String> colTypes; //列名类型数组
    private ArrayList<String> notes; //注释名
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*

    //数据库连接
//    private static final String URL = "jdbc:mysql://118.31.246.224:3306/sfa_2.0";
//    private static final String NAME = "sa";
//    private static final String PASS = "123456";
    private static final String NAME = "root";
    private static final String PASS = "test_123456";
     private static final String URL = "jdbc:mysql://116.62.52.172:3306/etms_offtake_test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
//    private static final String NAME = "root";
//    private static final String PASS = "Dz124578";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    /*
     * 构造函数
     */
    public GenEntityMysql() {
        //创建连接
        Connection con;
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            con = DriverManager.getConnection(URL, NAME, PASS);
            //DatabaseMetaData(获取数据库信息)
            DatabaseMetaData dbmd = con.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
            colnames = new ArrayList<>();
            colTypes = new ArrayList<>();
            notes = new ArrayList<>();
            int x = 0;
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                //System.out.println("tableName = " + zhuan(tableName));//获取所有表名称
                //如果需要建多张表,在这里进行修改配置
                if (tableName.contains("t_etms_bo")) {
                    tablename = tableName;
                    /*String[] s = tableName.split("_");
                    if (s.length >= 4) {
                        tablename=s[s.length-2]+s[s.length-1];
                    } else {
                        tablename=s[s.length-1];
                    }*/
                    ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
                    while (rs.next()) {
                        colnames.add(rs.getString("COLUMN_NAME"));
                        colTypes.add(rs.getString("TYPE_NAME"));
                        notes.add(rs.getString("REMARKS"));
                        if (colTypes.get(x).equalsIgnoreCase("datetime")) {
                            f_util = true;
                        }
                        if (colTypes.get(x).equalsIgnoreCase("image") || colTypes.get(x).equalsIgnoreCase("text")) {
                            f_sql = true;
                        }
                        x++;
                    }
                    //写出文件
                    writeFile();
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void writeFile() {
        String content = parse(colnames, colTypes);
        try {
            File directory = new File("");
            //得到路径
            String path = this.getClass().getResource("").getPath();

            System.out.println(path);
            //如果是父子项目,directory.getAbsolutePath()只能获取到父项目的src目录,可以自己更具需求变动
            String outputPath = directory.getAbsolutePath() + "/soontemple-1/src/main/java/" + this.packageOutPath
                    .replace(".", "/") + "/" + initcap(tablename) + "Entity" + ".java";
            FileWriter fw = new FileWriter(outputPath);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(content);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能：生成实体类主体代码
     *
     * @param colnames
     * @param colTypes
     * @return
     */
    private String parse(ArrayList<String> colnames, ArrayList<String> colTypes) {
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
        sb.append("import lombok.Data;\r\n");
        //注释部分
        sb.append("   /**\r\n");
        sb.append("    * " + tablename + " 实体类\r\n");
        sb.append("    * " + new Date() + " " + this.authorName + "\r\n");
        sb.append("    */ \r\n");
        //Mybatis的注解,如果不需要注释即可
        sb.append("@TableName(\"" + tablename + "\")\n");
        //Lombok注解
        sb.append("@Data");
        //实体部分
        sb.append("\r\npublic class " + initcap(tablename) + "Entity{\r\n");
        processAllAttrs(sb);//属性
        //如果使用lombok,这里注释掉
//        processAllMethod(sb);//get set方法
        sb.append("}\r\n");
        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     *
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colnames.size(); i++) {
            if (StringUtils.isNotBlank(notes.get(i))) {
                sb.append(" \t" + "/**" + notes.get(i) + "*/" + "\r\n");
            } else {
                sb.append(" \t" + "/**" + colnames.get(i) + "*/" + "\r\n");
            }
            //Mybatis的注解,如果不需要注释即可
            sb.append(" \t" + "@TableField(\"" + colnames.get(i) + "\")\r\n");
            sb.append("\tprivate " + sqlType2JavaType(colTypes.get(i)) + " " + zhuan(colnames.get(i)) + ";\r\n");
        }

    }

    /**
     * 功能：生成所有方法,如果采用@Data,吧这个方法注释即可
     *
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < colnames.size(); i++) {
            sb.append("\tpublic void set" + initcap(zhuan(colnames.get(i))) + "(" + sqlType2JavaType(colTypes.get(i))
                    + " " +
                    zhuan(colnames.get(i)) + "){\r\n");
            sb.append("\tthis." + zhuan(colnames.get(i)) + "=" + zhuan(colnames.get(i)) + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes.get(i)) + " get" + initcap(zhuan(colnames.get(i))) + "" +
                    "(){\r\n");
            sb.append("\t\treturn " + zhuan(colnames.get(i)) + ";\r\n");
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
            return "Boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "Byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "Short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return "Integer";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "Long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "Float";
        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "Double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        } else if (sqlType.equalsIgnoreCase("double")) {
            return "Double";
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

        new GenEntityMysql();


    }

}

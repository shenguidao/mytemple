package cn.dz.daima.utils;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MyExcelUtil {
    public static void main(String[] args) {
        try {
            OutputStream output = null;
            File xlsFile = new File("C:\\Users\\Administrator\\Desktop\\合.xlsx");
            // 获得工作簿
            Workbook workbook = WorkbookFactory.create(xlsFile);
            // 获得工作表个数
            int sheetCount = workbook.getNumberOfSheets();
            // 遍历工作表
            for (int i = 0; i < sheetCount; i++)
            {
                Sheet sheet = workbook.getSheetAt(i);
                // 获得行数
                int rows = sheet.getLastRowNum() + 1;
                // 获得列数，先获得一行，在得到改行列数
                Row tmp = sheet.getRow(1);
                if (tmp == null)
                {
                    continue;
                }
                int cols = tmp.getPhysicalNumberOfCells();
                // 读取数据
                for (int row = 1; row < rows; row++)
                {
                    Row r = sheet.getRow(row);

                    for (int col = 0; col < cols; col++)
                    {
                        System.out.printf("%10s", r.getCell(col)+"  ");
                        if(row != 1 && col == cols - 1){
                            if(r.getCell(2).toString().equals(r.getCell(3).toString()) && r.getCell(2).toString().equals(r.getCell(4).toString())
                                    && r.getCell(2).toString().equals(r.getCell(5).toString())
                                    ){
                                System.out.println(1);
                                // Row row2 = sheet.createRow(row);
                                r.createCell(col+1).setCellValue(1); // 创建单元格
                            }else{
                                System.out.println(0);
                                //Row row2 = sheet.createRow(row);
                                r.createCell(col+1).setCellValue(0); // 创建单元格
                            }
                        }
                    }
                    System.out.println();
                }
            }
            // 写入流
            output = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
            workbook.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

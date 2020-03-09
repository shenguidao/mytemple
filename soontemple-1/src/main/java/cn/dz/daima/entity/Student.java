package cn.dz.daima.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

@Data
public class Student extends BaseRowModel {

    //@ExcelProperty(value = {"截止日期：","时间进度：","","大区","大区"},index = 0)
    private String region;

   // @ExcelProperty(value = {"=DATE(YEAR(NOW()),MONTH(NOW()),DAY(NOW()))","3%"," ","8月MTD（KRMB）","8月MTD（KRMB）"},index = 1)
    private String MTD;

   // @ExcelProperty(value = {"","","","8月MTD-IFFO（KRMB）","8月MTD-IFFO（KRMB）"},index = 2)
    private String mtdIFFO;

   // @ExcelProperty(value = {"","","","8月MTD-GUM（KRMB）","8月MTD-GUM（KRMB）"},index = 3)
    private String mtdGUM;

   // @ExcelProperty(value = {"","","","Daily Offtake GR%","Daily Offtake GR%"},index = 4)
    private String gr;



}

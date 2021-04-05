package com.ju.easyexcel_dome.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 基于lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@ColumnWidth(15)
@HeadRowHeight(25)
@ContentRowHeight(20)
public class Student {

    /**
     * id
     */
    @ExcelProperty(value = "ID",index = 0)
    @ExcelIgnore
    private String id;
    /**
     * 学生姓名
     */
    @ExcelProperty(value = "学生姓名",index = 1)
//    @ExcelProperty(value = {"学员信息表","学生姓名"})
    private String name;
    /**
     * 学生性别
     */
    @ExcelProperty(value = "学生性别",index = 2)
//    @ExcelProperty(value = {"学员信息表","学生性别"})
    private String gender;

    /**
     * 学生出生日期
     */
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(value = "学生出生日期",index = 3)
    private Date birthday;



}




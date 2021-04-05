package com.ju.easyexcel_dome;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.ju.easyexcel_dome.entity.Student;
import com.ju.easyexcel_dome.listener.StudentListener;
import org.junit.jupiter.api.Test;

public class EasyExcelReadTest {

    @Test
    public void test01(){

        /**
         * pathName   要读的文件路径
         * head     文件中每一行数据要存储到实体类型的class
         * readListener  每读一样，会调用该invoke方法一次
         */
        //获取一个工作簿对象
        ExcelReaderBuilder readWorkBook = EasyExcel.read("模拟在线202003班学员信息.xlsx", Student.class
                ,new StudentListener());
        //获取一个工作表对象
        ExcelReaderSheetBuilder sheet = readWorkBook.sheet();
        //指定从第三行读取
        sheet.headRowNumber(2);
        //相当于trim（）
        sheet.autoTrim(true);
        //按编号读取sheet
        sheet.sheetNo(0);
        //按名字读取sheet
        sheet.sheetName("one");

        //读取工作表中的内容
        sheet.doRead();
    }
}

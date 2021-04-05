package com.ju.easyexcel_dome;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.ju.easyexcel_dome.entity.Student;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyExcelWriteTest {

    @Test
    public void test02(){
        //获取一个工作簿对象
        ExcelWriterBuilder writeWork = EasyExcel.write("模拟在线202003班学员信息_write.xlsx",
                Student.class);
        //获取一个工作表对象
        ExcelWriterSheetBuilder sheet = writeWork.sheet();
        List<Student> students = initData();
        sheet.doWrite(students);

    }

    private static List<Student> initData(){
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Student student = new Student();
            student.setName("学生0"+i);
            student.setGender("男");
            student.setBirthday(new Date());
            studentList.add(student);
        }
        return studentList;
    }
}

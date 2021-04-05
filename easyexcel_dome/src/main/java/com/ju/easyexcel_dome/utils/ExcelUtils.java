package com.ju.easyexcel_dome.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.ju.easyexcel_dome.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class ExcelUtils {
    public static void writeExcel(String fileName , Class head,
                                  HttpServletResponse response, CopyOnWriteArrayList list) {
        try {
            ServletOutputStream outputStream = getOutputStream(fileName,response);
            ExcelWriterBuilder writeBook = EasyExcel.write(outputStream, head);
            ExcelWriterSheetBuilder sheet = writeBook.sheet(fileName);
            List<Student> studentList = initData();
            sheet.doWrite(studentList);
        } catch (Exception e) {
            log.error("导出excel表格失败:", e);
        }
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

    /**
     * 导出文件时为Writer生成OutputStream.
     *
     * @param fileName 文件名
     * @param response response
     * @return ""
     */
    private static ServletOutputStream getOutputStream(String fileName,
                                                       HttpServletResponse response) throws Exception {
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置响应的类型
            response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
            //设置响应的编码格式
            response.setCharacterEncoding("utf8");
            //设置响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (IOException e) {
            log.error("导出excel表格失败:", e);
            throw new Exception("导出excel表格失败!", e);
        }
    }

}

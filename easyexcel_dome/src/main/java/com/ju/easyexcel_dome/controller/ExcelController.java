package com.ju.easyexcel_dome.controller;


import com.alibaba.excel.util.StringUtils;
import com.ju.easyexcel_dome.entity.ResultResponse;
import com.ju.easyexcel_dome.entity.Student;
import com.ju.easyexcel_dome.listener.StudentListener;
import com.ju.easyexcel_dome.service.ExcelService;
import com.ju.easyexcel_dome.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/excel")
@Slf4j
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    private CopyOnWriteArrayList<Student> studentList;

    public CopyOnWriteArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(CopyOnWriteArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    //上传excel
    @RequestMapping("/upload")
    public ResultResponse excelUpload(MultipartFile file){
        ResultResponse response = checkParam(file);
        if (!(200 == response.getStatus())) {
            return response;
        }
        //调用service中的uploadExcel()获取excel中的数据
        List<Student> students = excelService.uploadExcel(file,Student.class,new StudentListener());
        //将得到的excel数据封装后进行返回
        return ResultResponse.success(students);
    }

    private ResultResponse checkParam(MultipartFile file) {
        if (null == file) {
            return ResultResponse.fail("上传的文件为空");
        }
        String filename = file.getOriginalFilename();
        if (StringUtils.isEmpty(filename)) {
            return ResultResponse.fail("文件格式异常");
        }
        if (!filename.contains(".xlsx") && !filename.contains(".XLSX") ) {
            return ResultResponse.fail("文件格式错误");
        }
        return ResultResponse.success();
    }

    //先从前端获取studentList
    @RequestMapping("/getStudent")
    public void getStudent(@RequestBody CopyOnWriteArrayList<Student> students)  {
        setStudentList(students);
    }

    //实现excel下载功能
    @RequestMapping("/download")
    public void downloadExcel(HttpServletResponse response) {
        try {
            ExcelUtils.writeExcel("学生信息" ,Student.class ,response,getStudentList());
        } catch (Exception e) {
            log.error("导出excel表格失败:", e);
        }
    }

}

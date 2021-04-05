package com.ju.easyexcel_dome.service;

import com.ju.easyexcel_dome.entity.Student;
import com.ju.easyexcel_dome.listener.StudentListener;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    List<Student> uploadExcel(MultipartFile file, Class head, StudentListener listener);
}

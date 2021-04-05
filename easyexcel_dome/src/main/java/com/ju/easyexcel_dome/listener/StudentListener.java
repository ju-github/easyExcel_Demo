package com.ju.easyexcel_dome.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ju.easyexcel_dome.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentListener extends AnalysisEventListener<Student> {

    // 每读一样，会调用该invoke方法一次

    /**
     *
     * @param student  每次读取分装的对象
     * @param analysisContext
     */
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println("student = " + student);
    }

    /**
     * 读取完整个文档调用的方法
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

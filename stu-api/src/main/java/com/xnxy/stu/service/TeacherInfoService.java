package com.xnxy.stu.service;

import com.xnxy.stu.bean.ResultEntity;
import com.xnxy.stu.bean.TeacherInfo;

public interface TeacherInfoService {
    ResultEntity<TeacherInfo> doLogin(TeacherInfo teacherInfo);


    ResultEntity<TeacherInfo> getTeaInfo(String teacherNum);

    ResultEntity<Integer> updateTeaInfo(TeacherInfo teacherInfo);

    ResultEntity<Integer> updatePasswd(String newPasswd,String teacherNum);
}

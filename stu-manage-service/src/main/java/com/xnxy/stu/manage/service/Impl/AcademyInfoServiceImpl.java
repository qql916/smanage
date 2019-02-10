package com.xnxy.stu.manage.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xnxy.stu.bean.AcademyInfo;
import com.xnxy.stu.manage.mapper.AcademyInfoMapper;
import com.xnxy.stu.service.AcademyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AcademyInfoServiceImpl implements AcademyInfoService {
    @Autowired
    AcademyInfoMapper academyInfoMapper;
    //查询学院名称
    @Override
    public String getAcademyName(String academyId) {
        AcademyInfo academyInfo = new AcademyInfo();
        academyInfo.setId(academyId);
        AcademyInfo info = academyInfoMapper.selectOne(academyInfo);
        String academyName = info.getAcademyName();
        return academyName;
    }
}

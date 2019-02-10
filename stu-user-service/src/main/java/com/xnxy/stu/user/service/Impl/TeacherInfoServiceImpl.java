package com.xnxy.stu.user.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xnxy.stu.bean.ResultEntity;
import com.xnxy.stu.bean.TeacherInfo;
import com.xnxy.stu.service.TeacherInfoService;
import com.xnxy.stu.user.mapper.TeacherInfoMapper;
import com.xnxy.stu.utils.ACConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    //用户登录验证
    @Override
    public ResultEntity<TeacherInfo> doLogin(TeacherInfo teacherInfo) {

        ResultEntity<TeacherInfo> resultEntity = new ResultEntity<>();
        TeacherInfo teacherInfo1 = teacherInfoMapper.selectOne(teacherInfo);
        if (teacherInfo1!=null){
            resultEntity.setData(teacherInfo1);
            resultEntity.setResult(ResultEntity.SUCCESS);
        }else{
            resultEntity.setMessage(ACConst.MESSAGE_LOGIN_FAILED);
            resultEntity.setResult(ResultEntity.FAILED);
        }
        return resultEntity;
    }

    //根据教师编号查询个人信息
    @Override
    public ResultEntity<TeacherInfo> getTeaInfo(String teacherNum) {
        ResultEntity<TeacherInfo> resultEntity = new ResultEntity<>();
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setTeacherNum(teacherNum);
        TeacherInfo info = teacherInfoMapper.selectOne(teacherInfo);
        if (info!=null){
            resultEntity.setData(info);
            resultEntity.setResult(ResultEntity.SUCCESS);
        }else{
            resultEntity.setMessage(ACConst.MESSAGE_ACCESS_FORBIDDEN);
            resultEntity.setResult(ResultEntity.FAILED);
        }
        return resultEntity;
    }

    //修改个人信息
    @Override
    public ResultEntity<Integer> updateTeaInfo(TeacherInfo teacherInfo) {

        Example example = new Example(TeacherInfo.class);
        example.createCriteria().andEqualTo("teacherNum",teacherInfo.getTeacherNum());
        int i = teacherInfoMapper.updateByExampleSelective(teacherInfo,example);
        ResultEntity<Integer> resultEntity = new ResultEntity<>();
        if (i>0){
            resultEntity.setResult(ResultEntity.SUCCESS);
            resultEntity.setData(i);
        }else{
            resultEntity.setMessage(ACConst.MESSAGE_SAVE_FAILED);
            resultEntity.setResult(ResultEntity.FAILED);
        }
        return resultEntity;
    }

    //修改密码
    @Override
    public ResultEntity<Integer> updatePasswd(String newPasswd,String teacherNum) {
        Example example = new Example(TeacherInfo.class);
        example.createCriteria().andEqualTo("teacherNum",teacherNum);
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setPasswd(newPasswd);
        int i = teacherInfoMapper.updateByExampleSelective(teacherInfo,example);
        ResultEntity<Integer> resultEntity = new ResultEntity<>();
        if (i>0){
            resultEntity.setResult(ResultEntity.SUCCESS);
            resultEntity.setData(i);
        }else{
            resultEntity.setMessage(ACConst.MESSAGE_SAVE_FAILED);
            resultEntity.setResult(ResultEntity.FAILED);
        }
        return resultEntity;
    }


}

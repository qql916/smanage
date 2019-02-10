package com.xnxy.stu.manage.controller.teacherController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xnxy.stu.annotations.LoginRequire;
import com.xnxy.stu.bean.ResultEntity;
import com.xnxy.stu.bean.TeacherInfo;
import com.xnxy.stu.service.AcademyInfoService;
import com.xnxy.stu.service.TeacherInfoService;
import com.xnxy.stu.util.CookieUtil;
import com.xnxy.stu.utils.ACConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class teacherController {

    @Reference
    TeacherInfoService teacherInfoService;
    @Reference
    AcademyInfoService academyInfoService;

    //获取教师个人信息
    @LoginRequire(isNeededSuccess = true)
    @RequestMapping("getTeaInfo")
    public String getInfo(String teacherNum, HttpServletRequest request, ModelMap modelMap){

            //通过教师编号查询教师信息
            ResultEntity<TeacherInfo> resultEntity = teacherInfoService.getTeaInfo(teacherNum);
            String result = resultEntity.getResult();
            if (result.equals(ACConst.SUCCESS)){
                TeacherInfo teacherInfo = resultEntity.getData();
                //在根据academyId查询学院名称
                String academyName = academyInfoService.getAcademyName(teacherInfo.getAcademyId());
                modelMap.put("teacherName",teacherInfo.getTeacherName());
                modelMap.put("teacherNum",teacherNum);
                modelMap.put("passwd",teacherInfo.getPasswd());
                modelMap.put("phoneNum",teacherInfo.getPhoneNum());
                modelMap.put("academyId",teacherInfo.getAcademyId());
                modelMap.put("academyName",academyName);
                modelMap.put("office",teacherInfo.getOffice());
                return "teacher/info";
            }else{
                String message = resultEntity.getMessage();
                modelMap.put(ACConst.MESSAGE_ATTR_NAME,message);
                return "redirect:http://passport.stu.com:8086/login";
            }

    }
    //更新教师个人信息
    @LoginRequire(isNeededSuccess = true)
    @ResponseBody
    @RequestMapping("updateTeaInfo")
    public String saveInfo(TeacherInfo teacherInfo,HttpServletRequest request,ModelMap map){
            //保存用户信息
            ResultEntity<Integer> resultEntity = teacherInfoService.updateTeaInfo(teacherInfo);
           //保存成功
            if (resultEntity.getResult().equals(ACConst.SUCCESS)) {
                return ACConst.SUCCESS;
            }else{
//                map.put(ACConst.MESSAGE,resultEntity.getMessage());
                return ACConst.FAILED;
            }

    }
    @LoginRequire(isNeededSuccess = true)
    @RequestMapping("checkOriginPwdPage")
    public String checkOriginPwd(HttpServletRequest request){
      //原始密码输入页面
        return "teacher/changePwd";

    }

    @LoginRequire(isNeededSuccess = true)
    @RequestMapping("checkPwd")
    @ResponseBody
    public String checkPwd(String passwd,HttpServletRequest request){
        String oldPasswd = (String) request.getAttribute("passwd");
        //先判断passwd是否为空，为空返回failed，不为空进行验证

            //如果相等，验证成功
            if (oldPasswd.equals(passwd)){
                return ACConst.SUCCESS;
            }else {
                //如果不相等，验证失败
                return ACConst.FAILED;
            }

    }
    @LoginRequire(isNeededSuccess = true)
    @RequestMapping("updatePasswd")
    @ResponseBody
    public String updatePwd(String newPasswd,HttpServletRequest request){
        String oldPasswd = (String) request.getAttribute("passwd");
        String teacherNum = (String) request.getAttribute("teacherNum");
        //先判断两个密码是否不同，不同则保存，相同则不保存
        if (newPasswd.equals(oldPasswd)){
            return ACConst.FAILED;
        }else {
            ResultEntity<Integer> resultEntity = teacherInfoService.updatePasswd(newPasswd,teacherNum);
            if (resultEntity.getResult().equals(ACConst.SUCCESS)){
                return ACConst.SUCCESS;
            }else {
                return ACConst.FAILED;
            }
        }
    }

}

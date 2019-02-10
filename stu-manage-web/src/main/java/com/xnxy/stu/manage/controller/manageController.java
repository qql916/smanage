package com.xnxy.stu.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xnxy.stu.annotations.LoginRequire;
import com.xnxy.stu.bean.AcademyInfo;
import com.xnxy.stu.bean.ResultEntity;
import com.xnxy.stu.bean.TeacherInfo;
import com.xnxy.stu.service.AcademyInfoService;
import com.xnxy.stu.service.TeacherInfoService;
import com.xnxy.stu.util.CookieUtil;
import com.xnxy.stu.util.JwtUtil;
import com.xnxy.stu.utils.ACConst;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class manageController {

    @Reference
    TeacherInfoService teacherInfoService;
    @Reference
    AcademyInfoService academyInfoService;

    @LoginRequire(isNeededSuccess = true)//一定要登录
    @RequestMapping("toMainPage")
    public String toMainPage(HttpServletRequest request,ModelMap modelMap) {
        //获取用户数据
       /* String cookieValue = CookieUtil.getCookieValue(request, "userMg", true);
        if (StringUtils.isNotBlank(cookieValue)) {
            String header = request.getHeader("x-forwarded-for");
            String ip = header;
            if (StringUtils.isBlank(ip)) {
                ip = request.getRemoteAddr();
                if (StringUtils.isBlank(ip)) {
                    ip = "127.0.0.1";
                }
            }
            Map map = JwtUtil.decode("userMg", cookieValue, ip);
            String teacherName = (String) map.get("teacherName");
            String teacherNum = (String) map.get("teacherNum");
            modelMap.put("teacherName", teacherName);
            modelMap.put("teacherNum", teacherNum);
            modelMap.put("userType","teacher");//用来判断用户类型
            return "main";
        }else{
            return "redirect:http://passport.stu.com:8086/login";

        }*/
        String teacherNum = (String)request.getAttribute("teacherNum");
        String teacherName = (String)request.getAttribute("teacherName");
            modelMap.put("teacherName", teacherName);
            modelMap.put("teacherNum", teacherNum);
            modelMap.put("userType","teacher");//用来判断用户类型
            return "main";


    }





}

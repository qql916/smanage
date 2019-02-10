package com.xnxy.stu.passport.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xnxy.stu.bean.ResultEntity;
import com.xnxy.stu.bean.TeacherInfo;
import com.xnxy.stu.service.TeacherInfoService;
import com.xnxy.stu.util.CookieUtil;
import com.xnxy.stu.util.JwtUtil;
import com.xnxy.stu.utils.ACConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class passPortController {

    @Reference
    TeacherInfoService teacherInfoService;

    @RequestMapping("login")
    public String index(String returnUrl, ModelMap modelMap) {
        modelMap.addAttribute("returnUrl", returnUrl);
        return "login";
    }
    //认证入口
    @ResponseBody
    @RequestMapping("verify")
    public String verify(HttpServletRequest request,String currentIp,String token){
        //解密
        Map map = JwtUtil.decode(ACConst.SIGN_KEY, token, currentIp);
        if (map!=null){
            return "success";
        }else{
            return "fail";
        }

    }
    //教師登陸
//    @ResponseBody
//    @RequestMapping("TdoLogin")
//    public String teaDoLogin(TeacherInfo teacherInfo, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
//        //用戶密碼验证
//        String cookie = CookieUtil.getCookieValue(request, "userMg", true);
//        ResultEntity<TeacherInfo> resultEntity = teacherInfoService.doLogin(teacherInfo);
//        String result = resultEntity.getResult();
//        //如果数据库匹配成功就将用户存到cookie中
//        if (result.equals(ResultEntity.SUCCESS)) {
//            TeacherInfo teacherInfo1 = resultEntity.getData();
//            //先将数据jwt加盐保密
//            Map<String, String> map = new HashMap<>();
//
//            String ip = request.getHeader("x-forwarded-for");
//            if (StringUtils.isBlank(ip)) {
//                ip = request.getRemoteAddr();
//                if (StringUtils.isBlank(ip)) {
//                    ip = "127.0.0.1";
//                }
//            }
//            map.put("teacherName", teacherInfo1.getTeacherName());
//            map.put("teacherNum", teacherInfo1.getTeacherNum());
//            map.put("passwd", teacherInfo1.getPasswd());
//            String userMg = JwtUtil.encode("userMg", map, ip);
//            //如果cookie不为空再存放到cookie中
//            if (StringUtils.isBlank(cookie)){
//
//                CookieUtil.setCookie(request, response,"userMg", userMg, 60 * 60 *60 , true);
//            }
//            return ACConst.SUCCESS;
//
//        }
//
//        //如果账号密码不成确就回到登录页面并显示错误信息
//        if (result.equals(ResultEntity.SUCCESS)) {
//            String message = resultEntity.getMessage();
//
//            modelMap.put(ACConst.MESSAGE_ATTR_NAME, message);
//
//            return ACConst.FAILED;
//        }
//
//        return ACConst.FAILED;
//    }
    @RequestMapping("TdoLogin")
    @ResponseBody
    public String teaDoLogin(TeacherInfo teacherInfo, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        //根据收集到的用户信息在数据库查询用户id
        ResultEntity<TeacherInfo> resultEntity = teacherInfoService.doLogin(teacherInfo);
        String result = resultEntity.getResult();
        //如果有id就生成token
        if (result.equals(ResultEntity.SUCCESS)){
            TeacherInfo teacherInfo1 = resultEntity.getData();
//            //先将数据jwt加盐保密
            Map<String, String> map = new HashMap<>();

            String ip = request.getHeader("x-forwarded-for");
            if (StringUtils.isBlank(ip)) {
                ip = request.getRemoteAddr();
                if (StringUtils.isBlank(ip)) {
                    ip = "127.0.0.1";
                }
            }
            map.put("teacherName", teacherInfo1.getTeacherName());
            map.put("teacherNum", teacherInfo1.getTeacherNum());
            map.put("passwd", teacherInfo1.getPasswd());
            String token = JwtUtil.encode(ACConst.SIGN_KEY, map, ip);
            return token;
        }
        //没有id返回null
        return "fail" ;
    }
}

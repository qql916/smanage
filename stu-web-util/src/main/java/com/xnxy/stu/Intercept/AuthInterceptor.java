package com.xnxy.stu.Intercept;


import com.xnxy.stu.annotations.LoginRequire;
import com.xnxy.stu.util.CookieUtil;
import com.xnxy.stu.util.HttpClientUtil;
import com.xnxy.stu.util.JwtUtil;
import com.xnxy.stu.util.webAcconstUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断当前请求方法的拦截类型
        HandlerMethod hm =(HandlerMethod) handler;
        LoginRequire methodAnnotation = hm.getMethodAnnotation(LoginRequire.class);
        //不需要验证
        if (methodAnnotation==null){
            return true;
        }

        //是否必须通过验证
        boolean neededSuccess = methodAnnotation.isNeededSuccess();
        //获取用户的token
        String token = "";
        String oldToken = CookieUtil.getCookieValue(request,"userToken",true);
        String newToken = request.getParameter("newToken");
        if (StringUtils.isNotBlank(oldToken)){
            token = oldToken;
        }
        if (StringUtils.isNotBlank(newToken)){
            token = newToken;
        }
        //如果token不为空，验证token，http的工具
        if(StringUtils.isNotBlank(token)){
            //获取盐值：ip
            // 通过负载均衡nginx
            String ip = request.getHeader("x-forwarded-for");
            if(StringUtils.isBlank(ip)){
                ip = request.getRemoteAddr();
                if(StringUtils.isBlank(ip)){
                    ip = "127.0.0.1";
                }
            }
            String doGet = HttpClientUtil.doGet(webAcconstUtil.VERIFY_URL + "?token=" + token + "&currentIp=" + ip);
            if (doGet.equals("success")){
                //验证成功,刷新用户token
                CookieUtil.setCookie(request,response,webAcconstUtil.USER_TOKEN,token,webAcconstUtil.cookieMaxAge,true);
                Map map = JwtUtil.decode(webAcconstUtil.SIGN_KEY, token, ip);
                //将token中的用户数据放入request域中
                request.setAttribute("teacherName",map.get("teacherName"));
                request.setAttribute("teacherNum", map.get("teacherNum"));
                request.setAttribute("passwd",map.get("passwd"));
//                放行
                return true;

            }

        }
        //如果neededSuccess为true和token为空，或验证不通过则返回登录页面
        if (neededSuccess==true){
            String returnUrl = request.getRequestURL().toString();//原始请求的地址
            //LOGIN_URL="http://passport.stu.com:8086/login";
            response.sendRedirect(webAcconstUtil.LOGIN_URL+"?returnUrl="+returnUrl);
            return false;
        }
        //如果token为空且无需登录
        return true;
    }
}

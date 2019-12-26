package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method= RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {
        //HttpServLetRequest  装请求信息
        //HttpServLetResponse   装响应信息
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获取cookies成功";
    }
    /*
    * 要求客户端携带cookies访问
    * */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookie(HttpServletRequest request){

        Cookie[] cookies=request.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for(Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "恭喜你访问成功";
            }
        }

        return "你必须携带cookies信息来";
    }
}
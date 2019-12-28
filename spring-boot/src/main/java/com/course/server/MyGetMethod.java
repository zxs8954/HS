package com.course.server;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {
        //HttpServLetRequest  装请求信息
        //HttpServLetResponse   装响应信息
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获取cookies成功";
    }

    /*
     * 要求客户端携带cookies访问
     * */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getWithCookie(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "恭喜你访问成功";
            }
        }

        return "你必须携带cookies信息来";
    }

    /*
     * 开发一个需要携带参数才能访问的get请求
     * 第一种url: key=value
     *
     * */
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end) {
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 400);
        myList.put("干脆面", 1);
        myList.put("衬衫", 300);

        return myList;
    }

    /*
     * 第二种爱需要携带参数访问的get请求
     * url:ip:port/get/with/param/10/20
     * */
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end) {
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 4001);
        myList.put("干脆面", 1);
        myList.put("衬衫", 300);
        return myList;
    }

}

package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class GetDemo {
    @RequestMapping(value = "/getCookie", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "cookieIs");
        response.addCookie(cookie);
        return "获取cookie";
    }

    @RequestMapping(value = "/get/with/cookie", method = RequestMethod.GET)

    public String getWithCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你没有携带cookie";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name") && cookie.getValue().equals("cookieIs")) {
                return "OK!!!!!!!!!!";
            }
        }
        return "一定要带cookie";
    }
}

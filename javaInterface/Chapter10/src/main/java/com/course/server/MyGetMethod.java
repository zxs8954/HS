package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是全部get方法")
/**
 * get 请求，给客户端返回cookies信息的接口
 */
public class MyGetMethod {
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)
    @ApiOperation(value="通过这个方法可以获取cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest
        //HttpServletResponse
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "获取cookies信息成功";
    }
    /**
     * get请求，要求客户端携带cookies访问的接口
     */
    @RequestMapping(value="/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value="get请求，要求客户端携带cookies访问的接口",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();//获取cookies
        if(Objects.isNull(cookies)){
            return "访问失败，必须携带cookies";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "请求成功，已携带cookies";
            }
        }
        return "访问失败，携带cookies，单没有指定的login=true";
    }
    /**
     * get请求，必须携带参数
     * 实现方式1：url:port/get/with/param?key=value&key=value
     * 模拟获取商品列表
     */
    @RequestMapping(value = "get/with/param",method =RequestMethod.GET)
    @ApiOperation(value="get请求，必须携带参数实现方式1",httpMethod = "GET")
    public Map<String,Integer> getList1(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("shop1",100);
        myList.put("shop2",200);
        myList.put("shop3",300);
        return  myList;
    }
    /**
     * get请求，必须携带参数
     * 实现方式2：url:port/get/with/param/start/end
     * 模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value="get请求，必须携带参数实现方式2",httpMethod = "GET")
    public Map getList2(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("shop4",400);
        myList.put("shop5",500);
        myList.put("shop6",600);
        return  myList;
    }

}

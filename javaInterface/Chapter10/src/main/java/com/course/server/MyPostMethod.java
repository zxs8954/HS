package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "all My Post")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;//存储cookies信息

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登录成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "password",required = true) String password){
        if(userName.equals("zhangsan")&&password.equals("123456")){
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "login success!!";
        }
        return "login failed!!";
    }
    /**
     *
     */
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user;
        Cookie[] cookies=request.getCookies();//获取cookies
        //验证cookies是否合法
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("login")
            &&cookie.getValue().equals("true")
            &&u.getUserName().equals("zhangsan")
            &&u.getPassword().equals("123456")){
                user=new User();
                user.setName("zhangSanSan");
                user.setAge("18");
                user.setSex("male");
                return user.toString();
            }
        }
        return "参数不合法，请先登录（zhangsan，123456）";

    }
}

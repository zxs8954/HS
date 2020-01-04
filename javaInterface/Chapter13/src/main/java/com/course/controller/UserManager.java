package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j2
@RestController
@Api(value = "v1",description = "用户管理系统")//该注解是swagger里面的
@RequestMapping("v1")
public class UserManager {
    @Autowired
    private SqlSessionTemplate template;//获取一个执行sql语句的对象

    /*
    登录接口
     */
    @ApiOperation(value = "登陆接口",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private Boolean login(HttpServletResponse response, @RequestBody User user){
        int i=template.selectOne("login",user);
        Cookie cookie=new Cookie("login","true");

        log.info("查询到的结果是："+i);
        if(i==1){
            response.addCookie(cookie);
            log.info("登录用户是："+user.getUserName());
            return true;
        }
        return false;
    }

    /*
    添加用户接口
     */
    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletResponse response,
                           HttpServletRequest request,
                           @RequestBody User user){
        boolean x=verifyCookies(request);
        int result=0;
        if(x){
            result = template.insert("addUser",user);
        }
        if(result > 0){
            log.info("添加用户数量是："+result);
            return true;
        }
        return false;
    }

    /*
   获取用户（或用户列表）接口
    */
    @ApiOperation(value = "获取用户（或用户列表）接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
        boolean x=verifyCookies(request);
        if (x){
            List<User> users=template.selectList("getUserInfo",user);
            log.info("获取到的用户数量是"+users.size());
            return users;
        }else{
            return  null;
        }
    }
    /*
    更新、删除用户接口
     */
    @ApiOperation(value = "更新、删除用户接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request,@RequestBody User user){
        boolean x=verifyCookies(request);
        int i=0;
        if(x){
            i=template.update("updateUserInfo",user);
        }
        log.info("更新数据的条目数为："+i);
        return i;

    }

    //验证cookie是否通过的方法
    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        if(cookies.equals(null)){
            log.info("cookie为空");
            return false;
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&
            cookie.getValue().equals("true")){
                log.info("cookies验证通过");
                return true;
            }
        }
        log.info("cookies验证通过");
        return  false;
    }

}

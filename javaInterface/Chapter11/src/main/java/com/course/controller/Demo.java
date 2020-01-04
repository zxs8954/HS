package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@Api(value = "v1",description = "第一个版本的demo")
@RequestMapping("v1")
public class Demo {
    @Autowired
    private SqlSessionTemplate template;//获取一个执行sql语句的对象

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数")
    public int getUserCount(){
        return  template.selectOne("getUserCount");
    }
    //给user表新增记录
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        int result =template.insert("addUser",user);
        return result;
    }
    //更新user表
    @RequestMapping(value ="/updataUser" ,method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        return template.update("updataUser",user);
    }
    //删除user表中的记录
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public int deleteUser(@RequestParam int id){
        return  template.delete("deleteUser",id);
    }
}

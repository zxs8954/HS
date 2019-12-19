package com.course.testng.groups;
import org.testng.annotations.*;
public class GroupOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端方法1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端方法2");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端方法1");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端方法2");
    }
    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.println("这服务端运行之前的方法");
    }
    @AfterGroups("server")
    public void afterGroupOnServer(){
        System.out.println("这是服务端运行之后的方法");
    }
//    @BeforeGroups("client")
//    public void beforeGroupOnClient(){
//        System.out.println("这是客户端运行之前运行的方法");
//    }
//    @AfterGroups("client")
//    public void afterGroupsOnClient(){
//        System.out.println("这是客户端运行之后运行的方法");
//    }
}

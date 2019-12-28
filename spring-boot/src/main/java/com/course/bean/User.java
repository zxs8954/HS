package com.course.bean;

import lombok.Data;

@Data   //在pom文件中引用lombok,有get,set,toString等方法
public class User {
    private String userName;
    private String passWord;
    private String name;
    private String age;
    private String sex;
}

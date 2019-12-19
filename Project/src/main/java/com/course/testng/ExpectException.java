package com.course.testng;

import org.testng.annotations.Test;

public class ExpectException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){
        System.out.println("这是一个失败测试");
        throw new RuntimeException();
    }
}

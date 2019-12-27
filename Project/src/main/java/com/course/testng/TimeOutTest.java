package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000) //单位是毫秒值
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 3000) //单位是毫秒值,超时测试
    public void testFail() throws InterruptedException {
        Thread.sleep(4000);
    }
}

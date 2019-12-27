package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1() {
        System.out.println("忽略方法1执行");
    }

    @Test(enabled = false)
    public void ignore2() {
        System.out.println("忽略方法2执行");

    }
}

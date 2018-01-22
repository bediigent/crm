package com.huawei.runnable;

import com.huawei.bean.Resource;

public class ResourceTest {

    public static void main(String[] args) {
        boolean flag = true;
        Resource resource = new Resource();
        new Thread(new OutputData(flag,resource)).start();
        new Thread(new InputData(flag,resource)).start();

    }

}

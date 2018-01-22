package com.huawei.runnable;

import com.huawei.bean.Resource;

public class InputData implements Runnable{

    private Resource resource;
    private boolean flag;


    public InputData(boolean flag,Resource resource){
        this.flag = flag;
        this.resource = resource;
    }

    @Override
    public void run() {
        int count = 1;
        while(true){
            //System.out.println(Thread.currentThread().getName()+"  "+number);
            if(flag){
                if(count%2 == 0){
                    resource.setName("Mary");
                    resource.setSex("Girl");
                }else{
                    resource.setName("张三");
                    resource.setSex("男");
                }
                count++;
            }
        }
    }

}

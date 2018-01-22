package com.huawei.runnable;
import com.huawei.bean.Resource;

public class OutputData implements Runnable {

    private Resource resource;
    private boolean flag;

    public OutputData(boolean flag,Resource resource){
        this.flag = flag;
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true){
            if(!flag){
                System.out.println(resource);
                flag = !flag;
            }
        }
    }

}

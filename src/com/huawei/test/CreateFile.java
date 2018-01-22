package com.huawei.test;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreateFile implements Runnable {

    private int number = 1;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock();

            if(number >= 1000){
                break;
            }else if(number > 500){

                try {
                    String fileName = "student"+number+".txt";
                    File file = new File("D://Test/",fileName);
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write("ID:2323233233");
                    bw.newLine();
                    bw.write("Name:小丽");
                    bw.newLine();
                    bw.write("Sex:女");
                    bw.newLine();
                    bw.write("Birthday:1866年11月19日");
                    bw.newLine();
                    bw.flush();
                    bw.close();
                    number++;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                try {
                    String fileName = "student"+number+".txt";
                    File file = new File("D://Test/",fileName);
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write("ID:5858585858");
                    bw.newLine();
                    bw.write("Name:张三");
                    bw.newLine();
                    bw.write("Sex:男");
                    bw.newLine();
                    bw.write("Birthday:1866年11月19日");
                    bw.newLine();
                    bw.flush();
                    bw.close();
                    number++;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            lock.unlock();
        }
    }



}

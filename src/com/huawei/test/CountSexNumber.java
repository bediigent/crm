package com.huawei.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSexNumber implements Runnable{

    private File file = new File("D://Test/student1.txt");
    private Object object = new Object();
    private BufferedReader bw;
    private Map<String,Integer> map;

    public CountSexNumber(Map<String,Integer> map){
        this.map = map;
    }

    @Override
    public void run() {
        synchronized (object){

            try {
                while(file.exists()){
                    bw = new BufferedReader(new FileReader(file));
                    String len = null;
                    int row = 1;
                    while((len=bw.readLine()) != null){

                        if(row == 3){
                            String[] split = len.split(":");
                            if(split[1].equals("男")){
                                map.put("男",map.get("男")+1);
                            }else if(split[1].equals("女")){
                                map.put("女",map.get("女")+1);
                            }
                            break;
                        }
                        row++;

                    }
                    String fileName = file.getName();
                    Pattern p = Pattern.compile("[0-9]+");
                    Matcher matcher = p.matcher(fileName);
                    Integer intt = 1;
                    while(matcher.find()){
                        String str = matcher.group();
                        intt = Integer.parseInt(str)+1;
                    }
                    System.out.println(Thread.currentThread().getName() + "  在读取文件:  " + file.getName());
                    file = new File("D://Test/student" + intt + ".txt");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}

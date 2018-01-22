package com.huawei.test;

import java.util.HashMap;
import java.util.Map;

public class CountPersonNumber {

//    @Test
//    public void test_count() throws IOException {
//        File file = new File("D://Test/student1.txt");
//        Map<String,Integer> map = new HashMap<String,Integer>();
//        map.put("男",0);
//        map.put("女",0);
//
//        while(file.exists()){
//            BufferedReader bw = new BufferedReader(new FileReader(file));
//            String len = null;
//            int row = 1;
//            while((len=bw.readLine()) != null){
//
//                if(row == 3){
//                    String[] split = len.split(":");
//                    if(split[1].equals("男")){
//                        map.put("男",map.get("男")+1);
//                    }else if(split[1].equals("女")){
//                        map.put("女",map.get("女")+1);
//                    }
//                    break;
//                }
//                row++;
//
//            }
//            String fileName = file.getName();
//            Pattern p = Pattern.compile("[0-9]+");
//            Matcher matcher = p.matcher(fileName);
//            Integer intt = 1;
//            while(matcher.find()){
//                String str = matcher.group();
//                intt = Integer.parseInt(str)+1;
//            }
//            file = new File("D://Test/student" + intt + ".txt");
//        }
//
//        //输出结果..
//        System.out.println("男生总人数为:  "+map.get("男"));
//        System.out.println("女生总人数为:  "+map.get("女"));
//
//    }



    public static void main(String[] args) throws InterruptedException {
        //使用多线程准备多个文件作为数据...
//        CreateFile createFile = new CreateFile();
//
//        for(int i=0; i<3; i++) {
//            new Thread(createFile).start();
//        }
//        System.out.println("创建500个文件完毕....");

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("男",0);
        map.put("女",0);
        CountSexNumber countSexNumber = new CountSexNumber(map);
        for (int i = 0; i < 5 ; i++) {
            new Thread(countSexNumber).start();
        }
        Thread.sleep(300);
        //输出结果..
        System.out.println("==================男生总人数为:  "+map.get("男"));
        System.out.println("==================女生总人数为:  "+map.get("女"));

    }

}

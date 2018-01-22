package com.huawei.testoracle;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestOracle {

    @Test
    public void test01() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.9.9:1521:orcl";
        String userName = "scott";
        String password = "tiger";

        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println(connection.getClass().getName());
        connection.close();
    }

    @Test
    public void test02() throws Exception{
        Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.9.9:1521:orcl";
        String userName = "scott";
        String password = "tiger";

        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println(connection.getClass().getName());

        String sql = "{call prod_cursor(?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
        callableStatement.execute();
        ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
        while (resultSet.next()){
            Object empno = resultSet.getObject("empno");
            Object ename = resultSet.getObject("ename");
            Object sal = resultSet.getObject("sal");
            Object deptno = resultSet.getObject("deptno");
            System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + deptno);
        }
        resultSet.close();
        callableStatement.close();
        connection.close();
    }
    @Test
    public void test03() throws Exception{
        //prod_getyearsal//jdbc:oracle:thin:@192.168.9.9:1521:orcl
        Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.9.9:1521:orcl";
        String userName = "scott";
        String password = "tiger";
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql = "{call prod_getyearsal(?,?)}";
        CallableStatement call = conn.prepareCall(sql);
        call.setObject(1,7839);
        call.registerOutParameter(2,OracleTypes.DOUBLE);
        call.execute();
        Double dd = call.getDouble(2);
        System.out.println(dd);

        call.close();
        conn.close();
    }

    @Test
    public void testCreateOneFile(){
        try {
            String fileName = "student"+1+".txt";
            File file = new File("D://Test/",fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("ID:23232323");
            bw.newLine();
            bw.write("Name:张三");
            bw.newLine();
            bw.write("Sex:男");
            bw.newLine();
            bw.write("Birthday:1866年11月19日");
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

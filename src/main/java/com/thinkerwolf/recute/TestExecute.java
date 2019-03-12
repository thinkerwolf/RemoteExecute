package com.thinkerwolf.recute;


import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 运行测试
 */
public class TestExecute {

    public static void main(String[] args) throws Exception{
        InputStream is = new FileInputStream("C:\\app\\TestClass.class");
        byte[] bs = new byte[is.available()];
        is.read(bs);
        JavaExexutor.exexute(bs);
    }
}

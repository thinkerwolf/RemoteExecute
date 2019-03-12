package com.thinkerwolf.recute;

import org.junit.Test;

import java.util.Arrays;

public class ByteUtilsTest {

    @Test
    public void bytesIntTest() {
        byte[] bs = new byte[4];
        bs[0] = 0x00;
        bs[1] = 0x14;
        System.err.println(ByteUtils.bytes2Int(bs, 0, 2));
        System.err.println(Arrays.toString(ByteUtils.int2Bytes(20, 2)));
    }

    @Test
    public void bytesStringTest() {
         //  6E 61 6D 65 name
        byte[] bs = new byte[4];
        bs[0] = 0x6E;
        bs[1] = 0x61;
        bs[2] = 0x6D;
        bs[3] = 0x65;
        System.err.println(ByteUtils.bytes2String(bs, 0, 4));
    }

    @Test
    public void repacesBytesTest() {
        //  6E 61 6D 65 name
        byte[] bs = new byte[4];
        bs[0] = 20;
        bs[1] = 21; // 21
        bs[2] = 22; // 22
        bs[3] = 23;

        byte[] newBs = ByteUtils.replaceBytes(bs, 0, 2, new byte[]{31});

        System.err.println(Arrays.toString(newBs));
    }



}

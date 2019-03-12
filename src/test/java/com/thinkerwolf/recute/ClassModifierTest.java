package com.thinkerwolf.recute;

import org.junit.Test;

import java.util.Arrays;

public class ClassModifierTest {

    @Test
    public void modifyUtf8Test() {
        String name = "com/java/String";
        int length = name.length();
        byte[] nameBytes = name.getBytes();
        byte[] bs = new byte[2 + nameBytes.length];
        System.arraycopy(ByteUtils.int2Bytes(length, 2), 0, bs, 0, 2);
        System.arraycopy(nameBytes, 0, bs, 2, nameBytes.length);

        System.err.println(Arrays.toString(ByteUtils.int2Bytes(length, 2)));
        System.err.println(Arrays.toString(nameBytes));
        System.err.println(Arrays.toString(bs));
    }


}

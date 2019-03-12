package com.thinkerwolf.recute;

public class ByteUtils {


    /**
     * 字节码转int
     * @param bs
     * @param offset
     * @param len
     * @return
     */
    public static int bytes2Int(byte[] bs, int offset, int len) {
        int sum = 0;
        int end = offset + len;
        for (int i = offset; i < end; i++) {
            int n = ((int) bs[i]) & 0xff;
            n <<= (--len) * 8;
            sum += n;
        }
        return sum;
    }

    /**
     * 字节码转String
     * @param bs
     * @param offset
     * @param len
     * @return
     */
    public static String bytes2String(byte[] bs, int offset, int len) {
        return new String(bs, offset, len);
    }

    /**
     * String转byte[]
     * @param s
     * @return
     */
    public static byte[] string2Bytes(String s) {
        return s.getBytes();
    }

    /**
     *
     * @param value
     * @param len
     * @return
     */
    public static byte[] int2Bytes(int value, int len) {
        byte[] bs = new byte[len];
        for (int i = 0; i < len; i++) {
            bs[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return bs;
    }

    /**
     * 替换字节
     * @param originalBytes 原始字节
     * @param offset 被替换字节偏移
     * @param len 被替换字节长度
     * @param replaceBytes 替换字节数组
     */
    public static byte[] replaceBytes(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        if (replaceBytes.length == len) {
            System.arraycopy(replaceBytes, 0, originalBytes, offset, replaceBytes.length);
            return originalBytes;
        } else {
            byte[] newBs = new byte[originalBytes.length + replaceBytes.length - len];
            System.arraycopy(originalBytes, 0, newBs, 0, offset);
            System.arraycopy(replaceBytes, 0, newBs, offset, replaceBytes.length);
            System.arraycopy(originalBytes, offset + len, newBs, offset + replaceBytes.length, originalBytes.length - offset - len);
            return newBs;
        }
    }
}

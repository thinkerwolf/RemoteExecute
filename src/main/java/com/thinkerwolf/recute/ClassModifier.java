package com.thinkerwolf.recute;

public class ClassModifier {

    /** 常量池大小index  */
    public static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /** UTF8 tag标示*/
    public static final int CONSTANT_utf8_info = 1;

    /** 常量池项目的大小， utf-8除外，因为不定长 */
    public static final int[] CONSTANT_ITEM_LENGTH = new int[] {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    public static final int u1 = 1;
    public static final int u2 = 2;

    private byte[] classBytes;

    public ClassModifier(byte[] classBytes) {
        this.classBytes = classBytes;
    }

    /**
     * 修改常量池UTF8内容
     * @param oldStr
     * @param newStr
     */
    public byte[] modifyUTF8Info(String oldStr, String newStr) {
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.bytes2Int(classBytes, offset, u1);
            if (tag == CONSTANT_utf8_info) {
                int length = ByteUtils.bytes2Int(classBytes, offset + u1, u2);
                String utf8 = ByteUtils.bytes2String(classBytes, offset + u1 + u2, length);
                if (utf8.equalsIgnoreCase(oldStr)) {
                    byte[] newStrBytes = ByteUtils.string2Bytes(newStr);
                    byte[] newSteLen = ByteUtils.int2Bytes(newStrBytes.length, u2);
                    // Replace constant_utf8 length
                    classBytes = ByteUtils.replaceBytes(classBytes, offset + u1, u2, newSteLen);
                    // Replace constant_utf8 content
                    classBytes = ByteUtils.replaceBytes(classBytes, offset + u1 + u2, length, newStrBytes);
                    return classBytes;
                } else {
                    offset = offset + u1 + u2 + length;
                }
            } else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classBytes;
    }


    public int getConstantPoolCount() {
       return ByteUtils.bytes2Int(classBytes, CONSTANT_POOL_COUNT_INDEX, 2);
    }


}

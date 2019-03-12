package com.thinkerwolf.recute;

import java.lang.reflect.Method;

public class JavaExexutor {

    public static String exexute(byte[] classByte) {
        HotSwapClassLoader hsCl = new HotSwapClassLoader();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] newClassByte = cm.modifyUTF8Info("com/thinkerwolf/recute/Print", "com/thinkerwolf/recute/HackPrint");
        Class<?> clazz = hsCl.loadByte(newClassByte);
        try {
           Method method = clazz.getMethod("main", String[].class);

           method.invoke(null, new String[]{ null });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

package com.glyk.heos.testPackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String args[]) {
        System.out.println("0");
        藻类 o=new 藻类();
        try {
            Class[] parameterTypes = new Class[1];
            String setter="set澡";
            Field field = o.getClass().getDeclaredField("澡");
            parameterTypes[0] = field.getType();
            Method method =o.getClass().getMethod(setter,parameterTypes);
            method.invoke(o,new Object[]{"sdsddsdsds"});
            System.out.println(o.get澡());
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }
    }
}

package com.glyk.heos.util;

import com.glyk.heos.dal.dao.StaDao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EntityUtil {
    public static String[] getClassColmun(String className){
        Field [] fields = null;
        String [] strings = null;
        try {
            Class c = Class.forName(className);
            fields  = c.getDeclaredFields();
            strings = new String[fields.length];
            for (int i =0; i < fields.length; i++){
                strings[i] = fields[i].getName();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return strings;
    }
    public static Object getFieldValueByName(String fieldName,Object o)
    {
        try {
            String firstletter=fieldName.substring(0,1);
            if ((firstletter.compareTo("a")>=0)&&(firstletter.compareTo("z")<=0))
                firstletter=firstletter.toUpperCase();
            String getter="get"+firstletter+fieldName.substring(1);
            Method method =o.getClass().getMethod(getter,new Class[]{});
            Object value=method.invoke(o,new Object[]{});
            return value;
        } catch(Exception e) {
            return null;
        }
    }
    public static void setFieldValueByName(String fieldName,Object o,Object o2)
    {
        try {
            String firstletter=fieldName.substring(0,1);
            if ((firstletter.compareTo("a")>=0)&&(firstletter.compareTo("z")<=0))
                firstletter=firstletter.toUpperCase();
            String setter="set"+firstletter+fieldName.substring(1);
            Class[] parameterTypes = new Class[1];
            Field field = o.getClass().getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            Method method =o.getClass().getMethod(setter,parameterTypes);
            method.invoke(o,new Object[]{o2});
        } catch(Exception e) {
            return;
        }
    }
    //判断是否为数字
    public static boolean isNumber(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
    public static StaDao getRes(List<Double> list) {
        DecimalFormat dec=new DecimalFormat("#.#########");
        StaDao sta=new StaDao();
        double max=0;
        double min=Double.MAX_VALUE;
        double ave=0;
        double sum=0;
        double std=0;
        for (Double d:list) {
            sum+=d;
            if (d>max)
                max=d;
            if (d<min)
                min=d;
        }
        ave=sum/(double)list.size();
        sum=0;
        for (Double d:list) {
            sum+=(d-ave)*(d-ave);
        }
        std=Math.sqrt(sum/(double)list.size());
        sta.setMax(dec.format(max));
        sta.setMin(dec.format(min));
        sta.setAverage(dec.format(ave));
        sta.setStd(dec.format(std));
        return sta;
    }

    /*切割字符串
    *@param oldValue (要切割的字符串)
    * @param remark(切割标记)
     */
    public static List<Long> splitString(String oldValue, String remarke){
        List<Long> newValueList = new ArrayList<Long>();
        String[] newArray = oldValue.split(remarke);

        for(String newString : newArray){
            if(isNumber(newString)){
                newValueList.add(Long.parseLong(newString));
            }

        }
        return newValueList;
    }

    /*
    *拼接字符串
    * @param oldValue要被拼接的List
    * @param deleteList 要去除的List
    *
     */
    public static String getNewString(List<Long> oldValue,Long[] deleteArray) {
        String newString = "";
        List<Long> deleteList = Arrays.asList(deleteArray);
        oldValue.removeAll(deleteList);
        for(long oneString : oldValue){
            newString += oneString + ",";
        }
        return newString;
    }
    public static void setWhoColumn(Object obj,boolean newFlag,Long operator)
    {
        try {
            Class<?> c = obj.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field :
                    fields) {
                if (field.getName().equals("creationDate") && newFlag) {
                    field.setAccessible(true);
                    field.set(obj, new Date());
                }
                if (field.getName().equals("createdBy") && newFlag) {
                    field.setAccessible(true);
                    field.set(obj, operator);
                }
                if (field.getName().equals("lastUpdateDate")) {
                    field.setAccessible(true);
                    field.set(obj, new Date());
                }
                if (field.getName().equals("lastUpdatedBy")) {
                    field.setAccessible(true);
                    field.set(obj, operator);
                }
            }
        }catch(Exception e)
        {

        }
    }

    public static void copy(Object from, Object to)
    {
        try {
            Class<?> c = from.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field :
                    fields) {
                if(containsField(to.getClass(),field.getName()))
                {
                    Field toField=to.getClass().getDeclaredField(field.getName());
                    toField.setAccessible(true);
                    field.setAccessible(true);
                    toField.set(to,field.get(from));
                }
            }
        }catch(Exception e)
        {
            //log
            System.out.println(e.getMessage());
        }
    }

    public static boolean containsField(Class<?> clazz, String fieldName) {
        try {
            clazz.getDeclaredField( fieldName );
            return true;
        }
        catch ( NoSuchFieldException e ) {
            return false;
        }
    }
}

package fanshe;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import static fanshe.ReflectionUtils.getFieldNames;

/**
 * @description
 * @author: xcy
 * @createTime: 2020/9/22 16:06
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Day day = new Day();
        day.setZao("哈哈哈");
        day.setWan("哈哈");
        check(day);
    }



    private static void check(Object o) throws Exception {


        Field[] fields = getDeclaredField(o);
        for(Field field:fields){

            String filedName = field.getName();
            Object singleParam = getInvoke(o, filedName, false);

            if(field.isAnnotationPresent(NotNull.class)){
                if (singleParam == null || "".equals(singleParam)) {
                    System.out.println("singleParam");
                }
                System.out.println(singleParam);
            }

        }
    }


    /**
     * 获得父类的Field[]和子类的Field[]的总数组
     *
     * @param object : 子类对象
     * @return Field[父+子]
     */
    public static Field[] getDeclaredField(Object object) {
        Class<?> clazz = object.getClass();
        clazz = clazz.getSuperclass();

        Field[] parentFields = clazz.getDeclaredFields();

        Field[] childFields = object.getClass().getDeclaredFields();

        Field[] fields = new Field[parentFields.length + childFields.length];

        System.arraycopy(parentFields, 0, fields, 0, parentFields.length);
        System.arraycopy(childFields, 0, fields, parentFields.length, childFields.length);

        return fields;
    }


    public static Object getInvoke(Object invokeObj, String attr, boolean isBoolean) throws Exception {
        String methodName = getBeanMethodName("get", attr);
        if (isBoolean) {
            methodName = getBeanMethodName("is", attr);
        }
        try {
            Method method = invokeObj.getClass().getMethod(methodName);
            method.setAccessible(true);
            return method.invoke(invokeObj);
        } catch (Exception ex) {
            try {
                // 若名字大小写不对或方法找不到则查找合适的名字再做
                Map<String, Field> attrNamesMap = getFieldNames(invokeObj);
                if (attrNamesMap.containsKey(attr.toUpperCase())) {
                    Field f = attrNamesMap.get(attr.toUpperCase());
                    f.setAccessible(true);
                    try {
                        return f.get(invokeObj);
                    } catch (Exception e) {
                        throw new Exception("动态调用get方法：" + methodName + "失败!" + e.getMessage());
                    }
                } else {
                    throw new Exception("动态调用get方法：" + methodName + "失败!" + ex.getMessage());
                }
            } catch (Exception exx) {
                throw new Exception("动态调用get方法：" + methodName + "失败!" + exx.getMessage());
            }
        }

    }

    private static String getBeanMethodName(String prefix, String attr) {
        String first = attr.substring(0, 1).toUpperCase();
        String rest = attr.substring(1);
        return prefix + first + rest;
    }
}

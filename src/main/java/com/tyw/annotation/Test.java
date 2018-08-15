package com.tyw.annotation;
/*
* @Description :
* @Date : 2018/8/14  16:32  
* */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        DomainDto testDto = new DomainDto("123", "34","1");
        DomainDto testDto1 = new DomainDto("123", "test1","");
        DomainDto testDto2 = new DomainDto("", "test1,test2,test3,test4","");
        String sql = assembleSqlFromObj(testDto,"id,username");
        String sql1 = assembleSqlFromObj(testDto1,"id,test");
        String sql2 = assembleSqlFromObj(testDto2,"username,password");
        System.out.println(sql);
        System.out.println(sql1);
        System.out.println(sql2);
    }

    /**
     * 通过注解来组装查询条件，生成查询语句
     *
     * @param obj
     * @return
     */
    public static String assembleSqlFromObj(Object obj,String columns) {
        Table table = obj.getClass().getAnnotation(Table.class);
        StringBuffer sbSql = new StringBuffer();
        String tableName = table.value();
        sbSql.append("select * from " + tableName + " where 1=1 ");
        Field[] fileds = obj.getClass().getDeclaredFields();
        for (Field f : fileds) {
            String fieldName = f.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            try {
                Column column = f.getAnnotation(Column.class);
                if (column != null) {
                    Method method = obj.getClass().getMethod(methodName);
                    String value = (String) method.invoke(obj);
                    if (value != null && !value.equals("")) {
                        if (!isNum(column.value()) && !isNum(value)) {
                            // 判断参数是不是 in 类型参数 1,2,3
                            if (value.contains(",")) {
                                sbSql.append(" and " + column.value() + " in (" + value + ") ");
                            } else {
                                sbSql.append(" and " + column.value() + " like '%" + value + "%' ");
                            }
                        } else {
                            sbSql.append(" and " + column.value() + "=" + value + " ");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sbSql.toString();
    }

    /**
     * 检查给定的值是不是 id 类型 1.检查字段名称 2.检查字段值
     *
     * @param target
     * @return
     */
    public static boolean isNum(String target) {
        boolean isNum = false;
        if (target.toLowerCase().contains("id")) {
            isNum = true;
        }
        if (target.matches("\\d+")) {
            isNum = true;
        }
        return isNum;
    }
}

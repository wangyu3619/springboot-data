package com.example.demo.utils;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author wangyu
 * @date 2018/12/14 19:34
 */
@Component
public class EntityUtils {

    public static <T> QueryWrapper<T> getQueryWrapper(Object object){
        Map map = getNotBlankFields(object);
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        for (Object item:map.keySet()){
            queryWrapper=queryWrapper.eq(item.toString(),map.get(item));
        }
        return queryWrapper;
    }

    /**
     * 获取pojo非空字段对应数据库字段集合
     * @param obj pojo对象
     * @return 非空字段对应数据库字段->值
     */
    private static Map<String,Object> getNotBlankFields(Object obj) {
        Map<String,Object> resMap = new Hashtable<>();
        if (obj == null) {
            return resMap;
        }
        Field[] fields=obj.getClass().getDeclaredFields();
        /*暂时不取父类的字段*/
        /*
        if(!obj.getClass().getSuperclass().getName().equals(Object.class.getName())){
            Field[] pField = obj.getClass().getSuperclass().getDeclaredFields();
            fields= ArrayUtil.addAll(pField,fields);
        }*/
        for (Field field : fields) {
            field.setAccessible(true);
            try{
                /*非静态字段*/
               if(!Modifier.isStatic(field.getModifiers())){
                   if (field.getType().getName().equals(String.class.getName())) {
                       if (field.get(obj) != null && !StrUtil.isBlank(field.get(obj).toString())) {
                           resMap.put(getFieldName(field.getName()), field.get(obj));
                       }
                   }else if(field.getType().getName().equals(Integer.class.getName())){
                       if (field.get(obj) != null && !StrUtil.isBlank(field.get(obj).toString())) {
                           resMap.put(getFieldName(field.getName()), field.get(obj));
                       }
                   }
               }
           }catch(IllegalArgumentException | IllegalAccessException e){
               e.printStackTrace();
           }
        }
        return resMap;
    }

    /**
     * 获取数据库字段名
     * @param field pojo字段
     * @return 符合mybatis数据库规则字段
     */
    private static String getFieldName(String field){
        if(field==null||field.length()==0){
            return field;
        }

        Pattern p = compile("[A-Z]");
        Matcher m = p.matcher(field);
        while (m.find()){
            field = field.replace(m.group(),"_"+m.group().toLowerCase());
        }
        return field;
    }
}

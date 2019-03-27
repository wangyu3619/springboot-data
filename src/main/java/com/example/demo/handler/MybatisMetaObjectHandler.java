package com.example.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.demo.entity.BaseEntity;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.reflection.MetaObject;
import cn.hutool.core.util.ReflectUtil;
import java.util.Date;
import java.util.List;

/**
 * @author wangyu
 * @date 2018/12/14 13:59
 */
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增填充
     * @param metaObject meta
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        String createTimeName = "createTime";
        Date now = new Date();
        if (metaObject.hasGetter(createTimeName)) {
            Object createTime = metaObject.getValue(createTimeName);
            if (null == createTime) {
                metaObject.setValue(createTimeName, now);
            }
            String deleteFlagName = "deleteFlag";
            Object deleteFlag = metaObject.getValue(deleteFlagName);
            if (null == deleteFlag) {
                metaObject.setValue(deleteFlagName, 0);
            }
            String modifyTime = "modifyTime";
            if (metaObject.hasSetter(modifyTime)) {
                metaObject.setValue(modifyTime, now);
            }
        }
    }

    /**
     * 修改填充
     * @param metaObject meta
     */
    @Override
    @SuppressWarnings("unchecked")
    public void updateFill(MetaObject metaObject) {
        String modifyTime = "modifyTime";
        if (metaObject.hasSetter(modifyTime)) {
            metaObject.setValue(modifyTime, new Date());
            if (metaObject.getOriginalObject() instanceof MapperMethod.ParamMap) {
                MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) metaObject.getOriginalObject();
                paramMap.forEach((key, obj) -> {
                    if (obj instanceof BaseEntity) {
                        ReflectUtil.setFieldValue(obj, modifyTime, new Date());
                    }
                    if (obj instanceof List) {
                        ((List) obj).forEach(o -> {
                            if (o instanceof BaseEntity) {
                                ReflectUtil.setFieldValue(o, modifyTime, new Date());
                            }
                        });
                    }
                });
            }
        }
    }
}
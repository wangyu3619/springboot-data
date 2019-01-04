package com.example.demo.pojo.utils;

import lombok.Data;

import java.util.List;

/**
 * 分页数据类
 * @author wangyu
 * @date 2018/12/14 16:45
 */
@Data
public class PageResult<T> {
    private List<T> list;
    private long total;

    private PageResult(List<T> list,long total){
        this.list  = list;
        this.total = total;
    }

    public static <T> PageResult<T> build(List<T> list,long total) {
        return new PageResult<>(list, total);
    }
}

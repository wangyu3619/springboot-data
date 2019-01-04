package com.example.demo.pojo.form.base;

import lombok.Data;

/**
 * @author wangyu
 * @date 2018/12/14 19:31
 */
@Data
public class BasePageForm {

    private static final int MAX_PAGE_SIZE = 500;
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 页码
     */
    private int page;
    /**
     * 分页大小
     */
    private int pageSize;

    public int getPage() {
        return Math.max(1,page);
    }

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        } else if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        return pageSize;
    }
}

package com.zwl.learn.dto;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 二师兄
 * @Date: 2020-10-20 09:54
 * @Description:
 */
public class PageInfo<T> implements Serializable {
    private Long total;
    private Integer page;
    private Integer size;
    private List<T> rows;
    public static final PageInfo EMPTY = new PageInfo(0L, 0, 0, new ArrayList());

    public void setSize(Integer size) {
        if (size != null && size >= 0) {
            this.size = size;
        } else {
            this.page = 1;
            this.size = 2147483647;
        }

    }

    public PageInfo() {
        this(0L, 0, 0, new ArrayList());
    }

    public PageInfo(Long total, Integer page, Integer size, List<T> rows) {
        this.setTotal(total);
        this.setPage(page);
        this.setSize(size);
        this.setRows(rows);
    }

    public PageInfo(Page<T> page) {
        this.setTotal(page.getTotal());
        this.setPage(page.getPageNum());
        this.setSize(page.getPageSize());
        this.setRows(page.getResult());
    }

    public PageInfo(Page page, List<T> rows) {
        this.setTotal(page.getTotal());
        this.setPage(page.getPageNum());
        this.setSize(page.getPageSize());
        this.setRows(rows);
    }

    public PageInfo(PageInfo page, List<T> rows) {
        this.setTotal(page.getTotal());
        this.setPage(page.getPage());
        this.setSize(page.getSize());
        this.setRows(rows);
    }

    public PageInfo(List<T> rows) {
        if (rows == null) {
            this.setTotal(0L);
            this.setPage(1);
            this.setSize(0);
            this.setRows(new ArrayList());
        } else {
            this.setTotal((long) rows.size());
            this.setPage(1);
            this.setSize(rows.size());
            this.setRows(rows);
        }
    }

    public Long getTotal() {
        return this.total;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getSize() {
        return this.size;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setTotal(final Long total) {
        this.total = total;
    }

    public void setPage(final Integer page) {
        this.page = page;
    }

    public void setRows(final List<T> rows) {
        this.rows = rows;
    }


}
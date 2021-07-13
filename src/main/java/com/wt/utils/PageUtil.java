package com.wt.utils;

import java.util.List;

public class PageUtil {
    // 当前页
    private int currentPage;

    // 每页条数
    private int pageSize;

    // 总数据条数
    private int countRows;

    // 总页数
    private int countPage;

    // 上页
    private int prePage;

    // 下页
    private int nextPage;

    // 携带数据
    private List list;

    // 查询条件
    private Object obj;

    public PageUtil(String currentPage, int pageSize, int countRows, Object obj, List list) {
        this.pageSize = pageSize;
        this.countRows = countRows;
        this.obj = obj;
        this.list = list;
        int current = Integer.parseInt(currentPage);
        this.currentPage = current;

        // 计算总页数
        int sum = this.countRows / this.pageSize;
        this.countPage = this.countRows / this.pageSize == 0 ? sum : sum + 1;

        // 上页
        this.prePage = current > 1 ? this.currentPage - 1 : 1;

        // 下页
        this.nextPage = current < this.countPage ? current + 1 : this.countPage;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", countRows=" + countRows +
                ", countPage=" + countPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", list=" + list +
                ", obj=" + obj +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCountRows() {
        return countRows;
    }

    public void setCountRows(int countRows) {
        this.countRows = countRows;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

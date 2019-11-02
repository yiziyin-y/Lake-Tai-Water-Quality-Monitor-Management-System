package com.glyk.heos.util;

/**
 * Created by shuai on 2017/5/10.
 */
public class Result {
    private int total;
    private int page;
    private int records;
    private Object rows;

    public Result(int total, int page, int records, Object rows) {
        this.total = total;
        this.page=page;
        this.records=records;
        this.rows=rows;
    }

    public Result() {
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

package com.base;


import java.util.List;

/**
 * 公用实体类
 *
 * @author 张宏
 */
public class PageList {

    public int pageCount;                //总页数
    public Integer Total;                //总数
    public List Rows;                    //结果集
    public List<String> removes;            //需要剔除的字段

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List getRows() {
        return Rows;
    }

    public void setRows(List rows) {
        Rows = rows;
    }

    public List<String> getRemoves() {
        return removes;
    }

    public void setRemoves(List<String> removes) {
        this.removes = removes;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }
}

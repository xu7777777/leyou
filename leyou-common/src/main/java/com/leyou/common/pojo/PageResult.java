package com.leyou.common.pojo;

import java.util.List;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/13 16:17
 */
public class PageResult<T> {

    private Long total;

    private Integer totalPage;

    private List<T> items;

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

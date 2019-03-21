package com.mydao.dvr.entrty;

public class BaseEntity {

    private Integer beginRow;

    private Integer endRow;

    private Integer pageSize;

    private Integer pageIndex;

    public Integer getBeginRow() {
        return beginRow;
    }

    public void setBeginRow(Integer beginRow) {
        this.beginRow = beginRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}

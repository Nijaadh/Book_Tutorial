package com.electron.electron.common;

import org.springframework.data.domain.Page;

public class PaginationMeta {
    private Long totalCount;
    private Integer pageSize;
    private Integer totalPages;
    private Integer pageNumber;
    private boolean isLast;
    private boolean isFirst;


    public PaginationMeta() {
    }

    public PaginationMeta(Long totalCount, Integer pageSize, Integer totalPages, Integer pageNumber, boolean isLast, boolean isFirst) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.isLast = isLast;
        this.isFirst = isFirst;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean getIsLast() {
        return isLast;
    }

    public void setIsLast(boolean last) {
        isLast = last;
    }

    public boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(boolean first) {
        isFirst = first;
    }

    public static <T>PaginationMeta createPagination(Page<T> page){
        PaginationMeta paginationMeta = new PaginationMeta();

        paginationMeta.setIsFirst(page.isFirst());
        paginationMeta.setIsLast(page.isLast());
        paginationMeta.setPageNumber(page.getNumber()+1);
        paginationMeta.setPageSize(page.getSize());
        paginationMeta.setTotalCount(page.getTotalElements());
        paginationMeta.setTotalPages(page.getTotalPages());

        return paginationMeta;
    }
}

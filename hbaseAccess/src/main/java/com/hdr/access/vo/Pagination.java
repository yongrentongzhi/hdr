package com.hdr.access.vo;

/**
 * 分页实体
 *
 * @author 余涛
 * @since 2021/2/23
 */
public class Pagination<T> {
    /**
     * 总数
     */
    private Integer total;

    /**
     * 每页数量
     */
    private Integer pageSize;
	/**
	 * 当前页
	 */
    private Integer currentPage;
	/**
	 * 当前页内容
	 */
	private T content;
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 排序规则
     */
    private String sortingRules ;

    public Pagination(Integer total, Integer pageSize, Integer currentPage, T content, String sortField, String sortingRules) {
        this.total = total;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.content = content;
        this.sortField = sortField;
        this.sortingRules = sortingRules;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortingRules() {
        return sortingRules;
    }

    public void setSortingRules(String sortingRules) {
        this.sortingRules = sortingRules;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "total=" + total +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", content=" + content +
                ", sortField='" + sortField + '\'' +
                ", sortingRules='" + sortingRules + '\'' +
                '}';
    }
}

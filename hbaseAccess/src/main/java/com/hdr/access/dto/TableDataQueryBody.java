package com.hdr.access.dto;






import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.hdr.access.vo.Pagination;

import java.util.List;
import java.util.Map;

/**
 *
 * 表数据查询
 *
 * @author 余涛
 * @since 2021年3月10日
 *
 */
public class TableDataQueryBody {
	/**
	 * 查询类型（patient_id、rowkey)
	 */
	private String searchType;
	/**
	 * 查询值
	 */
	private String searchValue;
	/**
	 * 查询返回列
	 */
	private String[] columns = {};
	/**
	 * 其他查询参数
	 */
	private List<PropertyFilter> parameters;
	/**
	 *  分页
	 */
	private Pagination<Map<String, String>> page;
	/**
	 * 表名称
	 */
	private String tableName;
	/**
	 * oid
	 */
	private String oid;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<PropertyFilter> getParameters() {
		return parameters;
	}

	public void setParameters(List<PropertyFilter> parameters) {
		this.parameters = parameters;
	}

	public Pagination<Map<String, String>> getPage() {
		return page;
	}

	public void setPage(Pagination<Map<String, String>> page) {
		this.page = page;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
}

package com.hdr.access.dao;


import com.hdr.access.vo.Pagination;
import com.hdr.access.vo.PropertyFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * 查询Dao接口
 * @author 余涛
 * @since  2021/2/23
 *
 */
public interface QueryDao {




	/**
	 * 查询数据中心数据
	 *
	 * @param tableName 查询表名
	 * @param rowKey 行键
	 * @param filters 过滤条件
	 * @param page 分页结果的载体
	 * @param columns 查询列
	 * @return 存有数据的分页载体
	 */
	Pagination<Map<String, String>> queryPageByCondition(String tableName, String rowKey, List<PropertyFilter> filters,
												  Pagination<Map<String, String>> page, String... columns);
}

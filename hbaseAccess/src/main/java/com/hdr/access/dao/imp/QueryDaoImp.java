package com.hdr.access.dao.imp;


import com.hdr.access.dao.QueryDao;
import com.hdr.access.vo.Pagination;
import com.hdr.access.vo.PropertyFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author 余涛
 * @since  2021年2月23日
 */
@Repository
public class QueryDaoImp implements QueryDao {


	/**
	 * 查询数据中心数据
	 *
	 * @param tableName 查询表名
	 * @param rowkey 行键
	 * @param filters 过滤条件
	 * @param page 分页结果的载体
	 * @param columns 查询列
	 * @return 存有数据的分页载体
	 */
	@Override
	public Pagination<Map<String, String>> queryPageByCondition(String tableName, String rowkey, List<PropertyFilter> filters, Pagination<Map<String, String>> page, String... columns) {
		byte[] startRow = Bytes.toBytes(rowkey)
		byte[] stopRow =
		return null;
	}
}

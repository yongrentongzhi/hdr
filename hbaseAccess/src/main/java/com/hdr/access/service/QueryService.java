package com.hdr.access.service;


import com.hdr.access.dto.TableDataQueryBody;
import com.hdr.access.vo.Pagination;

import java.io.IOException;
import java.util.Map;

/**
 *
 *  查询业务接口
 *
 * @author 余涛
 * @since  2021年2月23日
 *
 */
public interface QueryService {

	/**
	 * 查询hbase表数据
	 * @param tableDataQueryBody
	 * @return
	 * @throws IOException
	 */
	Pagination<Map<String, String>> getTableData(TableDataQueryBody tableDataQueryBody);
}

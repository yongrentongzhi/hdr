package com.hdr.access.service.imp;

import com.hdr.access.dao.QueryDao;
import com.hdr.access.dto.TableDataQueryBody;
import com.hdr.access.service.QueryService;
import com.hdr.access.vo.Pagination;
import com.hdr.access.vo.PropertyFilter;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @Description: 控制台查询业务实现类
 * @author: yanhengtao
 * @date: 2020年3月10日
 * @version V1.0
 */
@Service
public class QueryServiceImp implements QueryService {

	@Resource
	private QueryDao queryDao;



	/**
	 * 查询hbase表数据
	 *
	 * @param tableDataQueryBody
	 * @throws IOException
	 */
	@Override
	public Pagination<Map<String, String>> getTableData(TableDataQueryBody tableDataQueryBody)  {

		Pagination<Map<String, String>> pageInfo = new Page<Map<String, String>>();

		String searchType = tableDataQueryBody.getSearchType(); // 查询类型
		String searchValue = tableDataQueryBody.getSearchValue(); // 查询值
		String tableName = tableDataQueryBody.getTableName(); // hbase表名称
		String oid  =  tableDataQueryBody.getOid();//多院区新增oid
		Pagination<Map<String, String>> pagination = tableDataQueryBody.getPage(); // 分页实体
		String[] columns = tableDataQueryBody.getColumns();

		// 查询值<searchType或searchValue>为空
		if (StringUtils.isBlank(searchType) || StringUtils.isBlank(searchValue)) {
			List<Map<String, String>> list = consoleQueryDao.queryHbaseWithoutRowkey(tableName,
					pagination.getPageSize());
			pageInfo.setResult(list);
			pageInfo.setTotalCount(new Long(list.size()));
			pageInfo.setPageNo(pagination.getPageNo());
			pageInfo.setPageSize(pagination.getPageSize());
		} else {
			searchType = searchType.toLowerCase();
			List<PropertyFilter> filters = getFilterList(tableDataQueryBody.getParameters());
			String rowkey = getRowKey(oid,searchType, searchValue);
			Pagination<Map<String, String>> filterPage = new Page<Map<String, String>>();
			filterPage.setPageSize(pagination.getPageSize());
			filterPage.setPageNo(pagination.getPageNo());
			pageInfo = consoleQueryDao.queryHBaseTableData(tableName, rowkey, filters, filterPage, columns);
		}


		return pageInfo;
	}

	/**
	 * 获取rowkey
	 *
	 * @param searchType  查询类型
	 * @param searchValue 查询值
	 * @param      数据过滤参数
	 * @return
	 */
	public String getRowKey(String oid,String searchType, String searchValue) {
		String rowkey = "";
		if (SearchTypeEnum.PATIENT_ID.getCode().equals(searchType)) {
		    if(StringUtils.isBlank(oid) || "-".equals(oid)){
		        oid = hbaseDao.getHbaseTemplate().getOrg_oid();
            }
			rowkey = hbaseDao.getHbaseTemplate().getRowkeyPrefix(searchValue,oid);
		} else if (SearchTypeEnum.ROWKEY.getCode().equals(searchType)) {
			rowkey = searchValue;
		}
		return rowkey;
	}

	/**
	 * 返回过滤条件集合
	 *
	 * @param filters 过滤参数
	 * @return
	 */
	public List<PropertyFilter> getFilterList(List<PropertyFilter> filters) {
		if (filters == null) {
			filters = new ArrayList<PropertyFilter>();
		}
		return filters;
	}

}

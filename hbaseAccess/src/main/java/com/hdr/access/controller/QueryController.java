package com.hdr.access.controller;


import com.hdr.access.dto.TableDataQueryBody;
import com.hdr.access.service.QueryService;
import com.hdr.access.vo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 查询hbase接口
 *
 * @author yutao
 * @since 2020年3月10日
 */
@RestController
@RequestMapping("/api/v1.0/hbase")
public class QueryController {

    @Autowired
    private QueryService queryService;


    /**
     * 查询表数据
     *
     * @param tableDataQueryBody 表格数据查询体
     */
    @PostMapping("/tableData")
    Pagination<List<Map<String, String>>> listTableData(@RequestBody TableDataQueryBody tableDataQueryBody) {
        Pagination<Map<String, String>> pageInfo = null;

        pageInfo = queryService.getTableData(tableDataQueryBody);

        return buildResultVO(pageInfo);
    }
}

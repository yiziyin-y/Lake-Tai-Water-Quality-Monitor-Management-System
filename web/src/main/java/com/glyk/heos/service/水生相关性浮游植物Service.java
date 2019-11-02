package com.glyk.heos.service;

import com.glyk.heos.dal.dao.水生相关性浮游植物;
import com.glyk.heos.util.Result;

import java.util.Date;

public interface 水生相关性浮游植物Service {

    public Result get水生相关性浮游植物Info(Date startDate, Date endDate, int pageIndex, int pageSize);

    /**
     * 删除记录
     * @param rowId
     * @return
     */
    public boolean deleteRow(int rowId);

    /**
     * 修改记录
     * @param record
     * @return
     */
    public boolean updateRow(水生相关性浮游植物 record);

    /**
     * 增加记录
     * @param record
     * @return
     */
    public boolean insert(水生相关性浮游植物 record);
}

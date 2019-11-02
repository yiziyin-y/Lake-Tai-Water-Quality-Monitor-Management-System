package com.glyk.heos.service;

import com.glyk.heos.dal.dao.水生密度浮游动物;
import com.glyk.heos.util.Result;

import java.util.Date;

public interface 水生密度浮游动物Service {

    public Result get水生密度浮游动物Info(Date startDate, Date endDate, int pageIndex, int pageSize);

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
    public boolean updateRow(水生密度浮游动物 record);

    /**
     * 增加记录
     * @param record
     * @return
     */
    public boolean insert(水生密度浮游动物 record);

}

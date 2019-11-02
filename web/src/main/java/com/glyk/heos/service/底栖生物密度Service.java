package com.glyk.heos.service;

import com.glyk.heos.dal.dao.底栖生物密度;
import com.glyk.heos.util.Result;

import java.util.Date;

public interface 底栖生物密度Service {

    public Result get底栖生物密度Info(Date startDate, Date endDate, int pageIndex, int pageSize);

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
    public boolean updateRow(底栖生物密度 record);

    /**
     * 增加记录
     * @param record
     * @return
     */
    public boolean insert(底栖生物密度 record);

    /**
     * 获取指标
     * @return
     */
    public Result getIndex();
    public Result get底栖生物密度统计Info(int col,Date startDate, Date endDate);

    public Result get底栖生物密度统计Info2(String place,Date startDate, Date endDate);
    public Result get底栖生物密度Report(String place,int col);
}



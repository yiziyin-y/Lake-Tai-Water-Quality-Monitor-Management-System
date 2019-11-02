package com.glyk.heos.service;

import com.glyk.heos.dal.dao.水生密度桡足类;
import com.glyk.heos.util.Result;

import java.util.Date;

public interface 水生密度桡足类Service {

    public Result get水生密度桡足类Info(Date startDate, Date endDate, int pageIndex, int pageSize);

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
    public boolean updateRow(水生密度桡足类 record);

    /**
     * 增加记录
     * @param record
     * @return
     */
    public boolean insert(水生密度桡足类 record);
    /**
     * 获取指标
     * @return
     */
    public Result getIndex();
    public Result get水生密度桡足类统计Info(int col,Date startDate, Date endDate);
    public Result get水生密度桡足类Report(String place,int col);
    public Result get水生密度桡足类统计Info2(String place,Date startDate, Date endDate);
}

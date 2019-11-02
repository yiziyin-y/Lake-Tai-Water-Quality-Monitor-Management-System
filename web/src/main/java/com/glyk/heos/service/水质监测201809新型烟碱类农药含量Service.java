package com.glyk.heos.service;

import com.glyk.heos.dal.dao.水质监测201809新型烟碱类农药含量;
import com.glyk.heos.util.Result;

import java.util.Date;

public interface 水质监测201809新型烟碱类农药含量Service {


    public Result get水质监测201809新型烟碱类农药含量Info(Date startDate, Date endDate, int pageIndex, int pageSize);

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
    public boolean updateRow(水质监测201809新型烟碱类农药含量 record);

    /**
     * 增加记录
     * @param record
     * @return
     */
    public boolean insert(水质监测201809新型烟碱类农药含量 record);
    public Result get水质监测201809新型烟碱类农药含量统计Info(int col,Date startDate, Date endDate);
    /**
     * 获取指标
     * @return
     */
    public Result getIndex();
    public Result get水质监测201809新型烟碱类农药含量统计Info2(String place,Date startDate, Date endDate);
    public Result get水质监测201809新型烟碱类农药含量Report(String place,int col);
}

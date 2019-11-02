package com.glyk.heos.service;

import com.glyk.heos.dal.dao.底栖生物;
import com.glyk.heos.util.Result;
import com.glyk.heos.util.ResultMsg;

import java.util.Date;
import java.util.List;

public interface 底栖生物Service {

    public Result get底栖生物Info(Date startDate, Date endDate,int pageIndex, int pageSize);

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
    public boolean updateRow(底栖生物 record);

    /**
     * 增加记录
     * @param record
     * @return
     */
    public boolean insert(底栖生物 record);

}

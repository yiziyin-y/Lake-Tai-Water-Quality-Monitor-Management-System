package com.glyk.heos.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glyk.heos.dal.dao.底栖生物;
import com.glyk.heos.dal.dao.底栖生物Example;
import com.glyk.heos.dal.dao.底栖生物Mapper;
import com.glyk.heos.service.底栖生物Service;
import com.glyk.heos.util.EntityUtil;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

@Service
public class 底栖生物ServiceImpl implements 底栖生物Service {

    @Resource
    底栖生物Mapper   s底栖生物Mapper;
    @Override
    public Result get底栖生物Info(Date startDate, Date endDate, int pageIndex, int pageSize) {
        Result result = new Result();

        Map resultMap =  new HashMap();

        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.底栖生物");

        底栖生物Example s底栖生物Example = new 底栖生物Example();
        底栖生物Example.Criteria criteria = s底栖生物Example.createCriteria();
        PageHelper.startPage(pageIndex,pageSize);
        List<底栖生物> 底栖生物List = s底栖生物Mapper.selectByExample(s底栖生物Example);

        PageInfo pageInfo = new PageInfo(底栖生物List);

        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",底栖生物List);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

    @Override
    public boolean deleteRow(int rowId) {

        底栖生物Example s底栖生物Example = new 底栖生物Example();
        底栖生物Example.Criteria criteria = s底栖生物Example.createCriteria();
        criteria.andIdEqualTo(rowId);
        int result =   s底栖生物Mapper.deleteByExample(s底栖生物Example);
        return result == 1? true : false;
    }

    public boolean updateRow(底栖生物 record) {
        底栖生物Example s底栖生物Example=new 底栖生物Example();
        底栖生物Example.Criteria criteria=s底栖生物Example.createCriteria();
        criteria.andIdEqualTo(record.getId());
        int result=s底栖生物Mapper.updateByExampleSelective(record,s底栖生物Example);
        return result==1?true:false;
    }

    public boolean insert(底栖生物 record) {
        int result=s底栖生物Mapper.insert(record);
        return result==1?true:false;
    }

}

package com.glyk.heos.serviceimpl;

import com.glyk.heos.dal.dao.生物群落地址;
import com.glyk.heos.dal.dao.生物群落地址Example;
import com.glyk.heos.dal.dao.生物群落地址Mapper;
import com.glyk.heos.service.生物群落地址Service;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class 生物群落地址ServiceImpl implements 生物群落地址Service
{
    @Resource
    生物群落地址Mapper s生物群落地址Mapper;
    @Override
    public Result get生物群落地址Info() {
        Result result = new Result();

        Map resultMap =  new HashMap();

        生物群落地址Example s生物群落地址Example = new 生物群落地址Example();
        生物群落地址Example.Criteria criteria = s生物群落地址Example.createCriteria();
        List<生物群落地址> 生物群落地址List = s生物群落地址Mapper.selectByExample(s生物群落地址Example);
        resultMap.put("areaList",生物群落地址List);
        result.setRows(resultMap);
        return result;
    }
}

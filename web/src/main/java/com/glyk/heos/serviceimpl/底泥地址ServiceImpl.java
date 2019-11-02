package com.glyk.heos.serviceimpl;

import com.glyk.heos.dal.dao.底泥地址;
import com.glyk.heos.dal.dao.底泥地址Example;
import com.glyk.heos.dal.dao.底泥地址Mapper;
import com.glyk.heos.service.底泥地址Service;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class 底泥地址ServiceImpl implements 底泥地址Service
{
    @Resource
    底泥地址Mapper s底泥地址Mapper;
    @Override
    public Result get底泥地址Info() {
        Result result = new Result();

        Map resultMap =  new HashMap();

        底泥地址Example s底泥地址Example = new 底泥地址Example();
        底泥地址Example.Criteria criteria = s底泥地址Example.createCriteria();
        List<底泥地址> 底泥地址List = s底泥地址Mapper.selectByExample(s底泥地址Example);
        resultMap.put("areaList",底泥地址List);
        result.setRows(resultMap);
        return result;
    }
}

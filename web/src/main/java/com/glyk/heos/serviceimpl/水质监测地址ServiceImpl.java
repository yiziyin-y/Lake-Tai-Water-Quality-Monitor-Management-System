package com.glyk.heos.serviceimpl;

import com.glyk.heos.dal.dao.水质监测地址;
import com.glyk.heos.dal.dao.水质监测地址Example;
import com.glyk.heos.dal.dao.水质监测地址Mapper;
import com.glyk.heos.service.水质监测地址Service;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class 水质监测地址ServiceImpl implements 水质监测地址Service
{
    @Resource
    水质监测地址Mapper s水质监测地址Mapper;
    @Override
    public Result get水质监测地址Info() {
        Result result = new Result();

        Map resultMap =  new HashMap();

        水质监测地址Example s水质监测地址Example = new 水质监测地址Example();
        水质监测地址Example.Criteria criteria = s水质监测地址Example.createCriteria();
        List<水质监测地址> 水质监测地址List = s水质监测地址Mapper.selectByExample(s水质监测地址Example);
        resultMap.put("areaList",水质监测地址List);
        result.setRows(resultMap);
        return result;
    }
}

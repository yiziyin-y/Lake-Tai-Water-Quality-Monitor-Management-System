package com.glyk.heos.serviceimpl;

import com.glyk.heos.dal.dao.浮游动物密度地址;
import com.glyk.heos.dal.dao.浮游动物密度地址Example;
import com.glyk.heos.dal.dao.浮游动物密度地址Mapper;
import com.glyk.heos.service.浮游动物密度地址Service;
import com.glyk.heos.service.浮游动物密度地址Service;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class 浮游动物密度地址ServiceImpl implements 浮游动物密度地址Service
{
    @Resource
    浮游动物密度地址Mapper s浮游动物密度地址Mapper;
    @Override
    public Result get浮游动物密度地址Info() {
        Result result = new Result();

        Map resultMap =  new HashMap();

        浮游动物密度地址Example s浮游动物密度地址Example = new 浮游动物密度地址Example();
        浮游动物密度地址Example.Criteria criteria = s浮游动物密度地址Example.createCriteria();
        List<浮游动物密度地址> 浮游动物密度地址List = s浮游动物密度地址Mapper.selectByExample(s浮游动物密度地址Example);
        resultMap.put("areaList",浮游动物密度地址List);
        result.setRows(resultMap);
        return result;
    }
}
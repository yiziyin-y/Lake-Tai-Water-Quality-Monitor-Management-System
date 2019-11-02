package com.glyk.heos.serviceimpl;

import com.glyk.heos.dal.dao.浮游植物细密地址;
import com.glyk.heos.dal.dao.浮游植物细密地址Example;
import com.glyk.heos.dal.dao.浮游植物细密地址Mapper;
import com.glyk.heos.service.浮游植物细密地址Service;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class 浮游植物细密地址ServiceImpl implements 浮游植物细密地址Service
{
    @Resource
    浮游植物细密地址Mapper s浮游植物细密地址Mapper;
    @Override
    public Result get浮游植物细密地址Info() {
        Result result = new Result();

        Map resultMap =  new HashMap();

        浮游植物细密地址Example s浮游植物细密地址Example = new 浮游植物细密地址Example();
        浮游植物细密地址Example.Criteria criteria = s浮游植物细密地址Example.createCriteria();
        List<浮游植物细密地址> 浮游植物细密地址List = s浮游植物细密地址Mapper.selectByExample(s浮游植物细密地址Example);
        resultMap.put("areaList",浮游植物细密地址List);
        result.setRows(resultMap);
        return result;
    }
}

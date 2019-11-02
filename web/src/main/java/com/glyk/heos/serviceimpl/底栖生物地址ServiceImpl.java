package com.glyk.heos.serviceimpl;

import com.glyk.heos.dal.dao.底栖生物地址;
import com.glyk.heos.dal.dao.底栖生物地址Example;
import com.glyk.heos.dal.dao.底栖生物地址Mapper;
import com.glyk.heos.service.底栖生物地址Service;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class 底栖生物地址ServiceImpl implements 底栖生物地址Service
{
    @Resource
    底栖生物地址Mapper   s底栖生物地址Mapper;
    @Override
    public Result get底栖生物地址Info() {
        Result result = new Result();

        Map resultMap =  new HashMap();

        底栖生物地址Example s底栖生物地址Example = new 底栖生物地址Example();
        底栖生物地址Example.Criteria criteria = s底栖生物地址Example.createCriteria();
        List<底栖生物地址> 底栖生物地址List = s底栖生物地址Mapper.selectByExample(s底栖生物地址Example);
        resultMap.put("areaList",底栖生物地址List);
        result.setRows(resultMap);
        return result;
    }
}

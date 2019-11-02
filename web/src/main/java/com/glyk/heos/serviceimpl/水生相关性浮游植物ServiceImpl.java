package com.glyk.heos.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glyk.heos.dal.dao.水生相关性浮游植物;
import com.glyk.heos.dal.dao.水生相关性浮游植物Example;
import com.glyk.heos.dal.dao.水生相关性浮游植物Mapper;
import com.glyk.heos.service.水生相关性浮游植物Service;
import com.glyk.heos.util.EntityUtil;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class 水生相关性浮游植物ServiceImpl implements 水生相关性浮游植物Service {

    @Resource
    水生相关性浮游植物Mapper s水生相关性浮游植物Mapper;
    @Override
    public Result get水生相关性浮游植物Info(Date startDate, Date endDate, int pageIndex, int pageSize) {
        Result result = new Result();
        Map resultMap =  new HashMap();
        水生相关性浮游植物Example s水生相关性浮游植物Example = new 水生相关性浮游植物Example();
        水生相关性浮游植物Example.Criteria criteria = s水生相关性浮游植物Example.createCriteria();
        PageHelper.startPage(pageIndex,pageSize);
        List<水生相关性浮游植物> 水生相关性浮游植物List = s水生相关性浮游植物Mapper.selectByExample(s水生相关性浮游植物Example);
        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水生相关性浮游植物");
        PageInfo pageInfo = new PageInfo(水生相关性浮游植物List);
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",水生相关性浮游植物List);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

    @Override
    public boolean deleteRow(int rowId) {

        水生相关性浮游植物Example s水生相关性浮游植物Example = new 水生相关性浮游植物Example();
        水生相关性浮游植物Example.Criteria criteria = s水生相关性浮游植物Example.createCriteria();
        criteria.andIdEqualTo(rowId);
        int result =   s水生相关性浮游植物Mapper.deleteByExample(s水生相关性浮游植物Example);
        return result == 1? true : false;
    }

    public boolean updateRow(水生相关性浮游植物 record) {
        水生相关性浮游植物Example s水生相关性浮游植物Example=new 水生相关性浮游植物Example();
        水生相关性浮游植物Example.Criteria criteria=s水生相关性浮游植物Example.createCriteria();
        criteria.andIdEqualTo(record.getId());
        int result=s水生相关性浮游植物Mapper.updateByExampleSelective(record,s水生相关性浮游植物Example);
        return result==1?true:false;
    }

    public boolean insert(水生相关性浮游植物 record) {
        int result=s水生相关性浮游植物Mapper.insert(record);
        return result==1?true:false;
    }

}

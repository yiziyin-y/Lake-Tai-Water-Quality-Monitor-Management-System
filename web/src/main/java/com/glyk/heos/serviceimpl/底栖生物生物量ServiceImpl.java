package com.glyk.heos.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glyk.heos.dal.dao.*;
import com.glyk.heos.service.底栖生物生物量Service;
import com.glyk.heos.util.EntityUtil;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class 底栖生物生物量ServiceImpl implements 底栖生物生物量Service {

    @Override
    public Result get底栖生物生物量Report(String place, int col) {
        Result result=new Result();
        Map resultMap=new HashMap();
        底栖生物生物量Example s底栖生物生物量Example=new 底栖生物生物量Example();
        底栖生物生物量Example.Criteria criteria=s底栖生物生物量Example.createCriteria().and采样点位EqualTo(place);
        List<底栖生物生物量> 底栖生物生物量List=s底栖生物生物量Mapper.selectByExample(s底栖生物生物量Example);
        List<String> timelist=new ArrayList<String>();
        List<Double> reslist=new ArrayList<Double>();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.底栖生物生物量");
        String value="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        for (底栖生物生物量 data:底栖生物生物量List)
        {
            value=(String)EntityUtil.getFieldValueByName(fieldList[col],data);
            if (!value.equals("")) {
                timelist.add(sdf.format(data.get日期()));
                reslist.add(Double.parseDouble(value));
            }
        }
        resultMap.put("xdata",timelist);
        resultMap.put("ydata",reslist);
        result.setRows(resultMap);
        return result;
    }

    @Resource
    底栖生物生物量Mapper s底栖生物生物量Mapper;
    @Override
    public Result get底栖生物生物量Info(Date startDate, Date endDate, int pageIndex, int pageSize) {
        Result result = new Result();
        Map resultMap =  new HashMap();
        底栖生物生物量Example s底栖生物生物量Example = new 底栖生物生物量Example();
        底栖生物生物量Example.Criteria criteria = s底栖生物生物量Example.createCriteria().and日期Between(startDate,endDate);
        PageHelper.startPage(pageIndex,pageSize);
        List<底栖生物生物量> 底栖生物生物量List = s底栖生物生物量Mapper.selectByExample(s底栖生物生物量Example);
        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.底栖生物生物量");
        PageInfo pageInfo = new PageInfo(底栖生物生物量List);
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",底栖生物生物量List);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

    @Override
    public boolean deleteRow(int rowId) {

        底栖生物生物量Example s底栖生物生物量Example = new 底栖生物生物量Example();
        底栖生物生物量Example.Criteria criteria = s底栖生物生物量Example.createCriteria();
        criteria.andIdEqualTo(rowId);
        int result =   s底栖生物生物量Mapper.deleteByExample(s底栖生物生物量Example);
        return result == 1? true : false;
    }

    public boolean updateRow(底栖生物生物量 record) {
        底栖生物生物量Example s底栖生物生物量Example=new 底栖生物生物量Example();
        底栖生物生物量Example.Criteria criteria=s底栖生物生物量Example.createCriteria();
        criteria.andIdEqualTo(record.getId());
        int result=s底栖生物生物量Mapper.updateByExampleSelective(record,s底栖生物生物量Example);
        return result==1?true:false;
    }

    public boolean insert(底栖生物生物量 record) {
        int result=s底栖生物生物量Mapper.insert(record);
        return result==1?true:false;
    }
    public Result get底栖生物生物量统计Info(int col, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        底栖生物生物量Example s底栖生物生物量Example=new 底栖生物生物量Example();
        底栖生物生物量Example.Criteria criteria=s底栖生物生物量Example.createCriteria().and日期Between(startDate,endDate);
//        PageHelper.startPage(pageIndex,pageSize);
        List<底栖生物生物量> 底栖生物生物量List=s底栖生物生物量Mapper.selectByExample(s底栖生物生物量Example);
        Collections.sort(底栖生物生物量List, new Comparator<底栖生物生物量>() {
            @Override
            public int compare(底栖生物生物量 o1, 底栖生物生物量 o2) {
                return o1.get采样点位().compareTo(o2.get采样点位());
            }
        });
        String[] fieldList={"采样点位","平均值","最大值","最小值","标准差"};
        String[] fieldList2=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.底栖生物生物量");
        List<Double> list=new ArrayList<Double>();
        List<StaAreaDao> listRes=new ArrayList<StaAreaDao>();
        String pre="";
        String value="";
        int num=0;

        for (底栖生物生物量 data:底栖生物生物量List) {
            if (!data.get采样点位().equals(pre))
            {
                if (!list.isEmpty()) {
                    StaAreaDao staAreaDao=new StaAreaDao();
                    StaDao sta=EntityUtil.getRes(list);
                    staAreaDao.setArea(pre);
                    staAreaDao.setAverage(sta.getAverage());
                    staAreaDao.setMax(sta.getMax());
                    staAreaDao.setMin(sta.getMin());
                    staAreaDao.setStd(sta.getStd());
                    listRes.add(staAreaDao);
                }
                list.clear();
                pre=data.get采样点位();
            }
            value=(String)EntityUtil.getFieldValueByName(fieldList2[col],data);
            if (!value.equals("")) {
                list.add(Double.parseDouble(value));
            }
        }
        if (!list.isEmpty()) {
            StaAreaDao staAreaDao = new StaAreaDao();
            StaDao sta = EntityUtil.getRes(list);
            staAreaDao.setArea(pre);
            staAreaDao.setAverage(sta.getAverage());
            staAreaDao.setMax(sta.getMax());
            staAreaDao.setMin(sta.getMin());
            staAreaDao.setStd(sta.getStd());
            listRes.add(staAreaDao);
            list.clear();
        }
        PageInfo pageInfo=new PageInfo(listRes);
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",listRes);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

    @Override
    public Result get底栖生物生物量统计Info2(String place, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        底栖生物生物量Example s底栖生物生物量Example=new 底栖生物生物量Example();
        底栖生物生物量Example.Criteria criteria=s底栖生物生物量Example.createCriteria().and日期Between(startDate,endDate).and采样点位EqualTo(place);
//        PageHelper.startPage(pageIndex,pageSize);
        List<底栖生物生物量> 底栖生物生物量List=s底栖生物生物量Mapper.selectByExample(s底栖生物生物量Example);
        List<底栖生物生物量> 底栖生物生物量ListRes=new ArrayList<底栖生物生物量>();
        底栖生物生物量 d1=new 底栖生物生物量();
        底栖生物生物量 d2=new 底栖生物生物量();
        底栖生物生物量 d3=new 底栖生物生物量();
        底栖生物生物量 d4=new 底栖生物生物量();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.底栖生物生物量");
        List<Double> list=new ArrayList<Double>();
        StaDao sta=null;
        String value="";
        for (int col=4;col<fieldList.length;col++)
        {

            for (底栖生物生物量 data:底栖生物生物量List)
            {
                value=(String)EntityUtil.getFieldValueByName(fieldList[col],data);
                if (!value.equals("")) {
                    list.add(Double.parseDouble(value));
                }
            }
            if (!list.isEmpty()) {
                sta = EntityUtil.getRes(list);
//                System.out.println(sta.getAverage()+" "+sta.getMax()+" "+sta.getMax()+" "+sta.getMin());
                EntityUtil.setFieldValueByName(fieldList[col], d1, sta.getAverage());
                EntityUtil.setFieldValueByName(fieldList[col], d2, sta.getMax());
                EntityUtil.setFieldValueByName(fieldList[col], d3, sta.getMin());
                EntityUtil.setFieldValueByName(fieldList[col], d4, sta.getStd());
                System.out.println((String)EntityUtil.getFieldValueByName(fieldList[col],d1));
            }
            list.clear();;
        }
        d1.set采样点位("平均值");
        d2.set采样点位("最大值");
        d3.set采样点位("最小值");
        d4.set采样点位("标准差");
        底栖生物生物量ListRes.add(d1);
        底栖生物生物量ListRes.add(d2);
        底栖生物生物量ListRes.add(d3);
        底栖生物生物量ListRes.add(d4);
        PageInfo pageInfo = new PageInfo(底栖生物生物量ListRes);
        fieldList[2]="";
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",底栖生物生物量ListRes);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

    @Override
    public Result getIndex() {
        Result result = new Result();
        Map resultMap =  new HashMap();
        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.底栖生物生物量");
        resultMap.put("options",fieldList);
        result.setRows(resultMap);
        return result;
    }

}

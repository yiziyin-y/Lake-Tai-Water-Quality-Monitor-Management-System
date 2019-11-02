package com.glyk.heos.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glyk.heos.dal.dao.*;
import com.glyk.heos.service.水质监测201809数据总表Service;
import com.glyk.heos.util.EntityUtil;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class 水质监测201809数据总表ServiceImpl implements 水质监测201809数据总表Service {

    @Resource
    水质监测201809数据总表Mapper   s水质监测201809数据总表Mapper;
    @Override
    public Result get水质监测201809数据总表Info(Date startDate, Date endDate, int pageIndex, int pageSize) {
        Result result = new Result();

        Map resultMap =  new HashMap();

        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水质监测201809数据总表");

        水质监测201809数据总表Example s水质监测201809数据总表Example = new 水质监测201809数据总表Example();
        水质监测201809数据总表Example.Criteria criteria = s水质监测201809数据总表Example.createCriteria();
        PageHelper.startPage(pageIndex,pageSize);
        List<水质监测201809数据总表> 水质监测201809数据总表List = s水质监测201809数据总表Mapper.selectByExample(s水质监测201809数据总表Example);

        PageInfo pageInfo = new PageInfo(水质监测201809数据总表List);

        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",水质监测201809数据总表List);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

    @Override
    public Result getIndex() {
        Result result = new Result();
        Map resultMap =  new HashMap();
        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水质监测201809数据总表");
        resultMap.put("options",fieldList);
        result.setRows(resultMap);
        return result;
    }

    @Override
    public boolean deleteRow(int rowId) {

        水质监测201809数据总表Example s水质监测201809数据总表Example = new 水质监测201809数据总表Example();
        水质监测201809数据总表Example.Criteria criteria = s水质监测201809数据总表Example.createCriteria();
        criteria.andIdEqualTo(rowId);
        int result =   s水质监测201809数据总表Mapper.deleteByExample(s水质监测201809数据总表Example);
        return result == 1? true : false;
    }

    public boolean updateRow(水质监测201809数据总表 record) {
        水质监测201809数据总表Example s水质监测201809数据总表Example=new 水质监测201809数据总表Example();
        水质监测201809数据总表Example.Criteria criteria=s水质监测201809数据总表Example.createCriteria();
        criteria.andIdEqualTo(record.getId());
        int result=s水质监测201809数据总表Mapper.updateByExampleSelective(record,s水质监测201809数据总表Example);
        return result==1?true:false;
    }

    public boolean insert(水质监测201809数据总表 record) {
        int result=s水质监测201809数据总表Mapper.insert(record);
        return result==1?true:false;
    }

    public Result get水质监测201809数据总表统计Info(int col, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        水质监测201809数据总表Example s水质监测201809数据总表Example=new 水质监测201809数据总表Example();
        水质监测201809数据总表Example.Criteria criteria=s水质监测201809数据总表Example.createCriteria().and日期Between(startDate,endDate);
//        PageHelper.startPage(pageIndex,pageSize);
        List<水质监测201809数据总表> 水质监测201809数据总表List=s水质监测201809数据总表Mapper.selectByExample(s水质监测201809数据总表Example);
        Collections.sort(水质监测201809数据总表List, new Comparator<水质监测201809数据总表>() {
            @Override
            public int compare(水质监测201809数据总表 o1, 水质监测201809数据总表 o2) {
                return o1.get采样点位().compareTo(o2.get采样点位());
            }
        });
        String[] fieldList={"采样点位","平均值","最大值","最小值","标准差"};
        String[] fieldList2=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水质监测201809数据总表");
        List<Double> list=new ArrayList<Double>();
        List<StaAreaDao> listRes=new ArrayList<StaAreaDao>();
        String pre="";
        String value="";
        int num=0;

        for (水质监测201809数据总表 data:水质监测201809数据总表List) {
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
    public Result get水质监测201809数据总表统计Info2(String place, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        水质监测201809数据总表Example s水质监测201809数据总表Example=new 水质监测201809数据总表Example();
        水质监测201809数据总表Example.Criteria criteria=s水质监测201809数据总表Example.createCriteria().and日期Between(startDate,endDate).and采样点位EqualTo(place);
//        PageHelper.startPage(pageIndex,pageSize);
        List<水质监测201809数据总表> 水质监测201809数据总表List=s水质监测201809数据总表Mapper.selectByExample(s水质监测201809数据总表Example);
        List<水质监测201809数据总表> 水质监测201809数据总表ListRes=new ArrayList<水质监测201809数据总表>();
        水质监测201809数据总表 d1=new 水质监测201809数据总表();
        水质监测201809数据总表 d2=new 水质监测201809数据总表();
        水质监测201809数据总表 d3=new 水质监测201809数据总表();
        水质监测201809数据总表 d4=new 水质监测201809数据总表();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水质监测201809数据总表");
        List<Double> list=new ArrayList<Double>();
        StaDao sta=null;
        String value="";
        for (int col=4;col<fieldList.length;col++)
        {

            for (水质监测201809数据总表 data:水质监测201809数据总表List)
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
        水质监测201809数据总表ListRes.add(d1);
        水质监测201809数据总表ListRes.add(d2);
        水质监测201809数据总表ListRes.add(d3);
        水质监测201809数据总表ListRes.add(d4);
        PageInfo pageInfo = new PageInfo(水质监测201809数据总表ListRes);
        fieldList[2]="";
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",水质监测201809数据总表ListRes);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

    @Override
    public Result get水质监测201809数据总表Report(String place, int col) {
        Result result=new Result();
        Map resultMap=new HashMap();
        水质监测201809数据总表Example s水质监测201809数据总表Example=new 水质监测201809数据总表Example();
        水质监测201809数据总表Example.Criteria criteria=s水质监测201809数据总表Example.createCriteria().and采样点位EqualTo(place);
        List<水质监测201809数据总表> 水质监测201809数据总表List=s水质监测201809数据总表Mapper.selectByExample(s水质监测201809数据总表Example);
        List<String> timelist=new ArrayList<String>();
        List<Double> reslist=new ArrayList<Double>();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水质监测201809数据总表");
        String value="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        for (水质监测201809数据总表 data:水质监测201809数据总表List)
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

}

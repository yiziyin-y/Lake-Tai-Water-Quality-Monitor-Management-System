package com.glyk.heos.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glyk.heos.dal.dao.*;
import com.glyk.heos.service.生物群落201809bacteriaService;
import com.glyk.heos.util.EntityUtil;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class 生物群落201809bacteriaServiceImpl implements 生物群落201809bacteriaService {
    @Override
    public Result get生物群落201809bacteriaReport(String place, int col) {
        Result result=new Result();
        Map resultMap=new HashMap();
        生物群落201809bacteriaExample s生物群落201809bacteriaExample=new 生物群落201809bacteriaExample();
        生物群落201809bacteriaExample.Criteria criteria=s生物群落201809bacteriaExample.createCriteria().and采样点位EqualTo(place);
        List<生物群落201809bacteria> 生物群落201809bacteriaList=s生物群落201809bacteriaMapper.selectByExample(s生物群落201809bacteriaExample);
        List<String> timelist=new ArrayList<String>();
        List<Double> reslist=new ArrayList<Double>();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.生物群落201809bacteria");
        String value="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        for (生物群落201809bacteria data:生物群落201809bacteriaList)
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
    生物群落201809bacteriaMapper   s生物群落201809bacteriaMapper;
    @Override
    public Result get生物群落201809bacteriaInfo(Date startDate, Date endDate, int pageIndex, int pageSize) {
        Result result = new Result();

        Map resultMap =  new HashMap();

        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.生物群落201809bacteria");

        生物群落201809bacteriaExample s生物群落201809bacteriaExample = new 生物群落201809bacteriaExample();
        生物群落201809bacteriaExample.Criteria criteria = s生物群落201809bacteriaExample.createCriteria();
        PageHelper.startPage(pageIndex,pageSize);
        List<生物群落201809bacteria> 生物群落201809bacteriaList = s生物群落201809bacteriaMapper.selectByExample(s生物群落201809bacteriaExample);

        PageInfo pageInfo = new PageInfo(生物群落201809bacteriaList);

        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",生物群落201809bacteriaList);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }
    @Override
    public Result getIndex() {
        Result result = new Result();
        Map resultMap =  new HashMap();
        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.生物群落201809bacteria");
        resultMap.put("options",fieldList);
        result.setRows(resultMap);
        return result;
    }
    @Override
    public boolean deleteRow(int rowId) {

        生物群落201809bacteriaExample s生物群落201809bacteriaExample = new 生物群落201809bacteriaExample();
        生物群落201809bacteriaExample.Criteria criteria = s生物群落201809bacteriaExample.createCriteria();
        criteria.andIdEqualTo(rowId);
        int result =   s生物群落201809bacteriaMapper.deleteByExample(s生物群落201809bacteriaExample);
        return result == 1? true : false;
    }

    public boolean updateRow(生物群落201809bacteria record) {
        生物群落201809bacteriaExample s生物群落201809bacteriaExample=new 生物群落201809bacteriaExample();
        生物群落201809bacteriaExample.Criteria criteria=s生物群落201809bacteriaExample.createCriteria();
        criteria.andIdEqualTo(record.getId());
        int result=s生物群落201809bacteriaMapper.updateByExampleSelective(record,s生物群落201809bacteriaExample);
        return result==1?true:false;
    }

    public boolean insert(生物群落201809bacteria record) {
        int result=s生物群落201809bacteriaMapper.insert(record);
        return result==1?true:false;
    }
    public Result get生物群落201809bacteria统计Info(int col, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        生物群落201809bacteriaExample s生物群落201809bacteriaExample=new 生物群落201809bacteriaExample();
        生物群落201809bacteriaExample.Criteria criteria=s生物群落201809bacteriaExample.createCriteria().and日期Between(startDate,endDate);
//        PageHelper.startPage(pageIndex,pageSize);
        List<生物群落201809bacteria> 生物群落201809bacteriaList=s生物群落201809bacteriaMapper.selectByExample(s生物群落201809bacteriaExample);
        Collections.sort(生物群落201809bacteriaList, new Comparator<生物群落201809bacteria>() {
            @Override
            public int compare(生物群落201809bacteria o1, 生物群落201809bacteria o2) {
                return o1.get采样点位().compareTo(o2.get采样点位());
            }
        });
        String[] fieldList={"采样点位","平均值","最大值","最小值","标准差"};
        String[] fieldList2=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.生物群落201809bacteria");
        List<Double> list=new ArrayList<Double>();
        List<StaAreaDao> listRes=new ArrayList<StaAreaDao>();
        String pre="";
        String value="";
        int num=0;

        for (生物群落201809bacteria data:生物群落201809bacteriaList) {
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
    public Result get生物群落201809bacteria统计Info2(String place, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        生物群落201809bacteriaExample s生物群落201809bacteriaExample=new 生物群落201809bacteriaExample();
        生物群落201809bacteriaExample.Criteria criteria=s生物群落201809bacteriaExample.createCriteria().and日期Between(startDate,endDate).and采样点位EqualTo(place);
//        PageHelper.startPage(pageIndex,pageSize);
        List<生物群落201809bacteria> 生物群落201809bacteriaList=s生物群落201809bacteriaMapper.selectByExample(s生物群落201809bacteriaExample);
        List<生物群落201809bacteria> 生物群落201809bacteriaListRes=new ArrayList<生物群落201809bacteria>();
        生物群落201809bacteria d1=new 生物群落201809bacteria();
        生物群落201809bacteria d2=new 生物群落201809bacteria();
        生物群落201809bacteria d3=new 生物群落201809bacteria();
        生物群落201809bacteria d4=new 生物群落201809bacteria();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.生物群落201809bacteria");
        List<Double> list=new ArrayList<Double>();
        StaDao sta=null;
        String value="";
        for (int col=4;col<fieldList.length;col++)
        {

            for (生物群落201809bacteria data:生物群落201809bacteriaList)
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
        生物群落201809bacteriaListRes.add(d1);
        生物群落201809bacteriaListRes.add(d2);
        生物群落201809bacteriaListRes.add(d3);
        生物群落201809bacteriaListRes.add(d4);
        PageInfo pageInfo = new PageInfo(生物群落201809bacteriaListRes);
        fieldList[2]="";
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",生物群落201809bacteriaListRes);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

}

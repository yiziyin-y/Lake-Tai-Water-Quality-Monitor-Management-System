package com.glyk.heos.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glyk.heos.dal.dao.*;
import com.glyk.heos.service.水生多样性枝角类Service;
import com.glyk.heos.util.EntityUtil;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class 水生多样性枝角类ServiceImpl implements 水生多样性枝角类Service {
    @Override
    public Result get水生多样性枝角类Report(String place, int col) {
        Result result=new Result();
        Map resultMap=new HashMap();
        水生多样性枝角类Example s水生多样性枝角类Example=new 水生多样性枝角类Example();
        水生多样性枝角类Example.Criteria criteria=s水生多样性枝角类Example.createCriteria().and采样点位EqualTo(place);
        List<水生多样性枝角类> 水生多样性枝角类List=s水生多样性枝角类Mapper.selectByExample(s水生多样性枝角类Example);
        List<String> timelist=new ArrayList<String>();
        List<Double> reslist=new ArrayList<Double>();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水生多样性枝角类");
        String value="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        for (水生多样性枝角类 data:水生多样性枝角类List)
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
    水生多样性枝角类Mapper s水生多样性枝角类Mapper;
    @Override
    public Result get水生多样性枝角类Info(Date startDate, Date endDate, int pageIndex, int pageSize) {
        Result result = new Result();
        Map resultMap =  new HashMap();
        水生多样性枝角类Example s水生多样性枝角类Example = new 水生多样性枝角类Example();
        水生多样性枝角类Example.Criteria criteria = s水生多样性枝角类Example.createCriteria().and日期Between(startDate,endDate);
        PageHelper.startPage(pageIndex,pageSize);
        List<水生多样性枝角类> 水生多样性枝角类List = s水生多样性枝角类Mapper.selectByExample(s水生多样性枝角类Example);
        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水生多样性枝角类");
        PageInfo pageInfo = new PageInfo(水生多样性枝角类List);
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",水生多样性枝角类List);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }
    @Override
    public Result getIndex() {
        Result result = new Result();
        Map resultMap =  new HashMap();
        String[] fieldList = EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水生多样性枝角类");
        resultMap.put("options",fieldList);
        result.setRows(resultMap);
        return result;
    }

    @Override
    public boolean deleteRow(int rowId) {

        水生多样性枝角类Example s水生多样性枝角类Example = new 水生多样性枝角类Example();
        水生多样性枝角类Example.Criteria criteria = s水生多样性枝角类Example.createCriteria();
        criteria.andIdEqualTo(rowId);
        int result =   s水生多样性枝角类Mapper.deleteByExample(s水生多样性枝角类Example);
        return result == 1? true : false;
    }

    public boolean updateRow(水生多样性枝角类 record) {
        水生多样性枝角类Example s水生多样性枝角类Example=new 水生多样性枝角类Example();
        水生多样性枝角类Example.Criteria criteria=s水生多样性枝角类Example.createCriteria();
        criteria.andIdEqualTo(record.getId());
        int result=s水生多样性枝角类Mapper.updateByExampleSelective(record,s水生多样性枝角类Example);
        return result==1?true:false;
    }

    public boolean insert(水生多样性枝角类 record) {
        int result=s水生多样性枝角类Mapper.insert(record);
        return result==1?true:false;
    }
    public Result get水生多样性枝角类统计Info(int col, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        水生多样性枝角类Example s水生多样性枝角类Example=new 水生多样性枝角类Example();
        水生多样性枝角类Example.Criteria criteria=s水生多样性枝角类Example.createCriteria().and日期Between(startDate,endDate);
//        PageHelper.startPage(pageIndex,pageSize);
        List<水生多样性枝角类> 水生多样性枝角类List=s水生多样性枝角类Mapper.selectByExample(s水生多样性枝角类Example);
        Collections.sort(水生多样性枝角类List, new Comparator<水生多样性枝角类>() {
            @Override
            public int compare(水生多样性枝角类 o1, 水生多样性枝角类 o2) {
                return o1.get采样点位().compareTo(o2.get采样点位());
            }
        });
        String[] fieldList={"采样点位","平均值","最大值","最小值","标准差"};
        String[] fieldList2=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水生多样性枝角类");
        List<Double> list=new ArrayList<Double>();
        List<StaAreaDao> listRes=new ArrayList<StaAreaDao>();
        String pre="";
        String value="";
        int num=0;

        for (水生多样性枝角类 data:水生多样性枝角类List) {
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
    public Result get水生多样性枝角类统计Info2(String place, Date startDate, Date endDate) {
        Result result=new Result();
        Map resultMap=new HashMap();
        水生多样性枝角类Example s水生多样性枝角类Example=new 水生多样性枝角类Example();
        水生多样性枝角类Example.Criteria criteria=s水生多样性枝角类Example.createCriteria().and日期Between(startDate,endDate).and采样点位EqualTo(place);
//        PageHelper.startPage(pageIndex,pageSize);
        List<水生多样性枝角类> 水生多样性枝角类List=s水生多样性枝角类Mapper.selectByExample(s水生多样性枝角类Example);
        List<水生多样性枝角类> 水生多样性枝角类ListRes=new ArrayList<水生多样性枝角类>();
        水生多样性枝角类 d1=new 水生多样性枝角类();
        水生多样性枝角类 d2=new 水生多样性枝角类();
        水生多样性枝角类 d3=new 水生多样性枝角类();
        水生多样性枝角类 d4=new 水生多样性枝角类();
        String[] fieldList=EntityUtil.getClassColmun("com.glyk.heos.dal.dao.水生多样性枝角类");
        List<Double> list=new ArrayList<Double>();
        StaDao sta=null;
        String value="";
        for (int col=4;col<fieldList.length;col++)
        {

            for (水生多样性枝角类 data:水生多样性枝角类List)
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
        水生多样性枝角类ListRes.add(d1);
        水生多样性枝角类ListRes.add(d2);
        水生多样性枝角类ListRes.add(d3);
        水生多样性枝角类ListRes.add(d4);
        PageInfo pageInfo = new PageInfo(水生多样性枝角类ListRes);
        fieldList[2]="";
        resultMap.put("tHead",fieldList);
        resultMap.put("tBody",水生多样性枝角类ListRes);
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(resultMap);
        return result;
    }

}

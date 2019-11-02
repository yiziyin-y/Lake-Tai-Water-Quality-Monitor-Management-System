package com.glyk.heos.serviceimpl;

import com.glyk.heos.dal.dao.Usertable;
import com.glyk.heos.dal.dao.UsertableExample;
import com.glyk.heos.dal.dao.UsertableMapper;
import com.glyk.heos.service.UsertableService;
import com.glyk.heos.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsertableServiceImpl implements UsertableService
{
    @Resource
    UsertableMapper sUsertableMapper;
    @Override
    public int getUsertableInfo(String name,String pwd) {
        Result result = new Result();
        Map resultMap =  new HashMap();
        UsertableExample sUsertableExample = new UsertableExample();
        UsertableExample.Criteria criteria = sUsertableExample.createCriteria().andNameEqualTo(name);
        List<Usertable> UsertableList = sUsertableMapper.selectByExample(sUsertableExample);
        if (UsertableList.size()==0)
            return 0;
        Usertable user=UsertableList.get(0);
        if (user.getPwd().equals(pwd))
            return user.getRole();
        return 0;
    }
}

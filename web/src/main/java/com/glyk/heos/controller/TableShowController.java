package com.glyk.heos.controller;

import com.glyk.heos.dal.dao.*;
import com.glyk.heos.service.*;
import com.glyk.heos.util.Result;
import com.glyk.heos.util.ResultMsg;
import com.glyk.heos.util.ResultStatusCode;
import com.glyk.heos.util.TableCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("table")
public class TableShowController {

    @Resource
    底栖生物Service s底栖生物Service;

    @Resource
    底栖生物密度Service s底栖生物密度Service;

    @Resource
    底栖生物生物量Service s底栖生物生物量Service;

    @Resource
    水生密度浮游动物Service s水生密度浮游动物Service;

    @Resource
    水生密度轮虫Service s水生密度轮虫Service;

    @Resource
    水生密度密度Service s水生密度密度Service;

    @Resource
    水生密度桡足类Service s水生密度桡足类Service;

    @Resource
    水生密度原生动物Service s水生密度原生动物Service;

    @Resource
    水生多样性生物量Service s水生多样性生物量Service;

    @Resource
    水生多样性轮虫Service s水生多样性轮虫Service;

    @Resource
    水生多样性数据总表Service s水生多样性数据总表Service;

    @Resource
    水生多样性足类Service s水生多样性足类Service;

    @Resource
    水生多样性原生动物Service s水生多样性原生动物Service;

    @Resource
    水生多样性枝角类Service s水生多样性枝角类Service;

    @Resource
    水生相关性浮游植物Service s水生相关性浮游植物Service;

    @Resource
    水生相关性硅藻门Service s水生相关性硅藻门Service;

    @Resource
    水生相关性甲藻门Service s水生相关性甲藻门Service;

    @Resource
    水生相关性金藻门Service s水生相关性金藻门Service;

    @Resource
    水生相关性蓝藻门Service s水生相关性蓝藻门Service;

    @Resource
    水生相关性裸藻门Service s水生相关性裸藻门Service;

    @Resource
    水生相关性绿藻门Service s水生相关性绿藻门Service;

    @Resource
    水生相关性隐藻门Service s水生相关性隐藻门Service;

    @Resource
    水生相关性生物量Service s水生相关性生物量Service;

    @Resource
    水生相关性数据总表Service s水生相关性数据总表Service;

    @Resource
    底栖生物地址Service s底栖生物地址Service;

    @Resource
    浮游动物多样性地址Service s浮游动物多样性地址Service;

    @Resource
    浮游动物密度地址Service s浮游动物密度地址Service;

    @Resource
    浮游植物相关性地址Service s浮游植物相关性地址Service;

    @Resource
    水生细密细胞密度Service s水生细密细胞密度Service;

    @Resource
    水生细密硅藻门Service s水生细密硅藻门Service;

    @Resource
    水生细密隐藻门Service s水生细密隐藻门Service;

    @Resource
    水生细密甲藻门Service s水生细密甲藻门Service;

    @Resource
    水生细密金藻门Service s水生细密金藻门Service;

    @Resource
    水生细密蓝藻门Service s水生细密蓝藻门Service;

    @Resource
    水生细密裸藻门Service s水生细密裸藻门Service;

    @Resource
    水生细密绿藻门Service s水生细密绿藻门Service;

    @Resource
    生物群落201809archaeaService s生物群落201809archaeaService;

    @Resource
    生物群落201809bacteriaService s生物群落201809bacteriaService;

    @Resource
    生物群落201809数据总表Service s生物群落201809数据总表Service;

    @Resource
    水质监测201809新型烟碱类农药含量Service s水质监测201809新型烟碱类农药含量Service;

    @Resource
    水质监测201809有机磷酸酯的含量Service s水质监测201809有机磷酸酯的含量Service;

    @Resource
    水质监测201809磺胺类抗生素的含量Service s水质监测201809磺胺类抗生素的含量Service;

    @Resource
    水质监测201809数据总表Service s水质监测201809数据总表Service;

    @Resource
    浮游植物细密地址Service s浮游植物细密地址Service;

    @Resource
    生物群落地址Service s生物群落地址Service;

    @Resource
    底泥地址Service s底泥地址Service;

    @Resource
    水质监测地址Service s水质监测地址Service;

    @Resource
    UsertableService sUsertableService;
    /**
     * 所在表的index
     */
    TableCode tableCode = new TableCode();

    /**
     * 处理用户
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("userTable")
    @ResponseBody
    public ResultMsg getUserInfo(String name,String pwd) {
        ResultMsg resultMsg=new ResultMsg();
        resultMsg.setStatus(sUsertableService.getUsertableInfo(name,pwd));
        return resultMsg;
    }
    /**
     * 删除记录
     * @param rowId
     * @return
     */
    @RequestMapping("deleteTable")
    @ResponseBody
    public ResultMsg deleteTable(int oneMenuIndex,int twoMenuIndex,int rowId){
        ResultMsg resultMsg = new ResultMsg();
        boolean result=false;
        if(oneMenuIndex == 0){
            if(twoMenuIndex == 0){
                result = s底栖生物Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 1){
                result = s底栖生物密度Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s底栖生物生物量Service.deleteRow(rowId);
            }
        }
        if(oneMenuIndex == 1){
            if(twoMenuIndex == 0){
                result = s水生密度浮游动物Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 1){
                result = s水生密度轮虫Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s水生密度密度Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 3){
                result = s水生密度桡足类Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s水生密度原生动物Service.deleteRow(rowId);
            }
        }
        if(oneMenuIndex == 2){
            if(twoMenuIndex == 0){
                result = s水生多样性生物量Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 1){
                result = s水生多样性轮虫Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s水生多样性数据总表Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 3){
                result = s水生多样性足类Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 4){
                result = s水生多样性原生动物Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 5){
                result = s水生多样性枝角类Service.deleteRow(rowId);
            }
        }
        if(oneMenuIndex == 3){
            if(twoMenuIndex == 0){
                result = s水生相关性浮游植物Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 1){
                result = s水生相关性硅藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s水生相关性甲藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 3){
                result = s水生相关性金藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 4){
                result = s水生相关性蓝藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 5){
                result = s水生相关性裸藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 6){
                result = s水生相关性绿藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 7){
                result = s水生相关性隐藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 8){
                result = s水生相关性生物量Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 9){
                result = s水生相关性数据总表Service.deleteRow(rowId);
            }
        }

        if(oneMenuIndex == 4){
            if(twoMenuIndex == 0){
                result = s水生细密细胞密度Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 1){
                result = s水生细密硅藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s水生细密甲藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 3){
                result = s水生细密金藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 4){
                result = s水生细密蓝藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 5){
                result = s水生细密裸藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 6){
                result = s水生细密绿藻门Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 7){
                result = s水生细密隐藻门Service.deleteRow(rowId);

            }
        }

        if(oneMenuIndex == 5){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.deleteRow(rowId);
            }
            if(twoMenuIndex == 1){
                result = s生物群落201809bacteriaService.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s生物群落201809数据总表Service.deleteRow(rowId);

            }
        }


        if(oneMenuIndex == 6){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.deleteRow(rowId);

            }
        }


        if(oneMenuIndex == 7){
            if(twoMenuIndex == 0){
                result = s水质监测201809磺胺类抗生素的含量Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 1){
                result = s水质监测201809数据总表Service.deleteRow(rowId);
            }
            if(twoMenuIndex == 2){
                result = s水质监测201809新型烟碱类农药含量Service.deleteRow(rowId);

            }
            if(twoMenuIndex == 3){
                result = s水质监测201809有机磷酸酯的含量Service.deleteRow(rowId);

            }
        }
        resultMsg.setStatus(1);
        resultMsg.setData(result);

        /**
         * 去做神马
         */

        return  resultMsg;
    }

    /**
     *修改记录00
     * @param record
     * @return
     */
    @RequestMapping("modifyTable00")
    @ResponseBody
    public ResultMsg modifyTable00(底栖生物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s底栖生物Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录00
     * @param record
     * @return
     */
    @RequestMapping("insertTable00")
    @ResponseBody
    public ResultMsg insertTable00(底栖生物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s底栖生物Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *修改记录01
     * @param record
     * @return
     */
    @RequestMapping("modifyTable01")
    @ResponseBody
    public ResultMsg modifyTable00(底栖生物密度 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s底栖生物密度Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录01
     * @param record
     * @return
     */
    @RequestMapping("insertTable01")
    @ResponseBody
    public ResultMsg insertTable00(底栖生物密度 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s底栖生物密度Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *修改记录02
     * @param record
     * @return
     */
    @RequestMapping("modifyTable02")
    @ResponseBody
    public ResultMsg modifyTable02(底栖生物生物量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s底栖生物生物量Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录02
     * @param record
     * @return
     */
    @RequestMapping("insertTable02")
    @ResponseBody
    public ResultMsg insertTable02(底栖生物生物量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s底栖生物生物量Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *修改记录10
     * @param record
     * @return
     */
    @RequestMapping("modifyTable10")
    @ResponseBody
    public ResultMsg modifyTable10(水生密度浮游动物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生密度浮游动物Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录10
     * @param record
     * @return
     */
    @RequestMapping("insertTable10")
    @ResponseBody
    public ResultMsg insertTable10(水生密度浮游动物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生密度浮游动物Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *修改记录11
     * @param record
     * @return
     */
    @RequestMapping("modifyTable11")
    @ResponseBody
    public ResultMsg modifyTable11(水生密度轮虫 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生密度轮虫Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录11
     * @param record
     * @return
     */
    @RequestMapping("insertTable11")
    @ResponseBody
    public ResultMsg insertTable11(水生密度轮虫 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生密度轮虫Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *修改记录12
     * @param record
     * @return
     */
    @RequestMapping("modifyTable12")
    @ResponseBody
    public ResultMsg modifyTable11(水生密度密度 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生密度密度Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录12
     * @param record
     * @return
     */
    @RequestMapping("insertTable12")
    @ResponseBody
    public ResultMsg insertTable11(水生密度密度 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生密度密度Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *修改记录13
     * @param record
     * @return
     */
    @RequestMapping("modifyTable13")
    @ResponseBody
    public ResultMsg modifyTable13(水生密度桡足类 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生密度桡足类Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录13
     * @param record
     * @return
     */
    @RequestMapping("insertTable13")
    @ResponseBody
    public ResultMsg insertTable13(水生密度桡足类 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生密度桡足类Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *修改记录14
     * @param record
     * @return
     */
    @RequestMapping("modifyTable14")
    @ResponseBody
    public ResultMsg modifyTable14(水生密度原生动物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生密度原生动物Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录14
     * @param record
     * @return
     */
    @RequestMapping("insertTable14")
    @ResponseBody
    public ResultMsg insertTable14(水生密度原生动物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生密度原生动物Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    @RequestMapping("modifyTable20")
    @ResponseBody
    public ResultMsg modifyTable20(水生多样性生物量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生多样性生物量Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录20
     * @param record
     * @return
     */
    @RequestMapping("insertTable20")
    @ResponseBody
    public ResultMsg insertTable20(水生多样性生物量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生多样性生物量Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }



    @RequestMapping("modifyTable21")
    @ResponseBody
    public ResultMsg modifyTable21(水生多样性轮虫 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生多样性轮虫Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录21
     * @param record
     * @return
     */
    @RequestMapping("insertTable21")
    @ResponseBody
    public ResultMsg insertTable21(水生多样性轮虫 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生多样性轮虫Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable22")
    @ResponseBody
    public ResultMsg modifyTable22(水生多样性数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生多样性数据总表Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录22
     * @param record
     * @return
     */
    @RequestMapping("insertTable22")
    @ResponseBody
    public ResultMsg insertTable22(水生多样性数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生多样性数据总表Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }



    @RequestMapping("modifyTable23")
    @ResponseBody
    public ResultMsg modifyTable23(水生多样性足类 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生多样性足类Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录23
     * @param record
     * @return
     */
    @RequestMapping("insertTable23")
    @ResponseBody
    public ResultMsg insertTable23(水生多样性足类 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生多样性足类Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable24")
    @ResponseBody
    public ResultMsg modifyTable24(水生多样性原生动物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生多样性原生动物Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录24
     * @param record
     * @return
     */
    @RequestMapping("insertTable24")
    @ResponseBody
    public ResultMsg insertTable24(水生多样性原生动物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生多样性原生动物Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable25")
    @ResponseBody
    public ResultMsg modifyTable25(水生多样性枝角类 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生多样性枝角类Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录25
     * @param record
     * @return
     */
    @RequestMapping("insertTable25")
    @ResponseBody
    public ResultMsg insertTable25(水生多样性枝角类 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生多样性枝角类Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }



    @RequestMapping("modifyTable30")
    @ResponseBody
    public ResultMsg modifyTable30(水生相关性浮游植物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性浮游植物Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录30
     * @param record
     * @return
     */
    @RequestMapping("insertTable30")
    @ResponseBody
    public ResultMsg insertTable30(水生相关性浮游植物 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性浮游植物Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable31")
    @ResponseBody
    public ResultMsg modifyTable31(水生相关性硅藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性硅藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录31
     * @param record
     * @return
     */
    @RequestMapping("insertTable31")
    @ResponseBody
    public ResultMsg insertTable31(水生相关性硅藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性硅藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    @RequestMapping("modifyTable32")
    @ResponseBody
    public ResultMsg modifyTable32(水生相关性甲藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性甲藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录32
     * @param record
     * @return
     */
    @RequestMapping("insertTable32")
    @ResponseBody
    public ResultMsg insertTable32(水生相关性甲藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性甲藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable33")
    @ResponseBody
    public ResultMsg modifyTable33(水生相关性金藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性金藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录33
     * @param record
     * @return
     */
    @RequestMapping("insertTable33")
    @ResponseBody
    public ResultMsg insertTable33(水生相关性金藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性金藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable34")
    @ResponseBody
    public ResultMsg modifyTable34(水生相关性蓝藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性蓝藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录34
     * @param record
     * @return
     */
    @RequestMapping("insertTable34")
    @ResponseBody
    public ResultMsg insertTable34(水生相关性蓝藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性蓝藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    @RequestMapping("modifyTable35")
    @ResponseBody
    public ResultMsg modifyTable35(水生相关性裸藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性裸藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录35
     * @param record
     * @return
     */
    @RequestMapping("insertTable35")
    @ResponseBody
    public ResultMsg insertTable35(水生相关性裸藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性裸藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    @RequestMapping("modifyTable36")
    @ResponseBody
    public ResultMsg modifyTable36(水生相关性绿藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性绿藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录36
     * @param record
     * @return
     */
    @RequestMapping("insertTable36")
    @ResponseBody
    public ResultMsg insertTable36(水生相关性绿藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性绿藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable37")
    @ResponseBody
    public ResultMsg modifyTable37(水生相关性隐藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性隐藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录37
     * @param record
     * @return
     */
    @RequestMapping("insertTable37")
    @ResponseBody
    public ResultMsg insertTable37(水生相关性隐藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性隐藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable38")
    @ResponseBody
    public ResultMsg modifyTable38(水生相关性生物量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性生物量Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录38
     * @param record
     * @return
     */
    @RequestMapping("insertTable38")
    @ResponseBody
    public ResultMsg insertTable38(水生相关性生物量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性生物量Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable39")
    @ResponseBody
    public ResultMsg modifyTable39(水生相关性数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生相关性数据总表Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录39
     * @param record
     * @return
     */
    @RequestMapping("insertTable39")
    @ResponseBody
    public ResultMsg insertTable39(水生相关性数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生相关性数据总表Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable40")
    @ResponseBody
    public ResultMsg modifyTable40(水生细密细胞密度 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密细胞密度Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录40
     * @param record
     * @return
     */
    @RequestMapping("insertTable40")
    @ResponseBody
    public ResultMsg insertTable40(水生细密细胞密度 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密细胞密度Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable41")
    @ResponseBody
    public ResultMsg modifyTable41(水生细密硅藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密硅藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录41
     * @param record
     * @return
     */
    @RequestMapping("insertTable41")
    @ResponseBody
    public ResultMsg insertTable41(水生细密硅藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密硅藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable42")
    @ResponseBody
    public ResultMsg modifyTable42(水生细密甲藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密甲藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录42
     * @param record
     * @return
     */
    @RequestMapping("insertTable42")
    @ResponseBody
    public ResultMsg insertTable42(水生细密甲藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密甲藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable43")
    @ResponseBody
    public ResultMsg modifyTable43(水生细密金藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密金藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录43
     * @param record
     * @return
     */
    @RequestMapping("insertTable43")
    @ResponseBody
    public ResultMsg insertTable43(水生细密金藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密金藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable44")
    @ResponseBody
    public ResultMsg modifyTable44(水生细密蓝藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密蓝藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录44
     * @param record
     * @return
     */
    @RequestMapping("insertTable44")
    @ResponseBody
    public ResultMsg insertTable44(水生细密蓝藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密蓝藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable45")
    @ResponseBody
    public ResultMsg modifyTable45(水生细密裸藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密裸藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录45
     * @param record
     * @return
     */
    @RequestMapping("insertTable45")
    @ResponseBody
    public ResultMsg insertTable45(水生细密裸藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密裸藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable46")
    @ResponseBody
    public ResultMsg modifyTable46(水生细密绿藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密绿藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录46
     * @param record
     * @return
     */
    @RequestMapping("insertTable46")
    @ResponseBody
    public ResultMsg insertTable46(水生细密绿藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密绿藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable47")
    @ResponseBody
    public ResultMsg modifyTable47(水生细密隐藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水生细密隐藻门Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录47
     * @param record
     * @return
     */
    @RequestMapping("insertTable47")
    @ResponseBody
    public ResultMsg insertTable47(水生细密隐藻门 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水生细密隐藻门Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable50")
    @ResponseBody
    public ResultMsg modifyTable50(生物群落201809archaea record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s生物群落201809archaeaService.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录50
     * @param record
     * @return
     */
    @RequestMapping("insertTable50")
    @ResponseBody
    public ResultMsg insertTable50(生物群落201809archaea record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s生物群落201809archaeaService.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable51")
    @ResponseBody
    public ResultMsg modifyTable51(生物群落201809bacteria record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s生物群落201809bacteriaService.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录51
     * @param record
     * @return
     */
    @RequestMapping("insertTable51")
    @ResponseBody
    public ResultMsg insertTable51(生物群落201809bacteria record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s生物群落201809bacteriaService.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable52")
    @ResponseBody
    public ResultMsg modifyTable52(生物群落201809数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s生物群落201809数据总表Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录52
     * @param record
     * @return
     */
    @RequestMapping("insertTable52")
    @ResponseBody
    public ResultMsg insertTable52(生物群落201809数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s生物群落201809数据总表Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable60")
    @ResponseBody
    public ResultMsg modifyTable60(生物群落201809archaea record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s生物群落201809archaeaService.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录60
     * @param record
     * @return
     */
    @RequestMapping("insertTable60")
    @ResponseBody
    public ResultMsg insertTable60(生物群落201809archaea record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s生物群落201809archaeaService.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable70")
    @ResponseBody
    public ResultMsg modifyTable70(水质监测201809磺胺类抗生素的含量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水质监测201809磺胺类抗生素的含量Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录70
     * @param record
     * @return
     */
    @RequestMapping("insertTable70")
    @ResponseBody
    public ResultMsg insertTable70(水质监测201809磺胺类抗生素的含量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水质监测201809磺胺类抗生素的含量Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable71")
    @ResponseBody
    public ResultMsg modifyTable71(水质监测201809数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水质监测201809数据总表Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录71
     * @param record
     * @return
     */
    @RequestMapping("insertTable71")
    @ResponseBody
    public ResultMsg insertTable71(水质监测201809数据总表 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水质监测201809数据总表Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable72")
    @ResponseBody
    public ResultMsg modifyTable72(水质监测201809新型烟碱类农药含量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水质监测201809新型烟碱类农药含量Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录72
     * @param record
     * @return
     */
    @RequestMapping("insertTable72")
    @ResponseBody
    public ResultMsg insertTable72(水质监测201809新型烟碱类农药含量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水质监测201809新型烟碱类农药含量Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }


    @RequestMapping("modifyTable73")
    @ResponseBody
    public ResultMsg modifyTable73(水质监测201809有机磷酸酯的含量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean result=s水质监测201809有机磷酸酯的含量Service.updateRow(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     *增加记录73
     * @param record
     * @return
     */
    @RequestMapping("insertTable73")
    @ResponseBody
    public ResultMsg insertTable73(水质监测201809有机磷酸酯的含量 record) {
        ResultMsg  resultMsg=new ResultMsg();
        boolean  result=s水质监测201809有机磷酸酯的含量Service.insert(record);
        resultMsg.setStatus(1);
        resultMsg.setData(result);
        return resultMsg;
    }

    @RequestMapping("getArea")
    @ResponseBody
    public ResultMsg getArea(int oneMenuIndex) {
        ResultMsg resultMsg=new ResultMsg();
        Result result=new Result();
        if (oneMenuIndex==0)
            result=s底栖生物地址Service.get底栖生物地址Info();
        if (oneMenuIndex==1)
            result=s浮游动物多样性地址Service.get浮游动物多样性地址Info();
        if (oneMenuIndex==2)
            result=s浮游动物密度地址Service.get浮游动物密度地址Info();
        if (oneMenuIndex==3)
            result=s浮游植物相关性地址Service.get浮游植物相关性地址Info();
        if (oneMenuIndex==4)
            result=s浮游植物细密地址Service.get浮游植物细密地址Info();
        if (oneMenuIndex==5)
            result=s生物群落地址Service.get生物群落地址Info();
        if (oneMenuIndex==6)
            result=s底泥地址Service.get底泥地址Info();
        if (oneMenuIndex==7)
            result=s水质监测地址Service.get水质监测地址Info();

        resultMsg.setData(result);
        return resultMsg;
    }

    /**
     * 绘制图表
     * @param oneMenuIndex
     * @param twoMenuIndex
     * @param col
     * @param place
     * @return
     */
    @RequestMapping("reportMenu")
    @ResponseBody
    public ResultMsg reportMenu(int oneMenuIndex,int twoMenuIndex,int col,String place) {
        ResultMsg resultMsg=new ResultMsg();
        Result result=new Result();


        if(oneMenuIndex == 0){

            if(twoMenuIndex == 0){
                result = s底栖生物密度Service.get底栖生物密度Report(place,col);
            }
            if(twoMenuIndex == 1){
                result = s底栖生物生物量Service.get底栖生物生物量Report(place,col);
            }
        }
        if(oneMenuIndex == 1){

            if(twoMenuIndex == 0){
                result = s水生密度轮虫Service.get水生密度轮虫Report(place,col);
            }
            if(twoMenuIndex == 1){
                result = s水生密度密度Service.get水生密度密度Report(place,col);
            }
            if(twoMenuIndex == 2){
                result = s水生密度桡足类Service.get水生密度桡足类Report(place,col);
            }
            if(twoMenuIndex == 3){
                result = s水生密度原生动物Service.get水生密度原生动物Report(place,col);
            }
        }
        if(oneMenuIndex == 2){
            if(twoMenuIndex == 0){
                result = s水生多样性生物量Service.get水生多样性生物量Report(place,col);
            }
            if(twoMenuIndex == 1){
                result = s水生多样性轮虫Service.get水生多样性轮虫Report(place,col);
            }
            if(twoMenuIndex == 2){
                result = s水生多样性数据总表Service.get水生多样性数据总表Report(place,col);
            }
            if(twoMenuIndex == 3){
                result = s水生多样性足类Service.get水生多样性足类Report(place,col);
            }
            if(twoMenuIndex == 4){
                result = s水生多样性原生动物Service.get水生多样性原生动物Report(place,col);
            }
            if(twoMenuIndex == 5){
                result = s水生多样性枝角类Service.get水生多样性枝角类Report(place,col);
            }
        }
        if(oneMenuIndex == 3){


            if(twoMenuIndex == 0){
                result = s水生相关性硅藻门Service.get水生相关性硅藻门Report(place,col);
            }
            if(twoMenuIndex == 1){
                result = s水生相关性甲藻门Service.get水生相关性甲藻门Report(place,col);
            }
            if(twoMenuIndex == 2){
                result = s水生相关性金藻门Service.get水生相关性金藻门Report(place,col);
            }
            if(twoMenuIndex == 3){
                result = s水生相关性蓝藻门Service.get水生相关性蓝藻门Report(place,col);
            }
            if(twoMenuIndex == 4){
                result = s水生相关性裸藻门Service.get水生相关性裸藻门Report(place,col);
            }
            if(twoMenuIndex == 5){
                result = s水生相关性绿藻门Service.get水生相关性绿藻门Report(place,col);
            }
            if(twoMenuIndex == 6){
                result = s水生相关性隐藻门Service.get水生相关性隐藻门Report(place,col);
            }
            if(twoMenuIndex == 7){
                result = s水生相关性生物量Service.get水生相关性生物量Report(place,col);
            }
            if(twoMenuIndex == 8){
                result = s水生相关性数据总表Service.get水生相关性数据总表Report(place,col);
            }
        }

        if(oneMenuIndex == 4){
            if(twoMenuIndex == 0){
                result = s水生细密细胞密度Service.get水生细密细胞密度Report(place,col);
            }
            if(twoMenuIndex == 1){
                result = s水生细密硅藻门Service.get水生细密硅藻门Report(place,col);
            }
            if(twoMenuIndex == 2){
                result = s水生细密甲藻门Service.get水生细密甲藻门Report(place,col);
            }
            if(twoMenuIndex == 3){
                result = s水生细密金藻门Service.get水生细密金藻门Report(place,col);
            }
            if(twoMenuIndex == 4){
                result = s水生细密蓝藻门Service.get水生细密蓝藻门Report(place,col);
            }
            if(twoMenuIndex == 5){
                result = s水生细密裸藻门Service.get水生细密裸藻门Report(place,col);
            }
            if(twoMenuIndex == 6){
                result = s水生细密绿藻门Service.get水生细密绿藻门Report(place,col);
            }
            if(twoMenuIndex == 7){
                result = s水生细密隐藻门Service.get水生细密隐藻门Report(place,col);

            }
        }

        if(oneMenuIndex == 5){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaeaReport(place,col);
            }
            if(twoMenuIndex == 1){
                result = s生物群落201809bacteriaService.get生物群落201809bacteriaReport(place,col);
            }
            if(twoMenuIndex == 2){
                result = s生物群落201809数据总表Service.get生物群落201809数据总表Report(place,col);

            }
        }


        if(oneMenuIndex == 6){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaeaReport(place,col);

            }
        }


        if(oneMenuIndex == 7){
            if(twoMenuIndex == 0){
                result = s水质监测201809磺胺类抗生素的含量Service.get水质监测201809磺胺类抗生素的含量Report(place,col);
            }
            if(twoMenuIndex == 1){
                result = s水质监测201809数据总表Service.get水质监测201809数据总表Report(place,col);
            }
            if(twoMenuIndex == 2){
                result = s水质监测201809新型烟碱类农药含量Service.get水质监测201809新型烟碱类农药含量Report(place,col);

            }
            if(twoMenuIndex == 3){
                result = s水质监测201809有机磷酸酯的含量Service.get水质监测201809有机磷酸酯的含量Report(place,col);

            }
        }


        resultMsg.setData(result);
        return resultMsg;
    }
    @RequestMapping("staMenu")
    @ResponseBody
    public ResultMsg staMenu(int col,int oneMenuIndex, int twoMenuIndex, @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        ResultMsg resultMsg = new ResultMsg();
        tableCode.FRISTTABLE = oneMenuIndex;
        tableCode.TWOTABLE = twoMenuIndex;
        Result result = new Result();



        if(oneMenuIndex == 0){

            if(twoMenuIndex == 0){
                result = s底栖生物密度Service.get底栖生物密度统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s底栖生物生物量Service.get底栖生物生物量统计Info(col, startDate, endDate);
            }
        }
        if(oneMenuIndex == 1){

            if(twoMenuIndex == 0){
                result = s水生密度轮虫Service.get水生密度轮虫统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生密度密度Service.get水生密度密度统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生密度桡足类Service.get水生密度桡足类统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生密度原生动物Service.get水生密度原生动物统计Info(col, startDate, endDate);
            }
        }
        if(oneMenuIndex == 2){
            if(twoMenuIndex == 0){
                result = s水生多样性生物量Service.get水生多样性生物量统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生多样性轮虫Service.get水生多样性轮虫统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生多样性数据总表Service.get水生多样性数据总表统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生多样性足类Service.get水生多样性足类统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 4){
                result = s水生多样性原生动物Service.get水生多样性原生动物统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 5){
                result = s水生多样性枝角类Service.get水生多样性枝角类统计Info(col, startDate, endDate);
            }
        }
        if(oneMenuIndex == 3){

            if(twoMenuIndex == 0){
                result = s水生相关性硅藻门Service.get水生相关性硅藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生相关性甲藻门Service.get水生相关性甲藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生相关性金藻门Service.get水生相关性金藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生相关性蓝藻门Service.get水生相关性蓝藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 4){
                result = s水生相关性裸藻门Service.get水生相关性裸藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 5){
                result = s水生相关性绿藻门Service.get水生相关性绿藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 6){
                result = s水生相关性隐藻门Service.get水生相关性隐藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 7){
                result = s水生相关性生物量Service.get水生相关性生物量统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 8){
                result = s水生相关性数据总表Service.get水生相关性数据总表统计Info(col, startDate, endDate);
            }
        }

        if(oneMenuIndex == 4){
            if(twoMenuIndex == 0){
                result = s水生细密细胞密度Service.get水生细密细胞密度统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生细密硅藻门Service.get水生细密硅藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生细密甲藻门Service.get水生细密甲藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生细密金藻门Service.get水生细密金藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 4){
                result = s水生细密蓝藻门Service.get水生细密蓝藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 5){
                result = s水生细密裸藻门Service.get水生细密裸藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 6){
                result = s水生细密绿藻门Service.get水生细密绿藻门统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 7){
                result = s水生细密隐藻门Service.get水生细密隐藻门统计Info(col, startDate, endDate);

            }
        }

        if(oneMenuIndex == 5){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaea统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s生物群落201809bacteriaService.get生物群落201809bacteria统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s生物群落201809数据总表Service.get生物群落201809数据总表统计Info(col, startDate, endDate);

            }
        }


        if(oneMenuIndex == 6){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaea统计Info(col, startDate, endDate);

            }
        }


        if(oneMenuIndex == 7){
            if(twoMenuIndex == 0){
                result = s水质监测201809磺胺类抗生素的含量Service.get水质监测201809磺胺类抗生素的含量统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水质监测201809数据总表Service.get水质监测201809数据总表统计Info(col, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水质监测201809新型烟碱类农药含量Service.get水质监测201809新型烟碱类农药含量统计Info(col, startDate, endDate);

            }
            if(twoMenuIndex == 3){
                result = s水质监测201809有机磷酸酯的含量Service.get水质监测201809有机磷酸酯的含量统计Info(col, startDate, endDate);

            }
        }


        resultMsg.setData(result);
        return resultMsg;
    }
    @RequestMapping("staMenu2")
    @ResponseBody
    public ResultMsg staMenu2(String place,int oneMenuIndex, int twoMenuIndex, @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,int pageIndex, int pageSize) {
        ResultMsg resultMsg = new ResultMsg();
        tableCode.FRISTTABLE = oneMenuIndex;
        tableCode.TWOTABLE = twoMenuIndex;
        Result result = new Result();


        if(oneMenuIndex == 0){

            if(twoMenuIndex == 0){
                result = s底栖生物密度Service.get底栖生物密度统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s底栖生物生物量Service.get底栖生物生物量统计Info2(place, startDate, endDate);
            }
        }
        if(oneMenuIndex == 1){

            if(twoMenuIndex == 0){
                result = s水生密度轮虫Service.get水生密度轮虫统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生密度密度Service.get水生密度密度统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生密度桡足类Service.get水生密度桡足类统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生密度原生动物Service.get水生密度原生动物统计Info2(place, startDate, endDate);
            }
        }
        if(oneMenuIndex == 2){
            if(twoMenuIndex == 0){
                result = s水生多样性生物量Service.get水生多样性生物量统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生多样性轮虫Service.get水生多样性轮虫统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生多样性数据总表Service.get水生多样性数据总表统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生多样性足类Service.get水生多样性足类统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 4){
                result = s水生多样性原生动物Service.get水生多样性原生动物统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 5){
                result = s水生多样性枝角类Service.get水生多样性枝角类统计Info2(place, startDate, endDate);
            }
        }
        if(oneMenuIndex == 3){

            if(twoMenuIndex == 0){
                result = s水生相关性硅藻门Service.get水生相关性硅藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生相关性甲藻门Service.get水生相关性甲藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生相关性金藻门Service.get水生相关性金藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生相关性蓝藻门Service.get水生相关性蓝藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 4){
                result = s水生相关性裸藻门Service.get水生相关性裸藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 5){
                result = s水生相关性绿藻门Service.get水生相关性绿藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 6){
                result = s水生相关性隐藻门Service.get水生相关性隐藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 7){
                result = s水生相关性生物量Service.get水生相关性生物量统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 8){
                result = s水生相关性数据总表Service.get水生相关性数据总表统计Info2(place, startDate, endDate);
            }
        }

        if(oneMenuIndex == 4){
            if(twoMenuIndex == 0){
                result = s水生细密细胞密度Service.get水生细密细胞密度统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水生细密硅藻门Service.get水生细密硅藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水生细密甲藻门Service.get水生细密甲藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 3){
                result = s水生细密金藻门Service.get水生细密金藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 4){
                result = s水生细密蓝藻门Service.get水生细密蓝藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 5){
                result = s水生细密裸藻门Service.get水生细密裸藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 6){
                result = s水生细密绿藻门Service.get水生细密绿藻门统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 7){
                result = s水生细密隐藻门Service.get水生细密隐藻门统计Info2(place, startDate, endDate);

            }
        }

        if(oneMenuIndex == 5){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaea统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s生物群落201809bacteriaService.get生物群落201809bacteria统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s生物群落201809数据总表Service.get生物群落201809数据总表统计Info2(place, startDate, endDate);

            }
        }


        if(oneMenuIndex == 6){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaea统计Info2(place, startDate, endDate);

            }
        }


        if(oneMenuIndex == 7){
            if(twoMenuIndex == 0){
                result = s水质监测201809磺胺类抗生素的含量Service.get水质监测201809磺胺类抗生素的含量统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 1){
                result = s水质监测201809数据总表Service.get水质监测201809数据总表统计Info2(place, startDate, endDate);
            }
            if(twoMenuIndex == 2){
                result = s水质监测201809新型烟碱类农药含量Service.get水质监测201809新型烟碱类农药含量统计Info2(place, startDate, endDate);

            }
            if(twoMenuIndex == 3){
                result = s水质监测201809有机磷酸酯的含量Service.get水质监测201809有机磷酸酯的含量统计Info2(place, startDate, endDate);

            }
        }



        resultMsg.setData(result);
        return resultMsg;
    }
    @RequestMapping("indexMenus")
    @ResponseBody
    public ResultMsg getColValue(int oneMenuIndex,int twoMenuIndex) {
        ResultMsg resultMsg=new ResultMsg();
        tableCode.FRISTTABLE = oneMenuIndex;
        tableCode.TWOTABLE = twoMenuIndex;
        Result result = new Result();



        if(oneMenuIndex == 0){

            if(twoMenuIndex == 0){
                result = s底栖生物密度Service.getIndex();
            }
            if(twoMenuIndex == 1){
                result = s底栖生物生物量Service.getIndex();
            }
        }
        if(oneMenuIndex == 1){

            if(twoMenuIndex == 0){
                result = s水生密度轮虫Service.getIndex();
            }
            if(twoMenuIndex == 1){
                result = s水生密度密度Service.getIndex();
            }
            if(twoMenuIndex == 2){
                result = s水生密度桡足类Service.getIndex();
            }
            if(twoMenuIndex == 3){
                result = s水生密度原生动物Service.getIndex();
            }
        }
        if(oneMenuIndex == 2){
            if(twoMenuIndex == 0){
                result = s水生多样性生物量Service.getIndex();
            }
            if(twoMenuIndex == 1){
                result = s水生多样性轮虫Service.getIndex();
            }
            if(twoMenuIndex == 2){
                result = s水生多样性数据总表Service.getIndex();
        }
            if(twoMenuIndex == 3){
                result = s水生多样性足类Service.getIndex();
            }
            if(twoMenuIndex == 4){
                result = s水生多样性原生动物Service.getIndex();
            }
            if(twoMenuIndex == 5){
                result = s水生多样性枝角类Service.getIndex();
            }
        }
        if(oneMenuIndex == 3){

            if(twoMenuIndex == 1){
                result = s水生相关性硅藻门Service.getIndex();
            }
            if(twoMenuIndex == 2){
                result = s水生相关性甲藻门Service.getIndex();
            }
            if(twoMenuIndex == 3){
                result = s水生相关性金藻门Service.getIndex();
            }
            if(twoMenuIndex == 4){
                result = s水生相关性蓝藻门Service.getIndex();
            }
            if(twoMenuIndex == 5){
                result = s水生相关性裸藻门Service.getIndex();
            }
            if(twoMenuIndex == 6){
                result = s水生相关性绿藻门Service.getIndex();
            }
            if(twoMenuIndex == 7){
                result = s水生相关性隐藻门Service.getIndex();
            }
            if(twoMenuIndex == 8){
                result = s水生相关性生物量Service.getIndex();
            }
            if(twoMenuIndex == 9){
                result = s水生相关性数据总表Service.getIndex();
            }
        }

        if(oneMenuIndex == 4){
            if(twoMenuIndex == 0){
                result = s水生细密细胞密度Service.getIndex();
            }
            if(twoMenuIndex == 1){
                result = s水生细密硅藻门Service.getIndex();
            }
            if(twoMenuIndex == 2){
                result = s水生细密甲藻门Service.getIndex();
            }
            if(twoMenuIndex == 3){
                result = s水生细密金藻门Service.getIndex();
            }
            if(twoMenuIndex == 4){
                result = s水生细密蓝藻门Service.getIndex();
            }
            if(twoMenuIndex == 5){
                result = s水生细密裸藻门Service.getIndex();
            }
            if(twoMenuIndex == 6){
                result = s水生细密绿藻门Service.getIndex();
            }
            if(twoMenuIndex == 7){
                result = s水生细密隐藻门Service.getIndex();

            }
        }

        if(oneMenuIndex == 5){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.getIndex();
            }
            if(twoMenuIndex == 1){
                result = s生物群落201809bacteriaService.getIndex();
            }
            if(twoMenuIndex == 2){
                result = s生物群落201809数据总表Service.getIndex();

            }
        }


        if(oneMenuIndex == 6){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.getIndex();

            }
        }


        if(oneMenuIndex == 7){
            if(twoMenuIndex == 0){
                result = s水质监测201809磺胺类抗生素的含量Service.getIndex();
            }
            if(twoMenuIndex == 1){
                result = s水质监测201809数据总表Service.getIndex();
            }
            if(twoMenuIndex == 2){
                result = s水质监测201809新型烟碱类农药含量Service.getIndex();

            }
            if(twoMenuIndex == 3){
                result = s水质监测201809有机磷酸酯的含量Service.getIndex();

            }
        }


        resultMsg.setData(result);
        return resultMsg;
    }
    @RequestMapping("oneMenus")
    @ResponseBody
    public ResultMsg getOneMenus(int oneMenuIndex, int twoMenuIndex, @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,int pageIndex, int pageSize){

        ResultMsg resultMsg = new ResultMsg();
        tableCode.FRISTTABLE = oneMenuIndex;
        tableCode.TWOTABLE = twoMenuIndex;
        Result result = new Result();
//        try {
            if(oneMenuIndex == 0){
                        if(twoMenuIndex == 0){
                            result = s底栖生物Service.get底栖生物Info(startDate,endDate,pageIndex,pageSize);
                        }
                        if(twoMenuIndex == 1){
                            result = s底栖生物密度Service.get底栖生物密度Info(startDate,endDate,pageIndex,pageSize);
                        }
                        if(twoMenuIndex == 2){
                            result = s底栖生物生物量Service.get底栖生物生物量Info(startDate,endDate,pageIndex,pageSize);
                        }
                    }
                    if(oneMenuIndex == 1){
                        if(twoMenuIndex == 0){
                            result = s水生密度浮游动物Service.get水生密度浮游动物Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 1){
                    result = s水生密度轮虫Service.get水生密度轮虫Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 2){
                    result = s水生密度密度Service.get水生密度密度Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 3){
                    result = s水生密度桡足类Service.get水生密度桡足类Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 2){
                    result = s水生密度原生动物Service.get水生密度原生动物Info(startDate,endDate,pageIndex,pageSize);
                }
            }
            if(oneMenuIndex == 2){
                if(twoMenuIndex == 0){
                    result = s水生多样性生物量Service.get水生多样性生物量Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 1){
                    result = s水生多样性轮虫Service.get水生多样性轮虫Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 2){
                    result = s水生多样性数据总表Service.get水生多样性数据总表Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 3){
                    result = s水生多样性足类Service.get水生多样性足类Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 4){
                    result = s水生多样性原生动物Service.get水生多样性原生动物Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 5){
                    result = s水生多样性枝角类Service.get水生多样性枝角类Info(startDate,endDate,pageIndex,pageSize);
                }
            }
            if(oneMenuIndex == 3){
                if(twoMenuIndex == 0){
                    result = s水生相关性浮游植物Service.get水生相关性浮游植物Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 1){
                    result = s水生相关性硅藻门Service.get水生相关性硅藻门Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 2){
                    result = s水生相关性甲藻门Service.get水生相关性甲藻门Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 3){
                    result = s水生相关性蓝藻门Service.get水生相关性蓝藻门Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 4){
                    result = s水生相关性裸藻门Service.get水生相关性裸藻门Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 5){
                    result = s水生相关性绿藻门Service.get水生相关性绿藻门Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 6){
                    result = s水生相关性隐藻门Service.get水生相关性隐藻门Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 7){
                    result = s水生相关性生物量Service.get水生相关性生物量Info(startDate,endDate,pageIndex,pageSize);
                }
                if(twoMenuIndex == 8){
                    result = s水生相关性数据总表Service.get水生相关性数据总表Info(startDate,endDate,pageIndex,pageSize);
                }
            }

        if(oneMenuIndex == 4){
            if(twoMenuIndex == 0){
                result = s水生细密细胞密度Service.get水生细密细胞密度Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 1){
                result =s水生细密硅藻门Service.get水生细密硅藻门Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 2){
                result = s水生细密甲藻门Service.get水生细密甲藻门Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 3){
                result = s水生细密金藻门Service.get水生细密金藻门Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 4){
                result = s水生细密蓝藻门Service.get水生细密蓝藻门Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 5){
                result = s水生细密裸藻门Service.get水生细密裸藻门Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 6){
                result = s水生细密绿藻门Service.get水生细密绿藻门Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 7){
                result = s水生细密隐藻门Service.get水生细密隐藻门Info(startDate,endDate,pageIndex,pageSize);
            }
        }
        if(oneMenuIndex == 5){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaeaInfo(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 1){
                result = s生物群落201809bacteriaService.get生物群落201809bacteriaInfo(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 2){
                result = s生物群落201809数据总表Service.get生物群落201809数据总表Info(startDate,endDate,pageIndex,pageSize);
            }
        }
        if(oneMenuIndex == 6){
            if(twoMenuIndex == 0){
                result = s生物群落201809archaeaService.get生物群落201809archaeaInfo(startDate,endDate,pageIndex,pageSize);
            }

        }
        if(oneMenuIndex == 7){
            if(twoMenuIndex == 0){
                result = s水质监测201809磺胺类抗生素的含量Service.get水质监测201809磺胺类抗生素的含量Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 1){
                result = s水质监测201809数据总表Service.get水质监测201809数据总表Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 2){
                result = s水质监测201809新型烟碱类农药含量Service.get水质监测201809新型烟碱类农药含量Info(startDate,endDate,pageIndex,pageSize);
            }
            if(twoMenuIndex == 3){
                result = s水质监测201809有机磷酸酯的含量Service.get水质监测201809有机磷酸酯的含量Info(startDate,endDate,pageIndex,pageSize);
            }
        }

            resultMsg.setData(result);
//        }catch (Exception e){
//            resultMsg.setData(false);
//            resultMsg.setStatus(ResultStatusCode.FAIL);
//        }

        return  resultMsg;
    }


}

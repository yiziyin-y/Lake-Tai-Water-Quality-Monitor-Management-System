package com.glyk.heos.dal.dao;

import com.glyk.heos.dal.dao.生物群落201809bacteria;
import com.glyk.heos.dal.dao.生物群落201809bacteriaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface 生物群落201809bacteriaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    long countByExample(生物群落201809bacteriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int deleteByExample(生物群落201809bacteriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int insert(生物群落201809bacteria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int insertSelective(生物群落201809bacteria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    List<生物群落201809bacteria> selectByExample(生物群落201809bacteriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    生物群落201809bacteria selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") 生物群落201809bacteria record, @Param("example") 生物群落201809bacteriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") 生物群落201809bacteria record, @Param("example") 生物群落201809bacteriaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(生物群落201809bacteria record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物群落201809bacteria
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(生物群落201809bacteria record);
}
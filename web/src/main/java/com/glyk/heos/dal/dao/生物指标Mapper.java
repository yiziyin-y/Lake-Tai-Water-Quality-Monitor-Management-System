package com.glyk.heos.dal.dao;

import com.glyk.heos.dal.dao.生物指标;
import com.glyk.heos.dal.dao.生物指标Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface 生物指标Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物指标
     *
     * @mbg.generated
     */
    long countByExample(生物指标Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物指标
     *
     * @mbg.generated
     */
    int deleteByExample(生物指标Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物指标
     *
     * @mbg.generated
     */
    int insert(生物指标 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物指标
     *
     * @mbg.generated
     */
    int insertSelective(生物指标 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物指标
     *
     * @mbg.generated
     */
    List<生物指标> selectByExample(生物指标Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物指标
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") 生物指标 record, @Param("example") 生物指标Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table 生物指标
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") 生物指标 record, @Param("example") 生物指标Example example);
}
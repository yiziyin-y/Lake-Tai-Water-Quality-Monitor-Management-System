package com.glyk.heos.dal.dao;

public class 底栖生物 {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 底栖生物.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 底栖生物.中文名
     *
     * @mbg.generated
     */
    private String 中文名;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 底栖生物.拉丁文名
     *
     * @mbg.generated
     */
    private String 拉丁文名;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 底栖生物.ID
     *
     * @return the value of 底栖生物.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 底栖生物.ID
     *
     * @param id the value for 底栖生物.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 底栖生物.中文名
     *
     * @return the value of 底栖生物.中文名
     *
     * @mbg.generated
     */
    public String get中文名() {
        return 中文名;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 底栖生物.中文名
     *
     * @param 中文名 the value for 底栖生物.中文名
     *
     * @mbg.generated
     */
    public void set中文名(String 中文名) {
        this.中文名 = 中文名 == null ? null : 中文名.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 底栖生物.拉丁文名
     *
     * @return the value of 底栖生物.拉丁文名
     *
     * @mbg.generated
     */
    public String get拉丁文名() {
        return 拉丁文名;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 底栖生物.拉丁文名
     *
     * @param 拉丁文名 the value for 底栖生物.拉丁文名
     *
     * @mbg.generated
     */
    public void set拉丁文名(String 拉丁文名) {
        this.拉丁文名 = 拉丁文名 == null ? null : 拉丁文名.trim();
    }
}
package com.glyk.heos.dal.dao;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.pwd
     *
     * @mbg.generated
     */
    private String pwd;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.ID
     *
     * @return the value of student.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.ID
     *
     * @param id the value for student.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.name
     *
     * @return the value of student.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.name
     *
     * @param name the value for student.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.pwd
     *
     * @return the value of student.pwd
     *
     * @mbg.generated
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.pwd
     *
     * @param pwd the value for student.pwd
     *
     * @mbg.generated
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}
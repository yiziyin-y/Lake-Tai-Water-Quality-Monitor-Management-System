package com.glyk.heos.dal.dao;

public class Usertable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertable.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertable.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertable.pwd
     *
     * @mbg.generated
     */
    private String pwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertable.role
     *
     * @mbg.generated
     */
    private Integer role;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertable.id
     *
     * @return the value of usertable.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertable.id
     *
     * @param id the value for usertable.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertable.name
     *
     * @return the value of usertable.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertable.name
     *
     * @param name the value for usertable.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertable.pwd
     *
     * @return the value of usertable.pwd
     *
     * @mbg.generated
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertable.pwd
     *
     * @param pwd the value for usertable.pwd
     *
     * @mbg.generated
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertable.role
     *
     * @return the value of usertable.role
     *
     * @mbg.generated
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertable.role
     *
     * @param role the value for usertable.role
     *
     * @mbg.generated
     */
    public void setRole(Integer role) {
        this.role = role;
    }
}
package com.glyk.heos.dal.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class 水生相关性裸藻门 {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.编号
     *
     * @mbg.generated
     */
    private String 编号;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.采样点位
     *
     * @mbg.generated
     */
    private String 采样点位;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.日期
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date 日期;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.裸藻
     *
     * @mbg.generated
     */
    private String 裸藻;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.绿色裸藻
     *
     * @mbg.generated
     */
    private String 绿色裸藻;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.尖尾裸藻
     *
     * @mbg.generated
     */
    private String 尖尾裸藻;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.囊裸藻
     *
     * @mbg.generated
     */
    private String 囊裸藻;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.扁裸藻
     *
     * @mbg.generated
     */
    private String 扁裸藻;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 水生相关性裸藻门.尾裸藻
     *
     * @mbg.generated
     */
    private String 尾裸藻;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.ID
     *
     * @return the value of 水生相关性裸藻门.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.ID
     *
     * @param id the value for 水生相关性裸藻门.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.编号
     *
     * @return the value of 水生相关性裸藻门.编号
     *
     * @mbg.generated
     */
    public String get编号() {
        return 编号;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.编号
     *
     * @param 编号 the value for 水生相关性裸藻门.编号
     *
     * @mbg.generated
     */
    public void set编号(String 编号) {
        this.编号 = 编号 == null ? null : 编号.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.采样点位
     *
     * @return the value of 水生相关性裸藻门.采样点位
     *
     * @mbg.generated
     */
    public String get采样点位() {
        return 采样点位;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.采样点位
     *
     * @param 采样点位 the value for 水生相关性裸藻门.采样点位
     *
     * @mbg.generated
     */
    public void set采样点位(String 采样点位) {
        this.采样点位 = 采样点位 == null ? null : 采样点位.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.日期
     *
     * @return the value of 水生相关性裸藻门.日期
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    public Date get日期() {
        return 日期;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.日期
     *
     * @param 日期 the value for 水生相关性裸藻门.日期
     *
     * @mbg.generated
     */
    public void set日期(Date 日期) {
        this.日期 = 日期;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.裸藻
     *
     * @return the value of 水生相关性裸藻门.裸藻
     *
     * @mbg.generated
     */
    public String get裸藻() {
        return 裸藻;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.裸藻
     *
     * @param 裸藻 the value for 水生相关性裸藻门.裸藻
     *
     * @mbg.generated
     */
    public void set裸藻(String 裸藻) {
        this.裸藻 = 裸藻 == null ? null : 裸藻.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.绿色裸藻
     *
     * @return the value of 水生相关性裸藻门.绿色裸藻
     *
     * @mbg.generated
     */
    public String get绿色裸藻() {
        return 绿色裸藻;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.绿色裸藻
     *
     * @param 绿色裸藻 the value for 水生相关性裸藻门.绿色裸藻
     *
     * @mbg.generated
     */
    public void set绿色裸藻(String 绿色裸藻) {
        this.绿色裸藻 = 绿色裸藻 == null ? null : 绿色裸藻.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.尖尾裸藻
     *
     * @return the value of 水生相关性裸藻门.尖尾裸藻
     *
     * @mbg.generated
     */
    public String get尖尾裸藻() {
        return 尖尾裸藻;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.尖尾裸藻
     *
     * @param 尖尾裸藻 the value for 水生相关性裸藻门.尖尾裸藻
     *
     * @mbg.generated
     */
    public void set尖尾裸藻(String 尖尾裸藻) {
        this.尖尾裸藻 = 尖尾裸藻 == null ? null : 尖尾裸藻.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.囊裸藻
     *
     * @return the value of 水生相关性裸藻门.囊裸藻
     *
     * @mbg.generated
     */
    public String get囊裸藻() {
        return 囊裸藻;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.囊裸藻
     *
     * @param 囊裸藻 the value for 水生相关性裸藻门.囊裸藻
     *
     * @mbg.generated
     */
    public void set囊裸藻(String 囊裸藻) {
        this.囊裸藻 = 囊裸藻 == null ? null : 囊裸藻.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.扁裸藻
     *
     * @return the value of 水生相关性裸藻门.扁裸藻
     *
     * @mbg.generated
     */
    public String get扁裸藻() {
        return 扁裸藻;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.扁裸藻
     *
     * @param 扁裸藻 the value for 水生相关性裸藻门.扁裸藻
     *
     * @mbg.generated
     */
    public void set扁裸藻(String 扁裸藻) {
        this.扁裸藻 = 扁裸藻 == null ? null : 扁裸藻.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 水生相关性裸藻门.尾裸藻
     *
     * @return the value of 水生相关性裸藻门.尾裸藻
     *
     * @mbg.generated
     */
    public String get尾裸藻() {
        return 尾裸藻;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 水生相关性裸藻门.尾裸藻
     *
     * @param 尾裸藻 the value for 水生相关性裸藻门.尾裸藻
     *
     * @mbg.generated
     */
    public void set尾裸藻(String 尾裸藻) {
        this.尾裸藻 = 尾裸藻 == null ? null : 尾裸藻.trim();
    }
}
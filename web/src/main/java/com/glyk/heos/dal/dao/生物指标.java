package com.glyk.heos.dal.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class 生物指标 {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.编号
     *
     * @mbg.generated
     */
    private String 编号;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.采样点
     *
     * @mbg.generated
     */
    private String 采样点;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.日期
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private String 日期;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.弱吸附态磷
     *
     * @mbg.generated
     */
    private String 弱吸附态磷;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.铁结合态磷数量Fe_P
     *
     * @mbg.generated
     */
    private String 铁结合态磷数量feP;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.铝结合态磷Al_P
     *
     * @mbg.generated
     */
    private String 铝结合态磷alP;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.有机磷数量Org_P
     *
     * @mbg.generated
     */
    private String 有机磷数量orgP;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.钙结合态磷Ca_P
     *
     * @mbg.generated
     */
    private String 钙结合态磷caP;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.残渣磷Res_P
     *
     * @mbg.generated
     */
    private String 残渣磷resP;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.铜
     *
     * @mbg.generated
     */
    private String 铜;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.锌
     *
     * @mbg.generated
     */
    private String 锌;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.镍
     *
     * @mbg.generated
     */
    private String 镍;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.铅
     *
     * @mbg.generated
     */
    private String 铅;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.含水率
     *
     * @mbg.generated
     */
    private String 含水率;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.有机质LOI
     *
     * @mbg.generated
     */
    private String 有机质loi;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.间隙水P
     *
     * @mbg.generated
     */
    private String 间隙水p;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column 生物指标.间隙水Fe
     *
     * @mbg.generated
     */
    private String 间隙水fe;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.ID
     *
     * @return the value of 生物指标.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.ID
     *
     * @param id the value for 生物指标.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.编号
     *
     * @return the value of 生物指标.编号
     *
     * @mbg.generated
     */
    public String get编号() {
        return 编号;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.编号
     *
     * @param 编号 the value for 生物指标.编号
     *
     * @mbg.generated
     */
    public void set编号(String 编号) {
        this.编号 = 编号 == null ? null : 编号.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.采样点
     *
     * @return the value of 生物指标.采样点
     *
     * @mbg.generated
     */
    public String get采样点() {
        return 采样点;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.采样点
     *
     * @param 采样点 the value for 生物指标.采样点
     *
     * @mbg.generated
     */
    public void set采样点(String 采样点) {
        this.采样点 = 采样点 == null ? null : 采样点.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.日期
     *
     * @return the value of 生物指标.日期
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    public String get日期() {
        return 日期;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.日期
     *
     * @param 日期 the value for 生物指标.日期
     *
     * @mbg.generated
     */
    public void set日期(String 日期) {
        this.日期 = 日期 == null ? null : 日期.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.弱吸附态磷
     *
     * @return the value of 生物指标.弱吸附态磷
     *
     * @mbg.generated
     */
    public String get弱吸附态磷() {
        return 弱吸附态磷;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.弱吸附态磷
     *
     * @param 弱吸附态磷 the value for 生物指标.弱吸附态磷
     *
     * @mbg.generated
     */
    public void set弱吸附态磷(String 弱吸附态磷) {
        this.弱吸附态磷 = 弱吸附态磷 == null ? null : 弱吸附态磷.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.铁结合态磷数量Fe_P
     *
     * @return the value of 生物指标.铁结合态磷数量Fe_P
     *
     * @mbg.generated
     */
    public String get铁结合态磷数量feP() {
        return 铁结合态磷数量feP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.铁结合态磷数量Fe_P
     *
     * @param 铁结合态磷数量feP the value for 生物指标.铁结合态磷数量Fe_P
     *
     * @mbg.generated
     */
    public void set铁结合态磷数量feP(String 铁结合态磷数量feP) {
        this.铁结合态磷数量feP = 铁结合态磷数量feP == null ? null : 铁结合态磷数量feP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.铝结合态磷Al_P
     *
     * @return the value of 生物指标.铝结合态磷Al_P
     *
     * @mbg.generated
     */
    public String get铝结合态磷alP() {
        return 铝结合态磷alP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.铝结合态磷Al_P
     *
     * @param 铝结合态磷alP the value for 生物指标.铝结合态磷Al_P
     *
     * @mbg.generated
     */
    public void set铝结合态磷alP(String 铝结合态磷alP) {
        this.铝结合态磷alP = 铝结合态磷alP == null ? null : 铝结合态磷alP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.有机磷数量Org_P
     *
     * @return the value of 生物指标.有机磷数量Org_P
     *
     * @mbg.generated
     */
    public String get有机磷数量orgP() {
        return 有机磷数量orgP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.有机磷数量Org_P
     *
     * @param 有机磷数量orgP the value for 生物指标.有机磷数量Org_P
     *
     * @mbg.generated
     */
    public void set有机磷数量orgP(String 有机磷数量orgP) {
        this.有机磷数量orgP = 有机磷数量orgP == null ? null : 有机磷数量orgP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.钙结合态磷Ca_P
     *
     * @return the value of 生物指标.钙结合态磷Ca_P
     *
     * @mbg.generated
     */
    public String get钙结合态磷caP() {
        return 钙结合态磷caP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.钙结合态磷Ca_P
     *
     * @param 钙结合态磷caP the value for 生物指标.钙结合态磷Ca_P
     *
     * @mbg.generated
     */
    public void set钙结合态磷caP(String 钙结合态磷caP) {
        this.钙结合态磷caP = 钙结合态磷caP == null ? null : 钙结合态磷caP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.残渣磷Res_P
     *
     * @return the value of 生物指标.残渣磷Res_P
     *
     * @mbg.generated
     */
    public String get残渣磷resP() {
        return 残渣磷resP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.残渣磷Res_P
     *
     * @param 残渣磷resP the value for 生物指标.残渣磷Res_P
     *
     * @mbg.generated
     */
    public void set残渣磷resP(String 残渣磷resP) {
        this.残渣磷resP = 残渣磷resP == null ? null : 残渣磷resP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.铜
     *
     * @return the value of 生物指标.铜
     *
     * @mbg.generated
     */
    public String get铜() {
        return 铜;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.铜
     *
     * @param 铜 the value for 生物指标.铜
     *
     * @mbg.generated
     */
    public void set铜(String 铜) {
        this.铜 = 铜 == null ? null : 铜.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.锌
     *
     * @return the value of 生物指标.锌
     *
     * @mbg.generated
     */
    public String get锌() {
        return 锌;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.锌
     *
     * @param 锌 the value for 生物指标.锌
     *
     * @mbg.generated
     */
    public void set锌(String 锌) {
        this.锌 = 锌 == null ? null : 锌.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.镍
     *
     * @return the value of 生物指标.镍
     *
     * @mbg.generated
     */
    public String get镍() {
        return 镍;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.镍
     *
     * @param 镍 the value for 生物指标.镍
     *
     * @mbg.generated
     */
    public void set镍(String 镍) {
        this.镍 = 镍 == null ? null : 镍.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.铅
     *
     * @return the value of 生物指标.铅
     *
     * @mbg.generated
     */
    public String get铅() {
        return 铅;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.铅
     *
     * @param 铅 the value for 生物指标.铅
     *
     * @mbg.generated
     */
    public void set铅(String 铅) {
        this.铅 = 铅 == null ? null : 铅.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.含水率
     *
     * @return the value of 生物指标.含水率
     *
     * @mbg.generated
     */
    public String get含水率() {
        return 含水率;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.含水率
     *
     * @param 含水率 the value for 生物指标.含水率
     *
     * @mbg.generated
     */
    public void set含水率(String 含水率) {
        this.含水率 = 含水率 == null ? null : 含水率.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.有机质LOI
     *
     * @return the value of 生物指标.有机质LOI
     *
     * @mbg.generated
     */
    public String get有机质loi() {
        return 有机质loi;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.有机质LOI
     *
     * @param 有机质loi the value for 生物指标.有机质LOI
     *
     * @mbg.generated
     */
    public void set有机质loi(String 有机质loi) {
        this.有机质loi = 有机质loi == null ? null : 有机质loi.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.间隙水P
     *
     * @return the value of 生物指标.间隙水P
     *
     * @mbg.generated
     */
    public String get间隙水p() {
        return 间隙水p;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.间隙水P
     *
     * @param 间隙水p the value for 生物指标.间隙水P
     *
     * @mbg.generated
     */
    public void set间隙水p(String 间隙水p) {
        this.间隙水p = 间隙水p == null ? null : 间隙水p.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column 生物指标.间隙水Fe
     *
     * @return the value of 生物指标.间隙水Fe
     *
     * @mbg.generated
     */
    public String get间隙水fe() {
        return 间隙水fe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column 生物指标.间隙水Fe
     *
     * @param 间隙水fe the value for 生物指标.间隙水Fe
     *
     * @mbg.generated
     */
    public void set间隙水fe(String 间隙水fe) {
        this.间隙水fe = 间隙水fe == null ? null : 间隙水fe.trim();
    }
}
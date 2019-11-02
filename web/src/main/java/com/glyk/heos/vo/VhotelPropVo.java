package com.glyk.heos.vo;

import java.util.Date;

public class VhotelPropVo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.STATUS
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.CREATED_BY
     *
     * @mbg.generated
     */
    private Long createdBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.CREATION_DATE
     *
     * @mbg.generated
     */
    private Date creationDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.LAST_UPDATED_BY
     *
     * @mbg.generated
     */
    private Long lastUpdatedBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.LAST_UPDATE_DATE
     *
     * @mbg.generated
     */
    private Date lastUpdateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.PROP_NAME
     *
     * @mbg.generated
     */
    private String propName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vhotel_prop.IMG
     *
     * @mbg.generated
     */
    private Long img;

    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.ID
     *
     * @return the value of vhotel_prop.ID
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.ID
     *
     * @param id the value for vhotel_prop.ID
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.STATUS
     *
     * @return the value of vhotel_prop.STATUS
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.STATUS
     *
     * @param status the value for vhotel_prop.STATUS
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.CREATED_BY
     *
     * @return the value of vhotel_prop.CREATED_BY
     *
     * @mbg.generated
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.CREATED_BY
     *
     * @param createdBy the value for vhotel_prop.CREATED_BY
     *
     * @mbg.generated
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.CREATION_DATE
     *
     * @return the value of vhotel_prop.CREATION_DATE
     *
     * @mbg.generated
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.CREATION_DATE
     *
     * @param creationDate the value for vhotel_prop.CREATION_DATE
     *
     * @mbg.generated
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.LAST_UPDATED_BY
     *
     * @return the value of vhotel_prop.LAST_UPDATED_BY
     *
     * @mbg.generated
     */
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.LAST_UPDATED_BY
     *
     * @param lastUpdatedBy the value for vhotel_prop.LAST_UPDATED_BY
     *
     * @mbg.generated
     */
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.LAST_UPDATE_DATE
     *
     * @return the value of vhotel_prop.LAST_UPDATE_DATE
     *
     * @mbg.generated
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.LAST_UPDATE_DATE
     *
     * @param lastUpdateDate the value for vhotel_prop.LAST_UPDATE_DATE
     *
     * @mbg.generated
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.PROP_NAME
     *
     * @return the value of vhotel_prop.PROP_NAME
     *
     * @mbg.generated
     */
    public String getPropName() {
        return propName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.PROP_NAME
     *
     * @param propName the value for vhotel_prop.PROP_NAME
     *
     * @mbg.generated
     */
    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vhotel_prop.IMG
     *
     * @return the value of vhotel_prop.IMG
     *
     * @mbg.generated
     */
    public Long getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vhotel_prop.IMG
     *
     * @param img the value for vhotel_prop.IMG
     *
     * @mbg.generated
     */
    public void setImg(Long img) {
        this.img = img;
    }
}
package com.glyk.heos.util;

/**
 * Created by Clark on 2017/3/11.
 */
public class ResultMsg<T> {
    int status;//0 失败 1成功
    String errorCode;//错误
    String message;//失败信息  成功消息
    T data;//数据

    public ResultMsg(){

    }

    public ResultMsg(int status, String errorCode, String message, T data) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

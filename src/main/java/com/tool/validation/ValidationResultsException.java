package com.tool.validation;

/**
 * Created by liang on 18-4-17.
 */
public class ValidationResultsException {
    private String key; //错误字段

    private String info; //错误信息

    public ValidationResultsException(String key, String info) {
        this.key = key;
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ValidationResultsException{" +
                "key='" + key + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

}

package com.example.retrofit.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/26.
 */
public class BaseEntity<T> implements Serializable{

    private int StateCode;
    private String StateExplain;
    private T DataObj;


    public int getStateCode() {
        return StateCode;
    }

    public void setStateCode(int stateCode) {
        StateCode = stateCode;
    }

    public String getStateExplain() {
        return StateExplain;
    }

    public void setStateExplain(String stateExplain) {
        StateExplain = stateExplain;
    }

    public T getDataObj() {
        return DataObj;
    }

    public void setDataObj(T dataObj) {
        DataObj = dataObj;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "StateCode=" + StateCode +
                ", StateExplain='" + StateExplain + '\'' +
                ", DataObj=" + DataObj +
                '}';
    }
}

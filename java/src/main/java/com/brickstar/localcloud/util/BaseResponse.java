package com.brickstar.localcloud.util;

/**
 * Created by bricks on 17/10/22.
 */
public class BaseResponse<T> {
    private Integer error_no = 0;
    private String error_msg = "";
    private T data;

    public Integer getError_no() {
        return error_no;
    }

    public void setError_no(Integer error_no) {
        this.error_no = error_no;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.brickstar.localcloud.bean.resp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bricks on 17/10/22.
 */
public class ConfigResp {
    private Integer error_no = 0;
    private String error_msg = null;
    private Map<String,String> data = new HashMap<>();

    public ConfigResp() {
        data.put("token","abc");
    }

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

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ConfigResp{" +
                "error_no=" + error_no +
                ", error_msg='" + error_msg + '\'' +
                ", data=" + data +
                '}';
    }
}

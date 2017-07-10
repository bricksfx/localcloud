package com.brickstar.localcloud.util;

/**
 * Created by bricks on 17/7/9.
 */
public class Response {
    private boolean status;

    /** Message indicating error if any **/
    private String message;

    /** Additional data that is part of this response **/
    private String data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Response(boolean status, String message, String data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}

package com.cms.contactmanagementsystem.response;

public class StatusResponse implements RestResponse {

    protected int status;

    protected String message;

    protected Object obj;

    public StatusResponse(int status, String message, Object obj) {
        this.status = status;
        this.message = message;
        this.obj = obj;
    }

    public StatusResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }


    @Override
    public String toString() {
        return "StatusResponse [message=" + message + ", obj=" + obj + ", status=" + status + "]";
    }


}


package com.electron.electron.common;

import org.springframework.http.HttpStatus;

public class CommonResponse {
    private Integer status;
    private Object data;
    private Object error;

    public CommonResponse() {
        this.status = HttpStatus.OK.value();

    }

    public CommonResponse(Integer status, Object data, Object error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "status=" + status +
                ", data=" + data.toString() +
                ", error=" + error.toString() +
                '}';
    }
}

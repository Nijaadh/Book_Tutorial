package com.electron.electron.common;

public class Error {
    private String target;
    private String message;

    public Error() {
    }

    public Error(String target, String message) {
        this.target = target;
        this.message = message;
    }

    public String getTarget() {
        return target;
    }

    public String getMessage() {
        return message;
    }



}

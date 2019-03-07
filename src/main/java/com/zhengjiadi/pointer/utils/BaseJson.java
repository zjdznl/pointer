package com.zhengjiadi.pointer.utils;

// 通用的返回结构
public class BaseJson {
    private int code;
    private String message;
    private Object data;

    public BaseJson(int errorCode) {
        this.code = errorCode;
    }

    public BaseJson(int errorCode, String message) {
        this.code = errorCode;
        this.message = message;
    }

    public BaseJson(int errorCode, String message, Object object) {
        this.code = errorCode;
        this.message = message;
        this.data = object;
    }

    public int getCode() {
        return code;
    }

    public BaseJson setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseJson setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BaseJson setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "BaseJson{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

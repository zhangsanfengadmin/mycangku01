package com.baidu.pojo;

//类上的自定义 泛型
public class Result<T> {
    private String message;//信息
    private boolean success;//是否执行成功
    private T result;//数据

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

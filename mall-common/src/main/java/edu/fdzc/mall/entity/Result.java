package edu.fdzc.mall.entity;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result<>(200, "操作成功", data);
    }

    public static <T> Result<T> success(){
        return new Result<>(200, "操作成功", null);
    }

    public static <T> Result<T> error(){
        return new Result<>(500, "操作失败", null);
    }
    // 失败响应
    public static <T> Result<T> error(String msg) {
        return new Result<>(500, msg, null);
    }
}
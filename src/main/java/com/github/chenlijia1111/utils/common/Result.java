package com.github.chenlijia1111.utils.common;

import com.github.chenlijia1111.utils.common.enums.ResponseStatusEnum;

/**
 * 返回结果
 *
 * @author chenlijia
 * @version 1.0
 * @since 2019/3/8 0008 下午 5:53
 **/
public class Result {

    /**
     * @see ResponseStatusEnum
     * @author chenlijia
     * @Description 状态码
     * @Date 上午 10:29 2019/4/4 0004
     **/
    private int code;

    private Boolean success;

    //返回信息
    private String msg;

    private Object data;

    public Result() {
    }

    public static Result success(String msg) {
        return success(msg, null);
    }

    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.setCode(ResponseStatusEnum.SUCCESS.getCode());
        result.setSuccess(true);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    public static Result failure(String msg) {
        return failure(msg, null);
    }

    public static Result failure(String msg, Object data) {
        Result result = new Result();
        result.setCode(ResponseStatusEnum.FAIL.getCode());
        result.setSuccess(false);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static Result notLogin() {
        return notLogin("用户未登录");
    }


    public static Result notLogin(String msg) {
        Result result = new Result();
        result.setCode(ResponseStatusEnum.UN_LOGINED.getCode());
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }


    /**
     * 数据已存在
     *
     * @param msg  1
     * @param data 2
     * @return expertise.common.pojo.Result
     * @author chenlijia
     * @Description TODO
     * @Date 下午 3:19 2019/7/23 0023
     **/
    public static Result exists(String msg, Object data) {
        Result result = new Result();
        result.setCode(ResponseStatusEnum.EXISTS.getCode());
        result.setSuccess(false);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 数据不存在
     *
     * @param msg 1
     * @return expertise.common.pojo.Result
     * @author chenlijia
     * @Description TODO
     * @Date 下午 3:19 2019/7/23 0023
     **/
    public static Result notExists(String msg) {
        Result result = new Result();
        result.setCode(ResponseStatusEnum.NOT_EXISTS.getCode());
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

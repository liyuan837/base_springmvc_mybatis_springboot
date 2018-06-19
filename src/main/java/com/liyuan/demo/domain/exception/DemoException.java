package com.liyuan.demo.domain.exception;

/**
 * 全局异常类
 */
public class DemoException extends Exception{

    private static final long serialVersionUID = -6202759931628287239L;
    private static final int DEFAULT_ERROR_CODE = 201;


    /* 错误码,用于返回接口code */
    private int errCode;

    public DemoException(){
        super();
    }

    public DemoException(String msg) {
        super(msg);
        this.errCode = DEFAULT_ERROR_CODE;
    }

    public DemoException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public DemoException(String msg, Throwable e) {
        super(msg,e);
        this.errCode = DEFAULT_ERROR_CODE;
    }

    public DemoException(int errCode, String msg, Throwable e) {
        super(msg, e);
        this.errCode = errCode;
    }


    public int getErrCode() {
        return errCode;
    }
}

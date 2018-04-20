package com.liyuan.demo.controller.base;

import com.liyuan.demo.entity.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 16:02 2018/4/20
 * @Modified By:
 */
public class BaseController {
    /**
     * 系统日志配置.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 未知异常，提示请求失败.
     */
    public static final String UNKNOWNEXCEPTION = "请求失败";
    /**
     * 未知异常，提示请求失败.
     */
    public static final String PARAMSVALIDFAIL = "参数错误！";
    /**
     * 成功的Status Code.
     */
    private static final int RESCODE_OK = 200;
    /**
     * 失败的Status Code.
     */
    private static final int RESCODE_FAIL = 201;

    protected ResponseEntity getSuccessResult(Object obj) {
        return new ResponseEntity("ok", RESCODE_OK, "操作成功", obj);
    }
    protected ResponseEntity getSuccessResult() {
        return getSuccessResult("操作成功");
    }

    protected ResponseEntity getFailResult(String msg) {

        return this.getFailResult(RESCODE_FAIL, msg);
    }

    protected ResponseEntity getFailResult(int errCode, String msg) {
        return new ResponseEntity("fail", errCode, msg, Collections.EMPTY_MAP);
    }
}

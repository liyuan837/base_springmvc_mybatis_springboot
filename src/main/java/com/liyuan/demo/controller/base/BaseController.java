package com.liyuan.demo.controller.base;

import com.liyuan.demo.entity.exception.DemoException;
import com.liyuan.demo.entity.response.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 默认成功返回数据封装
     */
    protected ResponseEntity getSuccessResult(Object obj) {
        return new ResponseEntity("ok", RESCODE_OK, "操作成功", obj);
    }

    /**
     * 自定义成功返回数据封装
     * @return
     */
    protected ResponseEntity getSuccessResult() {
        return getSuccessResult("操作成功");
    }

    /**
     * 默认失败返回数据封装
     * @return
     */
    protected ResponseEntity getFailResult(String msg) {

        return this.getFailResult(RESCODE_FAIL, msg);
    }

    /**
     * 自定义失败返回数据封装
     * @param errCode
     * @param msg
     * @return
     */
    protected ResponseEntity getFailResult(int errCode, String msg) {
        return new ResponseEntity("fail", errCode, msg, Collections.EMPTY_MAP);
    }

    /**
     * 业务异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DemoException.class)
    @ResponseBody
    public ResponseEntity ExceptionHandler(DemoException e) {
        logger.warn(e.getLocalizedMessage());
        return this.getFailResult(e.getErrCode(), e.getMessage());
    }


    /**
     * 运行期异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public
    @ResponseBody
    ResponseEntity runtimeExceptionHandler(RuntimeException e) {
        logger.error("发生系统异常", e);
        return this.getFailResult("系统异常，请和管理员联系！");
    }
}

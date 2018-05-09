package com.liyuan.demo.service;

import com.qiniu.common.QiniuException;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import java.io.File;
import java.io.InputStream;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 10:53 2018/5/3
 */
public interface QiNiuService {
    /**
     * 上传文件
     * <p>
     * (文件上传)
     *
     * @param file
     * @return
     * @throws QiniuException
     */
    Response uploadFile(File file) throws QiniuException;
    /**
     * 上传文件
     * <p>
     * (文件流上传)
     *
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    Response uploadFile(InputStream inputStream) throws QiniuException;
    /**
     * 删除
     *
     * @param key
     * @return
     * @throws QiniuException
     */
    Response delete(String key) throws QiniuException;
}
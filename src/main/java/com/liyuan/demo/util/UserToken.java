package com.liyuan.demo.util;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 17:37 2018/5/11
 * @Modified By:
 */
@Data
public class UserToken {

    private Integer id;
    private String token;
    private BigDecimal expireTime;
    private Date startTime;


}

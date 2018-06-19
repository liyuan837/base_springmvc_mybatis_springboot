package com.liyuan.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 10:21 2018/5/12
 * @Modified By:
 */
@Data
public class JwtUser implements Serializable {

    private static final long serialVersionUID = 4221700752972709820L;
    private Integer id;
    private String username;
    private String usercode;
    private String password;

    private String token;
}

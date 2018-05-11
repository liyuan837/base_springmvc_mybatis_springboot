package com.liyuan.demo.util;

import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 17:30 2018/5/11
 * @Modified By:
 */
public class JwtUtil {

    public static String stringKey ="liyuan";
    public static byte[] encodedKey = Base64.decodeBase64(stringKey);

    public static SecretKey key= new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");

    /**
     * 生成key
     */
    public static void generateKey(){
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        key  = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 生成token
     * @return
     */
    public  static String generateToken(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date startTime = new Date(System.currentTimeMillis());
        Date expireTime = new Date(System.currentTimeMillis()+ 60 *1000);
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")    //设置header
                .setHeaderParam("alg", "HS256")
                .setIssuedAt(startTime)     //设置
                .setExpiration(expireTime)
                .claim("name", "liuwillow")   //设置payload的键值对
                .claim("level", "100")
                .setIssuer("lwl")
                .signWith(signatureAlgorithm, key);    //签名，需要算法和key
        String token = builder.compact();
        System.out.println("生成token:" + token);
        return token;
    }
    /**
     * 验证
     */
    public static void verify(String token){
        //获取claims
        Claims claims = Jwts.parser()
                .setSigningKey(key)     //此处的key要与之前创建的key一致
                .parseClaimsJws(token)
                .getBody();
        //获取name和level
        String name = (String) claims.get("name");
        String level = (String) claims.get("level");
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getExpiration());

        System.out.println("name:" + name + " level:" + level);
    }

    public static void main(String[] args){
//        JwtUtil.generateKey();
        System.out.println(key.getFormat());
        String token = JwtUtil.generateToken();
        JwtUtil.verify(token);
    }
}

package com.mall4j.cloud.auth.manager;

/**
 * @program: mall4cloud-cjy
 * @ClassName JWTExample
 * @description:
 * @author: chenjy
 * @create: 2023-10-10 16:12
 * @Version 1.0
 **/

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JWTExample {

    public static void main(String[] args) {
        // 1. 创建一个密钥
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // 2. 创建一个 JWT 令牌
        String jwtToken = Jwts.builder()
                .setSubject("1234567890") // 用户标识
                .claim("role", "user") // 自定义声明
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 过期时间（1小时后）
                .signWith(key) // 使用密钥签名
                .compact();

        System.out.println("生成的JWT令牌：");
        System.out.println(jwtToken);

        // 3. 解析 JWT 令牌
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key) // 使用相同的密钥解析
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();

        // 4. 访问负载中的声明信息
        String userId = claims.getSubject();
        String role = (String) claims.get("role");
        Date issuedAt = claims.getIssuedAt();
        Date expiration = claims.getExpiration();

        System.out.println("\n解析的JWT令牌信息：");
        System.out.println("用户标识：" + userId);
        System.out.println("角色：" + role);
        System.out.println("签发时间：" + issuedAt);
        System.out.println("过期时间：" + expiration);
    }
}


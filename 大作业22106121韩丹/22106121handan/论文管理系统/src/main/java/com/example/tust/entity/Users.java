package com.example.tust.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * (Users)实体类
 *
 * @author silences
 * @since 2024-12-10 22:44:55
 */
@Data
public class Users implements Serializable {
    private static final long serialVersionUID = -53810879610763511L;
    /**
     * 序号
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 角色
     */
    private String role;

}


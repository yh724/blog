package com.jklearn.blog.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "users")
public class Users {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户IP
     */
    @Column(name = "user_ip")
    private String userIp;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 用户头像
     */
    @Column(name = "user_profile_photo")
    private String userProfilePhoto;

    /**
     * 注册时间
     */
    @Column(name = "user_registration_time")
    private String userRegistrationTime;

    /**
     * 用户生日
     */
    @Column(name = "user_birthday")
    private String userBirthday;

    /**
     * 用户年龄
     */
    @Column(name = "user_age")
    private Byte userAge;

    /**
     * 用户手机号
     */
    @Column(name = "user_telephone_number")
    private Integer userTelephoneNumber;

    /**
     * 用户昵称
     */
    @Column(name = "user_nickname")
    private String userNickname;
}
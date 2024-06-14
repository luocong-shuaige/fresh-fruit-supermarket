package com.qst.crop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_user")
public class TbUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户表
     */
    @TableId("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 姓名
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 编码
     */
    @TableField("identity_num")
    private String identityNum;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * user普通用户，expert专家，admin管理员 , bank银行用户
     */
    @TableField("role")
    private String role;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 积分500
     */
    @TableField("integral")
    private Integer integral;

    /**
     * 信誉1，2，3，4，5
     */
    @TableField("credit")
    private Integer credit;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    @TableField("real_name")
    private String realName;

}

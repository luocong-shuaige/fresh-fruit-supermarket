package com.qst.crop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 银行用户表
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_bank_user")
public class TbBankUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 登录名
     */
    @TableId("user_name")
    private String userName;

    /**
     * 银行
     */
    @TableField("bank_id")
    private Integer bankId;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 角色
     */
    @TableField("role")
    private String role;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}

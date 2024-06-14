package com.qst.crop.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbUser对象", description="")
public class TbUserBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 用户表
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String nickName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 编码
     */
    private String identityNum;
    /**
     * 地址
     */
    private String address;
    /**
     * user普通用户，expert专家，admin管理员 , bank银行用户
     */
    private String role;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    /**
     * 积分500
     */
    private Integer integral;
    /**
     * 信誉1，2，3，4，5
     */
    private Integer credit;
    /**
     * 头像
     */
    private String avatar;
    private String realName;


}

package com.qst.crop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 专家
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
@TableName("tb_expert")
public class TbExpert implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 登录名 专家
     */
    @TableId("user_name")
    private String userName;

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
     * 职业
     */
    @TableField("profession")
    private String profession;

    /**
     * 职位
     */
    @TableField("position")
    private String position;

    /**
     * 属于
     */
    @TableField("belong")
    private String belong;


}

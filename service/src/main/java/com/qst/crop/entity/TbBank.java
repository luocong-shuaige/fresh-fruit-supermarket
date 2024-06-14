package com.qst.crop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 银行表
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_bank")
public class TbBank implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 银行
     */
    @TableId(value = "bank_id", type = IdType.AUTO)
    private Integer bankId;

    /**
     * 名称
     */
    @TableField("bank_name")
    private String bankName;

    /**
     * 
介绍
     */
    @TableField("introduce")
    private String introduce;

    /**
     * 电话
     */
    @TableField("bank_phone")
    private String bankPhone;

    /**
     * 资产
     */
    @TableField("money")
    private BigDecimal money;

    /**
     * 利率
     */
    @TableField("rate")
    private BigDecimal rate;

    /**
     * 债务
     */
    @TableField("repayment")
    private Integer repayment;


}

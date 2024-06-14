package com.qst.crop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("tb_purchase")
public class TbPurchase implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单表
     */
    @TableId(value = "purchase_id", type = IdType.AUTO)
    private Integer purchaseId;

    /**
     * 发布人
     */
    @TableField("own_name")
    private String ownName;

    /**
     * 类型
     */
    @TableField("purchase_type")
    private Integer purchaseType;

    /**
     * 订单金额
     */
    @TableField("total_price")
    private BigDecimal totalPrice;

    /**
     * 订单收货地址
     */
    @TableField("address")
    private String address;

    /**
     * 需求状态
     */
    @TableField("purchase_status")
    private Integer purchaseStatus;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


}

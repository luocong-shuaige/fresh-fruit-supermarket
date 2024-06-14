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
 * 卖出订单表
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
@TableName("tb_sell_purchase")
public class TbSellPurchase implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 卖出订单
     */
    @TableId(value = "sell_purchase_id", type = IdType.AUTO)
    private Integer sellPurchaseId;

    /**
     * 订单
     */
    @TableField("purchase_id")
    private Integer purchaseId;

    @TableField("own_name")
    private String ownName;

    @TableField("purchase_type")
    private Integer purchaseType;

    @TableField("unin_pricee")
    private BigDecimal uninPricee;

    @TableField("sum_price")
    private BigDecimal sumPrice;

    /**
     * 订单收货地址
     */
    @TableField("address")
    private String address;

    @TableField("purchase_status")
    private Integer purchaseStatus;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("order_id")
    private Integer orderId;


}

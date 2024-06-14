package com.qst.crop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUserBuy {
    /**
     * 订单表
     */
    @TableId(value = "purchase_id", type = IdType.AUTO)
    private Integer purchaseId;

    /**
     * 发布人
     */
    private String ownName;

    /**
     * 类型
     */
    private Integer purchaseType;

    /**
     * 订单金额
     */
    private BigDecimal totalPrice;

    /**
     * 订单收货地址
     */

    private String address;

    /**
     * 需求状态
     */

    private Integer purchaseStatus;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
}

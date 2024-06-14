package com.qst.crop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 订单详情表
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
@TableName("tb_purchase_detail")
public class TbPurchaseDetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单详情
     */
    @TableId(value = "detail_id", type = IdType.AUTO)
    private Integer detailId;

    @TableField("purchase_id")
    private Integer purchaseId;

    @TableField("order_id")
    private Integer orderId;

    @TableField("unin_price")
    private BigDecimal uninPrice;

    @TableField("sum_price")
    private BigDecimal sumPrice;

    @TableField("count")
    private Integer count;


}

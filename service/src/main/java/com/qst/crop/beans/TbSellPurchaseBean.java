package com.qst.crop.beans;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
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
@ApiModel(value="TbSellPurchase对象", description="卖出订单表")
public class TbSellPurchaseBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 卖出订单
     */
    private Integer sellPurchaseId;
    /**
     * 订单
     */
    private Integer purchaseId;
    private String ownName;
    private Integer purchaseType;
    private BigDecimal uninPricee;
    private BigDecimal sumPrice;
    /**
     * 订单收货地址
     */
    private String address;
    private Integer purchaseStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer orderId;
    private String phone;

}

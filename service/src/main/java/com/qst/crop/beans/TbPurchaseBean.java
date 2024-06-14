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
@ApiModel(value="TbPurchase对象", description="")
public class TbPurchaseBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 订单表
     */
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
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}

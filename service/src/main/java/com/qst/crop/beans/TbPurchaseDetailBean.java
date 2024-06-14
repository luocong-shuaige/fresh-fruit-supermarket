package com.qst.crop.beans;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 订单详情表
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbPurchaseDetail对象", description="订单详情表")
public class TbPurchaseDetailBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 订单详情
     */
    private Integer detailId;
    private Integer purchaseId;
    private Integer orderId;
    private BigDecimal uninPrice;
    private BigDecimal sumPrice;
    private Integer count;


}

package com.qst.crop.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
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
 * 
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="TbShoppingcart对象", description="")
public class TbShoppingcartBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 购物车
     */
    private Integer shoppingId;
    /**
     * 产品
     */
    private Integer orderId;

    private Integer count;
    private String ownName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    /**
     * tb_oeder 表里的字段
     */
    private String title;
    private BigDecimal price;
    private String content;
    private String picture;


}

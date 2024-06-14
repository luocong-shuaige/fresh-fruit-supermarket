package com.qst.crop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_shoppingcart")
public class TbShoppingcart implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 购物车
     */
    @TableId(value = "shopping_id", type = IdType.AUTO)
    private Integer shoppingId;

    /**
     * 产品
     */
    @TableField("order_id")
    private Integer orderId;

    @TableField("count")
    private Integer count;

    @TableField("own_name")
    private String ownName;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


}

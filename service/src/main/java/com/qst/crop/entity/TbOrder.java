package com.qst.crop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("tb_order")
public class TbOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 需求标题
     */
    @TableField("title")
    private String title;

    /**
     * 期望价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 订单状态，0表示待合作，1表示待发货，2表示完成，3表示完成但未评价
     */
    @TableField("order_status")
    private Integer orderStatus;

    /**
     * 1销售订单，2需求订单
     */
    @TableField("type")
    private String type;

    /**
     * 订单主图
     */
    @TableField("picture")
    private String picture;

    /**
     * 发起订单人
     */
    @TableField("own_name")
    private String ownName;

    /**
     * 合作人名字
     */
    @TableField("cooperation_name")
    private String cooperationName;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 订单收货地址
     */
    @TableField("address")
    private String address;

    /**
     * 版本号 避免脏读导致的数据不一致业务情况
     */
    @TableField("version")
    @Version
    private Integer version;

    /**
     * 逻辑删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}

package com.qst.crop.beans;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value="TbOrder对象", description="")
public class TbOrderBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 商品
     */
    private Integer orderId;
    /**
     * 需求标题
     */
    private String title;
    /**
     * 期望价格
     */
    private BigDecimal price;
    /**
     * 内容
     */
    private String content;
    /**
     * 订单状态，0表示待合作，1表示待发货，2表示完成，3表示完成但未评价
     */
    private Integer orderStatus;
    /**
     * 1销售订单，2需求订单
     */
    private String type;
    /**
     * 订单主图
     */
    private String picture;
    /**
     * 发起订单人
     */
    private String ownName;
    /**
     * 合作人名字
     */
    private String cooperationName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    /**
     * 订单收货地址
     */
    private String address;
    /**
     * 版本号 避免脏读导致的数据不一致业务情况
     */
    private Integer version;


}

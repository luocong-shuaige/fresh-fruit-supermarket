package com.qst.crop.entity;

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
@TableName("tb_address")
public class TbAddress implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 收货地址
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 属于哪个用户的地址
     */
    @TableField("own_name")
    private String ownName;

    /**
     * 收货人
     */
    @TableField("consignee")
    private String consignee;

    /**
     * 收货电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 收货地址
     */
    @TableField("address_detail")
    private String addressDetail;

    /**
     * 是否默认，0，不是，默认是1
     */
    @TableField("is_default")
    private Integer isDefault;


}

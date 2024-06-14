package com.qst.crop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 专家预约表
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_reserve")
public class TbReserve implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 专家预约
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专家
     */
    @TableField("expert_name")
    private String expertName;

    /**
     * 咨询者
     */
    @TableField("questioner")
    private String questioner;

    /**
     * 面积
     */
    @TableField("area")
    private String area;

    /**
     * 土地地址
     */
    @TableField("address")
    private String address;

    /**
     * 农作物名称
     */
    @TableField("plant_name")
    private String plantName;

    /**
     * 土壤条件
     */
    @TableField("soil_condition")
    private String soilCondition;

    /**
     * 作物条件
     */
    @TableField("plant_condition")
    private String plantCondition;

    /**
     * 作物详细信息
     */
    @TableField("plant_detail")
    private String plantDetail;

    /**
     * 作物详细信息
     */
    @TableField("phone")
    private String phone;

    /**
     * 留言
     */
    @TableField("message")
    private String message;

    /**
     * 回答
     */
    @TableField("answer")
    private String answer;

    @TableField("status")
    private Integer status;


}

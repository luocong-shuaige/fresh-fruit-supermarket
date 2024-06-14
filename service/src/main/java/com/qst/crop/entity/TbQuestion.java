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
 * 在线问答
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_question")
public class TbQuestion implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 在线问答
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专家
     */
    @TableField("expert_name")
    private String expertName;

    /**
     * 手机号
     */
    @TableField("questioner")
    private String questioner;

    /**
     * 作物详细信息
     */
    @TableField("phone")
    private String phone;

    /**
     * 农作物名称
     */
    @TableField("plant_name")
    private String plantName;

    /**
     * 问题标题
     */
    @TableField("title")
    private String title;

    /**
     * 问题
     */
    @TableField("question")
    private String question;

    /**
     * 回答
     */
    @TableField("answer")
    private String answer;

    @TableField("status")
    private Integer status;


}

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
@TableName("tb_discuss")
public class TbDiscuss implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 知识讨论表
     */
    @TableId(value = "discuss_id", type = IdType.AUTO)
    private Integer discussId;

    /**
     * 知识
     */
    @TableField("knowledge_id")
    private Integer knowledgeId;

    /**
     * 评论者
     */
    @TableField("own_name")
    private String ownName;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}

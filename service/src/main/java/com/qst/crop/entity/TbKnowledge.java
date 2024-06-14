package com.qst.crop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalTime;
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
@TableName("tb_knowledge")
public class TbKnowledge implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "knowledge_id", type = IdType.AUTO)
    private Integer knowledgeId;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("pic_path")
    private String picPath;

    /**
     * 发布者名字
     */
    @TableField("own_name")
    private String ownName;

    @TableField("create_time")
    private LocalTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


}

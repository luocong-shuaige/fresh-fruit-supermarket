package com.qst.crop.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@ApiModel(value="TbDiscuss对象", description="")
public class TbDiscussBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 知识讨论表
     */
    private Integer discussId;
    /**
     * 知识
     */
    private Integer knowledgeId;
    /**
     * 评论者
     */
    private String ownName;
    /**
     * 内容
     */
    private String content;
    /**
     * 时间
     */
    private LocalDateTime createTime;


}

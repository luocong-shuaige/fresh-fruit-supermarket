package com.qst.crop.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalTime;
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
@ApiModel(value="TbKnowledge对象", description="")
public class TbKnowledgeBean implements Serializable {
    private static final long serialVersionUID=1L;
    private Integer knowledgeId;
    private String title;
    private String content;
    private String picPath;
    /**
     * 发布者名字
     */
    private String ownName;
    private LocalTime createTime;
    private LocalDateTime updateTime;


}

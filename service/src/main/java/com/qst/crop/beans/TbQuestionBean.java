package com.qst.crop.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 在线问答
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbQuestion对象", description="在线问答")
public class TbQuestionBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 在线问答
     */
    private Integer id;
    /**
     * 专家
     */
    private String expertName;
    /**
     * 手机号
     */
    private String questioner;
    /**
     * 作物详细信息
     */
    private String phone;
    /**
     * 农作物名称
     */
    private String plantName;
    /**
     * 问题标题
     */
    private String title;
    /**
     * 问题
     */
    private String question;
    /**
     * 回答
     */
    private String answer;
    private Integer status;


}

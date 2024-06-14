package com.qst.crop.beans;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 专家
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbExpert对象", description="专家")
public class TbExpertBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 登录名 专家
     */
    private String userName;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 职业
     */
    private String profession;
    /**
     * 职位
     */
    private String position;
    /**
     * 属于
     */
    private String belong;


}

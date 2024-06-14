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
 * 专家预约表
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbReserve对象", description="专家预约表")
public class TbReserveBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 专家预约
     */
    private Integer id;
    /**
     * 专家
     */
    private String expertName;
    /**
     * 咨询者
     */
    private String questioner;
    /**
     * 面积
     */
    private String area;
    /**
     * 土地地址
     */
    private String address;
    /**
     * 农作物名称
     */
    private String plantName;
    /**
     * 土壤条件
     */
    private String soilCondition;
    /**
     * 作物条件
     */
    private String plantCondition;
    /**
     * 作物详细信息
     */
    private String plantDetail;
    /**
     * 作物详细信息
     */
    private String phone;
    /**
     * 留言
     */
    private String message;
    /**
     * 回答
     */
    private String answer;
    private Integer status;


}

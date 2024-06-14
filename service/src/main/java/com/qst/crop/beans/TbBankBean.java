package com.qst.crop.beans;

import java.math.BigDecimal;
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
 * 银行表
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbBank对象", description="银行表")
public class TbBankBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 银行
     */
    private Integer bankId;
    /**
     * 名称
     */
    private String bankName;
    /**
     * 
介绍
     */
    private String introduce;
    /**
     * 电话
     */
    private String bankPhone;
    /**
     * 资产
     */
    private BigDecimal money;
    /**
     * 利率
     */
    private BigDecimal rate;
    /**
     * 债务
     */
    private Integer repayment;


}

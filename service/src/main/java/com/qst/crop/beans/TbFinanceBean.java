package com.qst.crop.beans;

import java.math.BigDecimal;
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
@ApiModel(value="TbFinance对象", description="")
public class TbFinanceBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 金融融资
     */
    private Integer financeId;
    /**
     * 银行
     */
    private Integer bankId;
    /**
     * 登录名
     */
    private String ownName;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 编码
     */
    private String idNum;
    /**
     * 状态
     */
    private Integer status;
    private String remark;
    private BigDecimal money;
    private BigDecimal rate;
    private Integer repayment;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String combinationName1;
    private String combinationPhone1;
    private String combinationIdnum1;
    private String combinationName2;
    private String combinationPhone2;
    private String combinationIdnum2;
    private String fileInfo;


}

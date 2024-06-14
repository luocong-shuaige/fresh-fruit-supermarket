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
 * 融资意向表
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbFinancingIntention对象", description="融资意向表")
public class TbFinancingIntentionBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 融资意向
     */
    private Integer id;
    private String userName;
    private String realName;
    private String address;
    private Integer amount;
    private String application;
    private String item;
    private Integer repaymentPeriod;
    private Integer area;
    private String phone;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}

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
 * 
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Data
@NoArgsConstructor
@ApiModel(value="TbAddress对象", description="")
public class TbAddressBean implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 收货地址
     */
    private Integer id;
    /**
     * 属于哪个用户的地址
     */
    private String ownName;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 收货电话
     */
    private String phone;
    /**
     * 收货地址
     */
    private String addressDetail;
    /**
     * 是否默认，0，不是，默认是1
     */
    private Boolean isDefault;


}

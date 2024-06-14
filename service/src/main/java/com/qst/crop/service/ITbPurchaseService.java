package com.qst.crop.service;

import com.qst.crop.entity.TbPurchase;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbPurchaseService extends IService<TbPurchase> {

    TbPurchase addPurchase(String addressId, BigDecimal tMoney);
}

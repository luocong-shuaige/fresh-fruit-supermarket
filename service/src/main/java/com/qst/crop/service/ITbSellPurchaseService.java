package com.qst.crop.service;

import com.qst.crop.beans.TbSellPurchaseBean;
import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.entity.TbPurchase;
import com.qst.crop.entity.TbSellPurchase;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 卖出订单表 服务类
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbSellPurchaseService extends IService<TbSellPurchase> {

    List<TbSellPurchase> addTbSellPurchase(TbPurchase tbPurchase, List<TbShoppingcartBean> tbShoppingcartBeans,String addressId);
}

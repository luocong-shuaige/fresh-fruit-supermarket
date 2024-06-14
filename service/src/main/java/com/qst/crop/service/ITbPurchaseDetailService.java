package com.qst.crop.service;

import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.entity.TbPurchase;
import com.qst.crop.entity.TbPurchaseDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单详情表 服务类
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbPurchaseDetailService extends IService<TbPurchaseDetail> {

    List<TbPurchaseDetail> addPurchaseDetail(TbPurchase tbPurchase, List<TbShoppingcartBean> tbShoppingcartBeans);
}

package com.qst.crop.service.impl;

import com.qst.crop.beans.TbSellPurchaseBean;
import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.entity.*;
import com.qst.crop.dao.TbSellPurchaseMapper;
import com.qst.crop.service.ITbOrderService;
import com.qst.crop.service.ITbSellPurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 卖出订单表 服务实现类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Service
public class TbSellPurchaseServiceImpl extends ServiceImpl<TbSellPurchaseMapper, TbSellPurchase> implements ITbSellPurchaseService {

    @Autowired
    ITbSellPurchaseService tbSellPurchaseService;

    @Autowired
    ITbOrderService tbOrderService;
    @Override
    public List<TbSellPurchase> addTbSellPurchase(TbPurchase tbPurchase, List<TbShoppingcartBean> tbShoppingcartBeans, String addressId) {
        List<TbSellPurchase> list = new ArrayList<>();
        BigDecimal sum;
        Integer count;
        BigDecimal price;
        for (TbShoppingcartBean TB : tbShoppingcartBeans) {
            TbOrder tbOrder = tbOrderService.getById(TB.getOrderId());
            count = TB.getCount();
            price = TB.getPrice();
            sum = BigDecimal.valueOf(count).multiply(price);
            TbSellPurchase tbSellPurchase = new TbSellPurchase(null, tbPurchase.getPurchaseId(), tbOrder.getOwnName(), 2, TB.getPrice(),
                    sum, addressId, tbPurchase.getPurchaseStatus(), LocalDateTime.now(), LocalDateTime.now(), TB.getOrderId());

            tbSellPurchaseService.save(tbSellPurchase);
        }
        return list;
    }
}

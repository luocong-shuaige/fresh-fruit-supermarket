package com.qst.crop.service.impl;

import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.entity.TbPurchase;
import com.qst.crop.entity.TbPurchaseDetail;
import com.qst.crop.dao.TbPurchaseDetailMapper;
import com.qst.crop.service.ITbPurchaseDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qst.crop.service.ITbShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Service
public class TbPurchaseDetailServiceImpl extends ServiceImpl<TbPurchaseDetailMapper, TbPurchaseDetail> implements ITbPurchaseDetailService {

    @Autowired
    private ITbPurchaseDetailService purchaseDetailService;
     @Autowired
     private ITbShoppingcartService tbShoppingcartService;
    @Override
    public List<TbPurchaseDetail> addPurchaseDetail(TbPurchase tbPurchase, List<TbShoppingcartBean> tbShoppingcartBeans) {
        List<TbPurchaseDetail> list = new ArrayList<>();
        BigDecimal sum;
        Integer count;
        BigDecimal price;
        for (TbShoppingcartBean TB : tbShoppingcartBeans) {
            count = TB.getCount();
            price = TB.getPrice();
            sum = BigDecimal.valueOf(count).multiply(price);
            TbPurchaseDetail tbPurchaseDetail = new TbPurchaseDetail(null, tbPurchase.getPurchaseId(), TB.getOrderId(), TB.getPrice(),
                    sum, TB.getCount());
            list.add(tbPurchaseDetail);
            purchaseDetailService.save(tbPurchaseDetail);
            tbShoppingcartService.removeById(TB.getShoppingId());
        }
        return list;
    }
}

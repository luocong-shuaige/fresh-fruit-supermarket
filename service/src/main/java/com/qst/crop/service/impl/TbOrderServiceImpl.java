package com.qst.crop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qst.crop.entity.TbOrder;
import com.qst.crop.dao.TbOrderMapper;
import com.qst.crop.entity.TbUser;
import com.qst.crop.service.ITbOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Service
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder> implements ITbOrderService {

    @Autowired
    private ITbOrderService tbOrderService;


    @Override
    public TbOrder selectByOrderTitle(String title) {
        QueryWrapper<TbOrder> tbOrderQueryWrapper = new QueryWrapper<>();
        tbOrderQueryWrapper.lambda().like(TbOrder::getTitle,title).eq(TbOrder::getType,"goods");
        TbOrder tbOrder = this.getOne(tbOrderQueryWrapper);
        System.out.println(tbOrder.getTitle()+"**************8");
        return tbOrder;
    }

    @Override
    public TbOrder selectByOrderId(String order_id) {
        QueryWrapper<TbOrder> tbOrderQueryWrapper = new QueryWrapper<>();
        tbOrderQueryWrapper.lambda().eq(TbOrder::getOrderId,order_id);
        TbOrder tbOrder = this.getOne(tbOrderQueryWrapper);
        return tbOrder;
    }

    /**
     * 用户添加商品货源或需求
     * @param tbOrder
     * @return TbOrder
     */
    @Override
    public TbOrder AddNewOrder(TbOrder tbOrder) {
        TbOrder tbOrder1 = tbOrder;
        tbOrder1.setCreateTime(LocalDateTime.now());
        tbOrder1.setUpdateTime(LocalDateTime.now());
        tbOrder1.setOrderStatus(0);
        tbOrderService.save(tbOrder1);
        return tbOrder;
    }
}

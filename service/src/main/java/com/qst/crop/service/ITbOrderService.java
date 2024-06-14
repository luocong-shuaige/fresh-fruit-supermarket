package com.qst.crop.service;

import com.qst.crop.entity.TbOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qst.crop.entity.TbUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbOrderService extends IService<TbOrder> {
    public TbOrder selectByOrderTitle(String title);

    public TbOrder selectByOrderId(String order_id);

    public TbOrder AddNewOrder(TbOrder newOrder);
}

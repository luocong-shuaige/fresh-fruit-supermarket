package com.qst.crop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.entity.TbShoppingcart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbShoppingcartService extends IService<TbShoppingcart> {

    List<TbShoppingcartBean> selectBeanByUsername(String username);

    TbShoppingcart getShoppingcarId(Integer order_id, String username);
}

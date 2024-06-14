package com.qst.crop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.entity.TbShoppingcart;
import com.qst.crop.dao.TbShoppingcartMapper;
import com.qst.crop.service.ITbShoppingcartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Service
public class TbShoppingcartServiceImpl extends ServiceImpl<TbShoppingcartMapper, TbShoppingcart> implements ITbShoppingcartService {

    @Autowired
    private ITbShoppingcartService tbShoppingcartService;
    @Autowired
    private TbShoppingcartMapper tbShoppingcartMapper;
    @Override
    public List<TbShoppingcartBean> selectBeanByUsername(String username) {

        List<TbShoppingcartBean> list = tbShoppingcartMapper.selectListByUserName(username);

        return list;
    }

    @Override
    public TbShoppingcart getShoppingcarId(Integer order_id, String username) {
        QueryWrapper<TbShoppingcart> tbShoppingcartQueryWrapper = new QueryWrapper<>();
        tbShoppingcartQueryWrapper.lambda().eq(TbShoppingcart::getOrderId,order_id).eq(TbShoppingcart::getOwnName,username);
        TbShoppingcart tbShoppingcart = this.getOne(tbShoppingcartQueryWrapper);
        return tbShoppingcart;
    }
}

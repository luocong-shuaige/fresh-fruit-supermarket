package com.qst.crop.service.impl;

import com.qst.crop.entity.TbPurchase;
import com.qst.crop.dao.TbPurchaseMapper;
import com.qst.crop.service.ITbPurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
public class TbPurchaseServiceImpl extends ServiceImpl<TbPurchaseMapper, TbPurchase> implements ITbPurchaseService {

    @Autowired
    private ITbPurchaseService tbPurchaseService;
    @Override
    public TbPurchase addPurchase(String addressId, BigDecimal tMoney) {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbPurchase tbPurchase = new TbPurchase(null,username,1,tMoney, addressId,1, LocalDateTime.now(),LocalDateTime.now());
        tbPurchaseService.save(tbPurchase);
        return tbPurchase;
    }
}

package com.qst.crop.service.impl;

import com.qst.crop.entity.TbAddress;
import com.qst.crop.dao.TbAddressMapper;
import com.qst.crop.service.ITbAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Service
public class TbAddressServiceImpl extends ServiceImpl<TbAddressMapper, TbAddress> implements ITbAddressService {

    @Autowired
    private ITbAddressService tbAddressService;
    @Override
    public String getAddress(String address) {
        TbAddress tbAddress = tbAddressService.getById(address);
        String GetAddress =tbAddress.getAddressDetail();
        return GetAddress;
    }
}

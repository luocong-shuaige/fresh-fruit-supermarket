package com.qst.crop.service;

import com.qst.crop.entity.TbAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>

 *
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbAddressService extends IService<TbAddress> {

    public String getAddress(String address);
}

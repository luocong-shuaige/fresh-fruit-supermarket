package com.qst.crop.service;

import com.qst.crop.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbUserService extends IService<TbUser> {
 public TbUser selectByUserName(String name);

 TbUser selectByNickName(String nickName);

    TbUser AddUser(TbUser params);
}

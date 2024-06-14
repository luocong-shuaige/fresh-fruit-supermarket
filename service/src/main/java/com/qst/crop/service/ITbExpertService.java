package com.qst.crop.service;

import com.qst.crop.entity.TbExpert;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qst.crop.entity.TbUser;

/**
 * <p>
 * 专家 服务类
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbExpertService extends IService<TbExpert> {

  public   TbExpert AddExpert(TbUser user1);
}

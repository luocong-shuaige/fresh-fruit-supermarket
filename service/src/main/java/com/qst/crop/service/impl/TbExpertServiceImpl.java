package com.qst.crop.service.impl;

import com.qst.crop.entity.TbExpert;
import com.qst.crop.dao.TbExpertMapper;
import com.qst.crop.entity.TbUser;
import com.qst.crop.service.ITbExpertService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 专家 服务实现类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Service
public class TbExpertServiceImpl extends ServiceImpl<TbExpertMapper, TbExpert> implements ITbExpertService {

    @Autowired
    private ITbExpertService tbExpertService;
    @Override
    public TbExpert AddExpert(TbUser user1) {
        TbExpert tbExpert  = new TbExpert(user1.getUserName(), user1.getRealName(),user1.getPhone(),"1","1","1" );
        tbExpertService.save(tbExpert);
        return tbExpert;
    }
}

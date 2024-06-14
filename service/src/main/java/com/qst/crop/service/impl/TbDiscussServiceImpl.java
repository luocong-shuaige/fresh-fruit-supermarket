package com.qst.crop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qst.crop.entity.TbDiscuss;
import com.qst.crop.dao.TbDiscussMapper;
import com.qst.crop.service.ITbDiscussService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TbDiscussServiceImpl extends ServiceImpl<TbDiscussMapper, TbDiscuss> implements ITbDiscussService {

    @Override
    public TbDiscuss getDiscussByKnowledgeId(Integer knowledgeId) {
        QueryWrapper<TbDiscuss> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbDiscuss::getKnowledgeId, knowledgeId);
        TbDiscuss tbDiscuss = this.getOne(wrapper);
        return tbDiscuss;
    }
}

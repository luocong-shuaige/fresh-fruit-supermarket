package com.qst.crop.service;

import com.qst.crop.entity.TbDiscuss;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
public interface ITbDiscussService extends IService<TbDiscuss> {

    /**
     * 根据knowledgeId查询评论
     * @param knowledgeId
     * @return
     */
    TbDiscuss getDiscussByKnowledgeId(Integer knowledgeId);
}

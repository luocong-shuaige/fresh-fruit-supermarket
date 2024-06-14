package com.qst.crop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.TbDiscuss;
import com.qst.crop.entity.TbKnowledge;
import com.qst.crop.entity.TbOrder;
import com.qst.crop.entity.TbReserve;
import com.qst.crop.service.ITbDiscussService;
import com.qst.crop.service.ITbKnowledgeService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@RestController
@RequestMapping("/knowledge")
public class TbKnowledgeController {
    @Autowired
    private ITbKnowledgeService tbKnowledgeService;
    @Autowired
    private ITbDiscussService tbDiscussService;
    private String prefix = "system/pages/";

    /**
     * 农业知识页面
     *
     * @param pageId
     * @return
     */
    @RequestMapping("/{pageId}")
    public Result<Page> getPage(@PathVariable Integer pageId) {
        Page<TbKnowledge> page = new Page<>(pageId, 30);
        QueryWrapper<TbKnowledge> wrapper = new QueryWrapper<>();
        Page<TbKnowledge> queryPageUser = tbKnowledgeService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    /**
     * 根据id查询知识信息
     *
     * @param knowledgeId
     * @return
     */
    @RequestMapping("/selectById/{knowledgeId}")//   knowledge/selectById/23
    public Result<TbKnowledge> selectById(@PathVariable Integer knowledgeId) {
        try {
            TbKnowledge knowledge = tbKnowledgeService.getById(knowledgeId);
            return new Result(true, 200, null, knowledge);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, 500, "系统异常，请您联系管理员！服务热线：0755-xxxx", null);
        }
    }

    // 根据用户名查询知识 //专家查询农业知识
    @GetMapping("/selectByUsername")
    @Transactional
    public Result<Page> selectByUsername() {
        Page<TbKnowledge> page = new Page<>(1, 30);
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        QueryWrapper<TbKnowledge> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbKnowledge::getOwnName, username);
        Page<TbKnowledge> KnowledgePage = tbKnowledgeService.page(page, wrapper);
        return new Result(true, StatusCode.OK, "查询成功", KnowledgePage);
    }

   //知识评论
    @RequestMapping("/selectByKnowledge/{knowledgeId}")
    public Result<TbDiscuss> selectByKnowledge(@PathVariable Integer knowledgeId) {
        try {
            Page<TbDiscuss> page = new Page<>(1, 30);
            QueryWrapper<TbDiscuss> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbDiscuss::getKnowledgeId, knowledgeId)
                    .orderByDesc(TbDiscuss::getCreateTime);
            Page<TbDiscuss> queryPageUser = tbDiscussService.page(page, wrapper);
            return new Result(true, 200, null, queryPageUser);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, 500, "系统异常，请您联系管理员！服务热线：0755-xxxx", null);
        }
    }
    //添加评论
    @PostMapping("/addByKnowledge/{knowledgeId}/{content}")
    public Result<TbDiscuss> addByKnowledge(@PathVariable Integer knowledgeId, @PathVariable String content) {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbDiscuss tbDiscuss = new TbDiscuss();
        tbDiscuss.setKnowledgeId(knowledgeId);
        tbDiscuss.setContent(content);
        tbDiscuss.setOwnName(username);
        tbDiscuss.setCreateTime(LocalDateTime.now());
        tbDiscussService.save(tbDiscuss);
        return new Result<TbDiscuss>(true, StatusCode.OK, "查询成功", tbDiscuss);
    }
    //添加知识
    @PostMapping("/addKnowledge")
    @Transactional
    public Result<TbKnowledge> addKnowledge(@RequestBody TbKnowledge tbKnowledge) {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        tbKnowledge.setOwnName(username);
        tbKnowledge.setCreateTime(LocalTime.now());
        tbKnowledge.setUpdateTime(LocalDateTime.now());
        tbKnowledgeService.save(tbKnowledge);
        return new Result(true, StatusCode.OK, "添加成功", tbKnowledge);
    }
    //修改知识
    @PostMapping("/{KnowledgeId}")
    @Transactional
    public Result<TbKnowledge> updateKnowledge(@PathVariable Integer KnowledgeId ,@RequestBody TbKnowledge tbKnowledge) {
        TbKnowledge  newtbKnowledge = tbKnowledgeService.getById(KnowledgeId);
        newtbKnowledge.setTitle(tbKnowledge.getTitle());
        newtbKnowledge.setContent(tbKnowledge.getContent());
        newtbKnowledge.setPicPath(tbKnowledge.getPicPath());
        newtbKnowledge.setUpdateTime(LocalDateTime.now());
        tbKnowledgeService.updateById(tbKnowledge);
        return new Result(true, StatusCode.OK, "修改成功", "修改成功");
    }
    //删除知识
    @DeleteMapping("/{KnowledgeId}")
    @Transactional
    public Result<TbKnowledge> deleteKnowledge(@PathVariable Integer KnowledgeId ) {

        tbKnowledgeService.removeById(KnowledgeId);
        return new Result(true, StatusCode.OK, "删除知识成功", "删除知识成功");
    }
}
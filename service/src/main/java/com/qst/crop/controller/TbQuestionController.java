package com.qst.crop.controller;

import com.alipay.api.domain.UserDetails;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbExpertBean;
import com.qst.crop.beans.TbOrderBean;
import com.qst.crop.beans.TbQuestionBean;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.TbExpert;
import com.qst.crop.entity.TbOrder;
import com.qst.crop.entity.TbQuestion;
import com.qst.crop.entity.TbUser;
import com.qst.crop.service.ITbExpertService;
import com.qst.crop.service.ITbQuestionService;
import com.qst.crop.service.ITbUserService;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 在线问答 前端控制器
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@RestController
@RequestMapping("/question")
public class TbQuestionController {
    @Autowired
    private ITbQuestionService tbQuestionService;
    @Autowired
    private ITbUserService tbUserService;
    @Autowired
    private  ITbExpertService tbExpertService;
    private String prefix = "system/pages/";


    //查询所有问题
    @RequestMapping("/findAllQues/{pageId}")
    public Result<Page> findAllQues(@PathVariable Integer pageId) {
        List<TbQuestionBean> tob = new ArrayList<>();
        Page<TbQuestion> page = new Page<>(pageId, 30);
        QueryWrapper<TbQuestion> wrapper = new QueryWrapper<>();
        wrapper.lambda().ne(TbQuestion::getQuestioner, "");
        Page<TbQuestion> queryPageUser = tbQuestionService.page(page, wrapper);
        List<TbQuestion> list = tbQuestionService.list(wrapper);
          return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //根据专家名字搜索问题
    @RequestMapping("/findPageQues/{keys}/{pageId}")
    public Result<Page> findPageQues(@PathVariable String keys,@PathVariable Integer pageId) {
        Page<TbQuestion> page = new Page<>(pageId, 30);
        QueryWrapper<TbQuestion> wrapper = new QueryWrapper<>();
        //根据专家名字搜索当前用户提出的问题
        wrapper.lambda().like(TbQuestion::getExpertName, keys);
        Page<TbQuestion> queryPageUser = tbQuestionService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }
    //专家列表
    @RequestMapping("/findExpert/{pageNum}")
    public Result<Page> findExpert(@PathVariable Integer pageNum) {
        Page<TbExpert> page = new Page<>(pageNum, 30);
        QueryWrapper<TbExpert> wrapper = new QueryWrapper<>();
        wrapper.lambda().ne(TbExpert::getRealName, "");
        Page<TbExpert> queryPageUser = tbExpertService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }
    //问答详情
    @RequestMapping("/selectId/{questionId}")//   question/selectId/2
    public Result<TbQuestion> selectId(@PathVariable Integer questionId) {
        try {
            TbQuestion tbQuestion = tbQuestionService.getById(questionId);
            return new Result(true, 200, null, tbQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, 500, "系统异常，请您联系管理员！服务热线：0755-xxxx", null);
        }
    }
    //根据姓名查询专家
    @RequestMapping("/findExpertByKeys/{RealName}/{pageId}")
    public Result<Page> findExpertByKeys(@PathVariable String RealName, @PathVariable Integer pageId) {
        Page<TbExpert> page = new Page<>(pageId, 30);
        QueryWrapper<TbExpert> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(TbExpert::getRealName, RealName);
        Page<TbExpert> queryPageUser = tbExpertService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //新增问题
    @PostMapping("/add")
    @Transactional
    public Result<TbQuestion> add(@RequestBody TbQuestion tbQuestion) {
        System.out.println(tbQuestion.toString());
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbQuestion newQuestion = tbQuestion;
        newQuestion.setQuestioner(username);
        tbQuestionService.save(newQuestion);
        return new Result(true, StatusCode.OK, "添加成功", newQuestion);
    }
    // 根据用户名查询问答  kind：普通用户：questioner；专家：expert
    @GetMapping("/selectByKind/{role}")
    @Transactional
    public Result<Page> selectByKind(@PathVariable String role) {
        Page<TbQuestion> page = new Page<>(1, 30);
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
      if (role.equals("questioner")){
          QueryWrapper<TbQuestion> wrapper = new QueryWrapper<>();
          wrapper.lambda().eq(TbQuestion::getQuestioner, username);
          Page<TbQuestion> questionPage = tbQuestionService.page(page,wrapper);
          return new Result(true, StatusCode.OK, "查询成功", questionPage);
      }else if (role.equals("expert")){
          QueryWrapper<TbQuestion> wrapper = new QueryWrapper<>();
          wrapper.lambda().eq(TbQuestion::getExpertName, username);
          Page<TbQuestion> questionPage = tbQuestionService.page(page,wrapper);
          return new Result(true, StatusCode.OK, "查询成功", questionPage);
      }
        return new Result(true, StatusCode.OK, "没有问答记录", "没有问答记录");
    }
    //修改问题
    @PutMapping("/update")
    @Transactional
    public Result<TbQuestion> updateQuestion(@RequestBody TbQuestion tbQuestion) {
        System.out.println(tbQuestion.toString());
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
         tbQuestionService.updateById(tbQuestion);
        return new Result(true, StatusCode.OK, "修改问题成功", "修改问题成功");
    }

    //根据id删除问题
    @DeleteMapping("/delete/{QuestionId}")
    @Transactional
    public Result<TbQuestion> deleteQuestion(@PathVariable Integer QuestionId) {
        System.out.println(QuestionId.toString());
        //获取当前登录的用户名 通过Spring Security 获取
        tbQuestionService.removeById(QuestionId);
        return new Result(true, StatusCode.OK, "删除问题成功", "删除问题成功");
    }

}
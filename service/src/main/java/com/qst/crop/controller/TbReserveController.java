package com.qst.crop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.TbAddress;
import com.qst.crop.entity.TbOrder;
import com.qst.crop.entity.TbQuestion;
import com.qst.crop.entity.TbReserve;
import com.qst.crop.service.ITbReserveService;
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
 * 专家预约表 前端控制器
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
@RestController
@RequestMapping("/reserve")
public class TbReserveController{
    @Autowired
    private ITbReserveService tbReserveService;
    private String prefix = "system/pages/";
    /**
     * @描述 专家预约
     */

    // 根据用户名查询预约  kind：普通用户：questioner；专家：expert
    @GetMapping("/selectByKind/{role}")
    @Transactional
    public Result<Page> selectByKind(@PathVariable String role) {
        Page<TbReserve> page = new Page<>(1, 30);
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (role.equals("questioner")){
            QueryWrapper<TbReserve> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbReserve::getQuestioner, username);
            Page<TbReserve> questionPage = tbReserveService.page(page,wrapper);
            return new Result(true, StatusCode.OK, "查询成功", questionPage);
        }else if (role.equals("expert")){
            QueryWrapper<TbReserve> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbReserve::getExpertName, username);
            Page<TbReserve> questionPage = tbReserveService.page(page,wrapper);
            return new Result(true, StatusCode.OK, "查询成功", questionPage);
        }
        return new Result(true, StatusCode.OK, "没有预约记录", "没有预约记录");
    }

    //添加预约
    @PostMapping("/add")
    @Transactional
    public Result<TbReserve> add(@RequestBody TbReserve tbReserve) {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbReserve newReserve = tbReserve;
        newReserve.setQuestioner(username);
        tbReserveService.save(newReserve);
        return new Result(true, StatusCode.OK, "添加成功", newReserve);
    }
    //修改问题
    @PutMapping("/update")
    @Transactional
    public Result<TbReserve> updateReserve(@RequestBody TbReserve tbReserve) {
        System.out.println(tbReserve.toString());
        tbReserveService.updateById(tbReserve);
        return new Result(true, StatusCode.OK, "修改问题成功", "修改问题成功");
    }

    //根据id删除问题
    @DeleteMapping("/delete/{ReserveId}")
    @Transactional
    public Result<TbQuestion> deleteReserve(@PathVariable Integer ReserveId) {
        System.out.println(ReserveId.toString());
        //获取当前登录的用户名 通过Spring Security 获取
        tbReserveService.removeById(ReserveId);
        return new Result(true, StatusCode.OK, "删除问题成功", "删除问题成功");
    }

}
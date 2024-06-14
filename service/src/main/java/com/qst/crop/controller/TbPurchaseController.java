package com.qst.crop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.TbPurchase;
import com.qst.crop.service.ITbPurchaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
@RestController
@RequestMapping("/purchase")
public class TbPurchaseController {
    @Autowired
    private ITbPurchaseService tbPurchaseService;
    private String prefix = "system/pages/";
    /**
     * @描述 列表页面
     */
//    @RequestMapping("/{pageId}")
//    public Result<Page> getPage(@PathVariable Integer pageId) {
//        Page<TbPurchase> page = new Page<>(pageId,30);
//        QueryWrapper<TbPurchase> wrapper = new QueryWrapper<>();
//        Page<TbPurchase> queryPageUser = tbPurchaseService.page(page,wrapper);
//        return new Result<Page>(true, StatusCode.OK,"查询成功",queryPageUser);
//    }
}
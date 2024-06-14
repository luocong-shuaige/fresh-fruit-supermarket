package com.qst.crop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.*;
import com.qst.crop.service.*;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@RestController
@RequestMapping("/cart")
public class TbShoppingcartController {
    @Autowired
    private ITbShoppingcartService tbShoppingcartService;
    @Autowired
    private ITbOrderService tbOrderService;
    @Autowired
    private ITbPurchaseService tbPurchaseService;
    @Autowired
    ITbPurchaseDetailService tbPurchaseDetailService;
    @Autowired
    ITbSellPurchaseService tbSellPurchaseService;
    private String prefix = "system/pages/";

    /**
     * @描述 购物车
     */

    // 展示购物车列表
    @RequestMapping("/show")
    public Result<TbShoppingcartBean> show() {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<TbShoppingcartBean> tbShoppingcartBean = tbShoppingcartService.selectBeanByUsername(username);
        return new Result(true, StatusCode.OK, "查询成功", tbShoppingcartBean);

    }

    // 更新商品数量
    @PutMapping("/update/{id}/{count}")
    @Transactional
    public Result<TbShoppingcart> updateCount(@PathVariable Integer id, @PathVariable Integer count) {
        System.out.println("id:" + id + "数量：" + count + "***********************");
        TbShoppingcart tbShoppingcart = tbShoppingcartService.getById(id);
        tbShoppingcart.setCount(count);
        tbShoppingcart.setUpdateTime(LocalDateTime.now());
        tbShoppingcartService.updateById(tbShoppingcart);
        //tbShoppingcart.setCount(tbShoppingcart.getCount()+1);
        return new Result(true, StatusCode.OK, "添加成功", tbShoppingcart);
    }

    // 添加购物车
    @PostMapping("/add/{order_id}")
    @Transactional
    public Result<TbShoppingcart> addShoppingcarte(@PathVariable Integer order_id) {
        System.out.println(order_id.toString());
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbShoppingcart shoppingcar = tbShoppingcartService.getShoppingcarId(order_id, username);
        if (shoppingcar == null) {
            TbShoppingcart tbShoppingcart = new TbShoppingcart();
            tbShoppingcart.setOrderId(order_id);
            tbShoppingcart.setCount(1);
            tbShoppingcart.setOwnName(username);
            tbShoppingcart.setCreateTime(LocalDateTime.now());
            tbShoppingcart.setUpdateTime(LocalDateTime.now());
            tbShoppingcartService.save(tbShoppingcart);
            return new Result(true, StatusCode.OK, "添加成功", tbShoppingcart);
        } else {
            int count = shoppingcar.getCount() + 1;
            shoppingcar.setCount(count);
            tbShoppingcartService.updateById(shoppingcar);
        }
        return new Result(true, StatusCode.OK, "添加成功", shoppingcar);
    }

    //移除购物车
    @DeleteMapping("/delete/{ShoppingcartId}")
    public Result<TbShoppingcart> delete(@PathVariable Integer ShoppingcartId) {
        tbShoppingcartService.removeById(ShoppingcartId);
        return new Result(true, StatusCode.OK, "删除成功", "删除成功");
    }

    //订单生成
    //步骤1.成订单表 2.生成订单详情表 3.删除购物车
    @PostMapping("/commitOrder/{addressId}/{tMoney}")
    public Result<TbShoppingcart> commitOrder(@PathVariable String addressId, @PathVariable BigDecimal tMoney
            , @RequestBody List<TbShoppingcartBean> tbShoppingcartBeans) {
        TbPurchase tbPurchase = tbPurchaseService.addPurchase(addressId, tMoney);
        List<TbPurchaseDetail> list = tbPurchaseDetailService.addPurchaseDetail(tbPurchase, tbShoppingcartBeans);
        List<TbSellPurchase> list2 = tbSellPurchaseService.addTbSellPurchase(tbPurchase, tbShoppingcartBeans, addressId);
        return new Result(true, StatusCode.OK, "添加成功", "添加成功");
    }
}
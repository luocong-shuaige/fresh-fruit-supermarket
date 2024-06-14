package com.qst.crop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbOrderBean;
import com.qst.crop.beans.TbSellPurchaseBean;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.TbOrder;
import com.qst.crop.entity.TbPurchase;
import com.qst.crop.entity.TbSellPurchase;
import com.qst.crop.entity.TbUser;
import com.qst.crop.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@RestController
@RequestMapping("/order")
public class TbOrderController {
    @Autowired
    private ITbOrderService tbOrderService;
    @Autowired
    private ITbPurchaseService tbPurchaseService;
    @Autowired
    private ITbSellPurchaseService tbSellPurchaseService;
    @Autowired
    private ITbAddressService tbAddressService;
    @Autowired
    private ITbUserService tbUserService;

    private String prefix = "system/pages/";

    //查询所有商品和求购信息
    @RequestMapping("/All/{pageId}")
    public Result<Page> All(@PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
        wrapper.lambda().ne(TbOrder::getType, "").eq(TbOrder::getOrderStatus, 0);
        Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
        //return queryPageUser;
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //商品货源展示
    @RequestMapping("/goods/{pageId}")
    public Result<Page> goods(@PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbOrder::getType, "goods")
                .eq(TbOrder::getOrderStatus, 0)
                .orderByDesc(TbOrder::getCreateTime);
        Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
        //return queryPageUser;
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //求购需求展示
    @RequestMapping("/needs/{current}")
    public Result<Page> needs(@PathVariable Integer current) {
        Page<TbOrder> page = new Page<>(current, 30);
        QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbOrder::getType, "needs").eq(TbOrder::getOrderStatus, 0);
        Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //根据id获取商品/需求信息
    @RequestMapping("/selectById/{orderidId}")//   order/selectById/23
    // @GetMapping("/selectById/{orderidId}")
    public Result<TbOrder> selectById(@PathVariable Integer orderidId) {
        try {
            TbOrder order = tbOrderService.getById(orderidId);
            return new Result(true, 200, null, order);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, 500, "系统异常，请您联系管理员！服务热线：0755-xxxx", null);
        }
    }

    //商品货源搜索功能
    @RequestMapping("/searchGoodsByKeys/{keys}/{pageId}")
    public Result<Page> searchGoodsByKeys(@PathVariable String keys, @PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(TbOrder::getTitle, keys).eq(TbOrder::getType, "goods");
        Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //首页搜索功能
    @RequestMapping("/searchAllByKeys/{keys}/{pageId}")
    public Result<Page> searchAllByKeys(@PathVariable String keys, @PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(TbOrder::getTitle, keys).eq(TbOrder::getOrderStatus, 0);
        Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //求购搜索功能
    @RequestMapping("/searchNeedsByKeys/{keys}/{pageId}")
    public Result<Page> searchNeedsByKeys(@PathVariable String keys, @PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(TbOrder::getTitle, keys).eq(TbOrder::getType, "needs");
        Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //根据登录用户+订单类型查询订单
    @GetMapping("/searchMyGoodsByKeys/{goods}/{pageId}")
    public Result<Page> searchMyGoodsByKeys(@PathVariable String goods, @PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (username.equals("admin")) {
            QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbOrder::getType, goods);
            Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
            return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
        } else {
            QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbOrder::getType, goods).eq(TbOrder::getOwnName, username);
            Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
            return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
        }
    }

    //根据登录用户+订单类型查询订单
    @GetMapping("/searchMyNeedsByKeys/{needs}/{pageId}")
    public Result<Page> searchMyNeedsByKeys(@PathVariable String needs, @PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (username.equals("admin")) {
            QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbOrder::getType, needs);
            Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
            return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
        } else {
            QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbOrder::getType, needs).eq(TbOrder::getOwnName, username);
            Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
            return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
        }
    }

    @GetMapping("/search/{ctype}/{pageId}")
    public Result<Page> search(@PathVariable String ctype, @PathVariable Integer pageId) {
        Page<TbOrder> page = new Page<>(pageId, 30);
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (username.equals("admin")) {
            QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbOrder::getType, ctype);
            Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
            return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
        } else {
            QueryWrapper<TbOrder> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(TbOrder::getType, ctype).eq(TbOrder::getOwnName, username);
            Page<TbOrder> queryPageUser = tbOrderService.page(page, wrapper);
            return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
        }
    }

    //根据order_id修改商品信息
    @PutMapping("/{order_id}")
    @Transactional
    public Result<TbOrder> updateOrderByOrderId(@PathVariable String order_id, @RequestBody TbOrder params) {
        TbOrder tbOrder = tbOrderService.selectByOrderId(order_id);
        tbOrder.setTitle(params.getTitle());
        tbOrder.setPicture(params.getPicture());
        tbOrder.setContent(params.getContent());
        tbOrder.setPrice(params.getPrice());
        tbOrder.setUpdateTime(LocalDateTime.now());
        tbOrderService.updateById(tbOrder);
        return new Result(true, StatusCode.OK, "修改成功", tbOrder);
    }

    //根据order_id删除商品
    @DeleteMapping("/{order_id}")
    public Result<TbOrder> deleteOrderByOrderId(@PathVariable String order_id) {
        TbOrder tbOrder = tbOrderService.selectByOrderId(order_id);
        tbOrderService.removeById(tbOrder);
        return new Result(true, StatusCode.OK, "删除成功", tbOrder);
    }

    //商品上架
    @PutMapping("/takeUpOrder/{item}")
    @Transactional
    public Result<TbOrder> takeUpOrder(@PathVariable String item) {
        TbOrder tbOrder = tbOrderService.selectByOrderId(item);
        tbOrder.setOrderStatus(0);
        tbOrder.setUpdateTime(LocalDateTime.now());
        tbOrderService.updateById(tbOrder);

        return new Result(true, StatusCode.OK, "上架成功", tbOrder);
    }

    //商品下架
    @PutMapping("/takeDownOrder/{item}")
    @Transactional
    public Result<TbOrder> takeDownOrder(@PathVariable String item) {
        TbOrder tbOrder = tbOrderService.selectByOrderId(item);
        tbOrder.setOrderStatus(1);
        tbOrder.setUpdateTime(LocalDateTime.now());
        tbOrderService.updateById(tbOrder);

        return new Result(true, StatusCode.OK, "下架成功", tbOrder);
    }

    //商品添加
    @PostMapping
    @Transactional
    public Result<TbOrder> addOrder(@RequestBody TbOrder tbOrder) {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        tbOrder.setOwnName(username);
        TbOrder newOrder = tbOrderService.AddNewOrder(tbOrder);
        return new Result(true, StatusCode.OK, "添加成功", newOrder);
    }

    //根据登陆用户查询我买的订单
    @GetMapping("/selectBuys")
    public Result<TbPurchase> selectBuys() {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        QueryWrapper<TbPurchase> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbPurchase::getOwnName, username);
        List<TbPurchase> queryPageUser = tbPurchaseService.list(wrapper);
        for (TbPurchase tp:queryPageUser) {
            String address = tbAddressService.getAddress(tp.getAddress());
            tp.setAddress(address);
        }
        return new Result(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //根据登陆用户查询我卖的订单
    @GetMapping("/selectSells")
    public Result<TbSellPurchase> selectSells() {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        QueryWrapper<TbSellPurchase> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbSellPurchase::getOwnName, username);
        List<TbSellPurchase> queryPageUser = tbSellPurchaseService.list(wrapper);
        List<TbSellPurchaseBean> listtb = new ArrayList<>();
        for (TbSellPurchase tsp:queryPageUser) {
            String address = tbAddressService.getAddress(tsp.getAddress());
            TbPurchase tbPurchase = tbPurchaseService.getById(tsp.getPurchaseId());
            TbUser tbUser = tbUserService.getById(tbPurchase.getOwnName());
            String phone = tbUser.getPhone();
            TbSellPurchaseBean tbSellPurchaseBean = new TbSellPurchaseBean();
            tbSellPurchaseBean.setPhone(phone);
            tbSellPurchaseBean.setOwnName(tbPurchase.getOwnName());
            tbSellPurchaseBean.setOwnName(tbPurchase.getOwnName());
            tbSellPurchaseBean.setSellPurchaseId(tsp.getSellPurchaseId());
            tbSellPurchaseBean.setCreateTime(tsp.getCreateTime());
            tbSellPurchaseBean.setUpdateTime(tsp.getUpdateTime());
            tbSellPurchaseBean.setSumPrice(tsp.getSumPrice());
            tbSellPurchaseBean.setAddress(address);
            listtb.add(tbSellPurchaseBean);
        }
        return new Result(true, StatusCode.OK, "查询成功", listtb);
    }
}
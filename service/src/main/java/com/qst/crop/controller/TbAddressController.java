package com.qst.crop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbAddressBean;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.*;
import com.qst.crop.service.ITbAddressService;
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
 *  前端控制器
 * </p>
 * @author guotao
 * @since 2024-01-28
 */
@RestController
@RequestMapping("/address")
public class TbAddressController {
    @Autowired
    private ITbAddressService tbAddressService;
    private String prefix = "system/pages/";
    /**
     * @描述 用户地址
     */

   //根据用户名查询地址
    @RequestMapping("/selectByOwnName")
    public Result<TbAddress> selectByOwnName() {
        //获取当前登录的用户名 通过Spring Security 获取
        Page<TbAddress> page = new Page<>(1, 10);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        QueryWrapper<TbAddress> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbAddress::getOwnName, username);
        Page<TbAddress> queryPageUser = tbAddressService.page(page, wrapper);
        return new Result (true, StatusCode.OK, "查询成功", queryPageUser);
    }
    //根据用户名查询默认地址
    @RequestMapping("/selectDefaultByOwnName")
    public Result<Page> selectDefaultByOwnName() {
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        QueryWrapper<TbAddress> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TbAddress::getOwnName, username).eq(TbAddress::getIsDefault,1);
       TbAddress tbAddress= tbAddressService.getOne(wrapper);
        return new Result(true, StatusCode.OK, "查询成功", tbAddress);
    }

    @PutMapping("/addAddress")
    @Transactional
    public Result<TbAddress> addAddress(@RequestBody TbAddressBean tbAddressBean) {
        System.out.println(tbAddressBean.toString());
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbAddress tbAddress = new TbAddress(tbAddressBean.getId(),username,tbAddressBean.getConsignee(),
                tbAddressBean.getPhone(),tbAddressBean.getAddressDetail(),null);
        if (tbAddressBean.getIsDefault()){
            tbAddress.setIsDefault(1);
        }else {
            tbAddress.setIsDefault(0);
        }
        tbAddressService.save(tbAddress);
        return new Result(true, StatusCode.OK, "添加成功", "添加成功");
    }

    //根据addressId删除地址
    @DeleteMapping("/delete/{addressId}")
    public Result<TbAddress> delete(@PathVariable Integer addressId) {
        TbAddress tbAddress = tbAddressService.getById(addressId);
        tbAddressService.removeById(tbAddress);
        return new Result(true, StatusCode.OK, "删除成功", tbAddress);
    }
    //修改默认地址
    @PostMapping("/defaultAddressInfoUpdate")
    @Transactional
    public Result<TbAddress> defaultAddressInfoUpdate(@RequestBody TbAddressBean tbAddressBean) {
        System.out.println(tbAddressBean.toString());
        //获取当前登录的用户名 通过Spring Security 获取
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbAddress tbAddress = new TbAddress(tbAddressBean.getId(),username,tbAddressBean.getConsignee(),
                tbAddressBean.getPhone(),tbAddressBean.getAddressDetail(),null);
        if (tbAddressBean.getIsDefault()){
            tbAddress.setIsDefault(1);
        }else {
            tbAddress.setIsDefault(0);
        }
       tbAddressService.updateById(tbAddress);
        return new Result(true, StatusCode.OK, "添加成功", "添加成功");
    }

}
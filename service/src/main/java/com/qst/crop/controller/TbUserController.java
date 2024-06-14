package com.qst.crop.controller;

import com.alipay.api.domain.UserDetails;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbOrderBean;
import com.qst.crop.beans.TbUserBean;
import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.*;
import com.qst.crop.service.ITbExpertService;
import com.qst.crop.service.ITbUserService;
import io.swagger.annotations.ApiOperation;
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

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/user")
public class TbUserController {
    @Autowired
    private ITbUserService tbUserService;
    @Autowired
    private ITbExpertService tbExpertService;

    private String prefix = "system/pages/";


    //用户登录之后，根据用户名展示个人信息
    @ApiOperation(value = "用户登录之后，根据用户名展示个人信息")
    @GetMapping("/loginSelectByUsername")
    public Result<TbUser> loginSelectByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // UserDetails principal = (UserDetails) authentication.getPrincipal();
        //String username = principal.getUserName();
        String username = authentication.getName();
        TbUser user = tbUserService.selectByUserName(username);

        return new Result(true, StatusCode.OK, "查询成功", user);
    }

    //更新用户（个人）信息
    @PostMapping("/loginUpdateByUsername")
    public Result<TbUser> loginUpdateByUsername(@RequestBody TbUser params) {
        TbUser user = tbUserService.selectByNickName(params.getNickName());
        if (user == null) {
            return new Result(false, StatusCode.ERROR, "用户不存在", null);
        }
        user.setNickName(params.getNickName());
        user.setPhone(params.getPhone());
        user.setIdentityNum(params.getIdentityNum());
        user.setAddress(params.getAddress());
        user.setAvatar(params.getAvatar());
        user.setRealName(params.getRealName());
        user.setUpdateTime(LocalDateTime.now());
        System.out.println(user.toString() + "*********************");
        tbUserService.updateById(user);
        // nickName=管理员, phone=17894286579, identityNum=370343199612012718, address=山654544,
        //avatar=c8c855f1825146eea5ae2ce11e3538fa.jpg, realName=张三33
        return new Result(true, StatusCode.OK, "更新成功", user);
    }

    //修改密码
    @PostMapping("/loginUpdatePassword")
    public Result<TbUser> loginUpdatePassword(@RequestBody UserPassword userPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //passwordEncoder.encode(userPassword.getOldPassword());
        // userPassword.setOldPassword(passwordEncoder.encode(userPassword.getOldPassword()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbUser user = tbUserService.selectByUserName(username);
        boolean isMatch = passwordEncoder.matches(userPassword.getOldPassword(), user.getPassword());
        if (isMatch) {
            user.setPassword(passwordEncoder.encode(userPassword.getNewPassword()));
            user.setUpdateTime(LocalDateTime.now());
            tbUserService.updateById(user);
            return new Result(true, StatusCode.OK, "修改成功", user);
        } else {
            return new Result(false, StatusCode.ERROR, "原密码不一致，修改失败", "原密码不一致，修改失败");
        }
    }

    //管理员查询所有用户
    @RequestMapping("/search/{pageId}")
    public Result<Page> search(@PathVariable Integer pageId) {
        Page<TbUser> page = new Page<>(pageId, 30);
        QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().ne(TbUser::getUserName, "");
        Page<TbUser> queryPageUser = tbUserService.page(page, wrapper);
        return new Result<Page>(true, StatusCode.OK, "查询成功", queryPageUser);
    }

    //管理员根据用户名查询信息回显到表单
    @GetMapping("/{userName}")
    @Transactional
    public Result<TbUser> selectUserByUsername(@PathVariable String userName) {
        TbUser user = tbUserService.selectByUserName(userName);
        return new Result(true, StatusCode.OK, "查询成功", user);
    }

    //用户注册
    @PostMapping("/add")
    @Transactional
    public Result<TbUser> add(@RequestBody TbUser params) {
        TbUser user = tbUserService.selectByUserName(params.getUserName());
        if (user == null) {
            // //密码加密
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            params.setPassword(passwordEncoder.encode(params.getPassword()));
            TbUser newuser = tbUserService.AddUser(params);
            return new Result(true, StatusCode.OK, "注册成功", newuser);

        } else {
            return new Result(true, StatusCode.OK, "用户名已存在,请重新注册", user);
        }
    }

    //管理员根据用户名修改用户信息
    @PutMapping("/{user_name}")
    @Transactional
    public Result<TbUser> updateUserByUsername(@PathVariable String user_name, @RequestBody TbUser params) {
        TbUser user1 = tbUserService.selectByUserName(user_name);
        user1.setNickName(params.getNickName());
        user1.setPhone(params.getPhone());
        user1.setIdentityNum(params.getIdentityNum());
        user1.setAddress(params.getAddress());
        user1.setUpdateTime(LocalDateTime.now());
        user1.setRole(params.getRole());
        tbUserService.updateById(user1);
        return new Result(true, StatusCode.OK, "修改成功", user1);
    }

    //管理员根据用户名删除用户
    @DeleteMapping("/{userName}")
    public Result<TbUser> deleteUserByUsername(@PathVariable String userName) {
        TbUser user = tbUserService.selectByUserName(userName);
        tbUserService.removeById(user);
        return new Result(true, StatusCode.OK, "删除成功", user);
    }

    //专家登录后查询专家信息
    @GetMapping("/searchexpert")
    public Result<TbExpert> searchexpert() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbExpert tbExpert = tbExpertService.getById(username);
        return new Result(true, StatusCode.OK, "查询成功", tbExpert);
    }

    //专家登录后修改专家信息
    @PostMapping("/addUpdexpert")
    public Result<TbExpert> addUpdexpert(@RequestBody TbExpert tbExpert) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        TbExpert tbExpert1 = tbExpertService.getById(username);
        if (tbExpert1 == null) {
            tbExpert.setUserName(username);
            tbExpertService.save(tbExpert);
            TbUser tbUser = tbUserService.getById(tbExpert.getUserName());
            tbUser.setPhone(tbExpert.getPhone());
            tbUser.setRealName(tbExpert.getRealName());
            tbUser.setUpdateTime(LocalDateTime.now());
            tbUserService.updateById(tbUser);
            return new Result(true, StatusCode.OK, "修改成功", "修改成功");
        } else {
            TbUser tbUser = tbUserService.getById(tbExpert.getUserName());
            tbUser.setPhone(tbExpert.getPhone());
            tbUser.setRealName(tbExpert.getRealName());
            tbUser.setUpdateTime(LocalDateTime.now());
            tbUserService.updateById(tbUser);
            tbExpertService.updateById(tbExpert);
            return new Result(true, StatusCode.OK, "修改成功", "修改成功");
        }
    }
}
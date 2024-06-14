package com.qst.crop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qst.crop.entity.TbUser;
import com.qst.crop.dao.TbUserMapper;
import com.qst.crop.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

    @Autowired
    private ITbUserService tbUserService;
    @Override
    public TbUser selectByUserName(String name) {
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper.lambda().eq(TbUser::getUserName,name);
        TbUser tbUser = this.getOne(tbUserQueryWrapper);
        return tbUser;
    }

    @Override
    public TbUser selectByNickName(String nickName) {
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper.lambda().eq(TbUser::getNickName,nickName);
        TbUser tbUser = this.getOne(tbUserQueryWrapper);
        return tbUser;
    }

    @Override
    public TbUser AddUser(TbUser params) {
        TbUser tbUser  = new TbUser(params.getUserName(),params.getPassword(),params.getNickName(),null,
                null,null,"user", LocalDateTime.now(),LocalDateTime.now(),500,5,params.getAvatar(),null);
        tbUserService.save(tbUser);
       return tbUser;
    }

}

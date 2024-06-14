package com.qst.crop.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qst.crop.beans.TbShoppingcartBean;
import com.qst.crop.entity.TbShoppingcart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static net.sf.jsqlparser.parser.feature.Feature.select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guotao
 * @since 2024-01-28
 */
@Mapper
public interface TbShoppingcartMapper extends BaseMapper<TbShoppingcart> {

    @Select("SELECT tb_shoppingcart.shopping_id,tb_shoppingcart.order_id,tb_shoppingcart.own_name,tb_shoppingcart.count,\n" +
            "tb_shoppingcart.create_time,tb_shoppingcart.update_time,tb_order.title,tb_order.price,tb_order.content,tb_order.picture\n" +
            "FROM tb_shoppingcart\n" +
            "JOIN tb_order ON tb_shoppingcart.order_id = tb_order.order_id\n" +
            "WHERE tb_shoppingcart.own_name = #{username}")
    List<TbShoppingcartBean> selectListByUserName(String username);
}

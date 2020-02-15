package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/13 12:49
 */
public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category, Long>{

}

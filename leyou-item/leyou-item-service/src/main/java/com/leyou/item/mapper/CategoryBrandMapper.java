package com.leyou.item.mapper;

import com.leyou.item.pojo.CategoryBrand;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author xu7777777
 * @date 2020/3/9 8:13 PM
 */
public interface CategoryBrandMapper extends Mapper<CategoryBrand>, SelectByIdListMapper<CategoryBrand, Long> {
}

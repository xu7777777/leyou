package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategoryBrandMapper;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import com.leyou.item.pojo.CategoryBrand;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/13 16:44
 */
@Service
public class BrandService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private BrandMapper brandMapper;

    @Resource
    private CategoryBrandMapper categoryBrandMapper;

    /**
     * 根据查询条件分页并排序查询品牌信息
     *
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {

        // 初始化example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        // 根据name模糊查询，或者根据首字母查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        // 添加分页条件
        PageHelper.startPage(page, rows);

        // 添加排序条件
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }

        List<Brand> brands = this.brandMapper.selectByExample(example);
        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新增品牌对象
     *
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBranch(Brand brand, List<Long> cids) {
        //先新增brand再新增中间表
        this.brandMapper.insertSelective(brand);

        //如果brand插入成功则新增中间表
        cids.forEach(cid -> {
            this.brandMapper.insertCategoryAndBrand(cid, brand.getId());
        });
    }

    /**
     * 根据分类的id查询品牌列表
     * @param cid
     * @return
     */
    public List<Brand> queryBrandsByCid(Long cid) {
        return this.brandMapper.selectBrandsByCid(cid);
    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    public Brand queryBrandById(Long id) {// ================ 检查这部分代码是否存在sql注入等。
        //这里使用简单的连表查询可能会更好，而且前端应该再加一个分类标签，将当前的分类显示出来
        Brand brand = this.brandMapper.selectByPrimaryKey(id);
        /*
        Example categoryExample = new Example(CategoryBrand.class);
        Example.Criteria categoryEC = categoryExample.createCriteria();

        categoryEC.andEqualTo("brandId", id);
        CategoryBrand categoryBrand = this.categoryBrandMapper.selectOneByExample(categoryExample);
        Category category = this.categoryMapper.selectByPrimaryKey(categoryBrand.getCategoryId());

        brand.setName(category.getName());
        */
        return brand;
    }

    public void delBrandById(Long bid) {
        this.brandMapper.deleteByPrimaryKey(bid);
    }
}
package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/16 18:34
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {

}

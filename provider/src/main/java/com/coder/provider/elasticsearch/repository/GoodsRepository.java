package com.coder.provider.elasticsearch.repository;

import com.coder.provider.elasticsearch.model.GoodsInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.com.coder.elasticsearch.repository
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/4
 */
@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo,Long> {
}
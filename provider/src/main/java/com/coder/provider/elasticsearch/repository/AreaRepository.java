package com.coder.provider.elasticsearch.repository;

import com.coder.provider.elasticsearch.model.Area;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Configuration
public interface AreaRepository extends ElasticsearchRepository<Area,Integer> {
}

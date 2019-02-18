package com.coder.provider.elasticsearch.repository;

import com.coder.provider.elasticsearch.model.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Configuration
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}

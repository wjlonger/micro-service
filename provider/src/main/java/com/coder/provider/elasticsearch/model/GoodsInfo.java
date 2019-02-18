package com.coder.provider.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName="elasticsearch",
        type="goodsinfo",
        indexStoreType="fs",
        shards=5,
        replicas=1,
        refreshInterval="-1")
public class GoodsInfo implements Serializable {

    private static final long serialVersionUID = -1678610371018406737L;

    @Id
    private Long id;

    @Field(analyzer="ik",searchAnalyzer="ik")
    private String name;

    @Field(analyzer="ik",searchAnalyzer="ik")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

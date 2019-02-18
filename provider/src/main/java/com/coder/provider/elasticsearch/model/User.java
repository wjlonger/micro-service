package com.coder.provider.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @ClassName: Search
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lr
 * @date 2018年12月5日 下午4:58:50
 *
 */
@Document(indexName="elasticsearch",
        type="goodsinfo",
        indexStoreType="fs",
        shards=5,
        replicas=1,
        refreshInterval="-1")
public class User implements Serializable {

    private static final long serialVersionUID = 5188196737727624620L;

    /** 编号 */
    @Id
    private Long id;

    /** 姓名 */
    @Field(analyzer = "ik", searchAnalyzer = "ik")
    private String name;

    /** 年龄 */
    private Integer age;

    /** 描述 */
    @Field(analyzer = "ik", searchAnalyzer = "ik")
    private String description;

    /** 创建时间 */
    private String createtm;


    public User(){
    }


    public User(Long id, String name, Integer age, String description, String createtm) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.createtm = createtm;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", description=" + description + ", createtm="
                + createtm + "]";
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatetm() {
        return createtm;
    }

    public void setCreatetm(String createtm) {
        this.createtm = createtm;
    }
}
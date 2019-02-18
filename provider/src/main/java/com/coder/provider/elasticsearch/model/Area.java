package com.coder.provider.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import java.io.Serializable;

/**
 * 区域数据
 * Spring Data通过注解来声明字段的映射属性，有下面的三个注解：
 *
 * @Document 作用在类，标记实体类为文档对象，一般有两个属性
 * indexName：对应索引库名称
 * type：对应在索引库中的类型
 * shards：分片数量，默认5
 * replicas：副本数量，默认1
 * @Id 作用在成员变量，标记一个字段作为id主键
 * @Field 作用在成员变量，标记为文档的字段，并指定字段映射属性：
 * type：字段类型，是枚举：FieldType，可以是text、long、short、date、integer、object等
 * text：存储数据时候，会自动分词，并生成索引
 * keyword：存储数据时候，不会分词建立索引
 * Numerical：数值类型，分两类
 * 基本数据类型：long、interger、short、byte、double、float、half_float
 * 浮点数的高精度类型：scaled_float
 * 需要指定一个精度因子，比如10或100。elasticsearch会把真实值乘以这个因子后存储，取出时再还原。
 * Date：日期类型
 * elasticsearch可以对日期格式化为字符串存储，但是建议我们存储为毫秒值，存储为long，节省空间。
 * index：是否索引，布尔类型，默认是true
 * store：是否存储，布尔类型，默认是false
 * analyzer：分词器名称，这里的ik_max_word即使用ik分词器
 * ---------------------
 * 作者：我要取一个响亮的昵称
 * 来源：CSDN
 * 原文：https://blog.csdn.net/chen_2890/article/details/83895646
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
@Document(indexName="elasticsearch",type="area",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Area implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private Long id;
    private Long pid;//父id
    @Field(analyzer="ik",searchAnalyzer="ik")
    private String  shortname;//简称
    @Field(analyzer="ik",searchAnalyzer="ik")
    private String  name;//名称
    @Field(analyzer="ik",searchAnalyzer="ik")
    private String  mergerName;//全称
    private Short   level; //层级 0 1 2 省市区县
    private String  pinyin;//拼音
    private String  code; //长途区号
    private String  zipCode; //邮编
    private String  first; //首字母
    @GeoPointField
    private String  location;//经纬度

    public Area() {
        super();
    }

    public Area(Long id, Long pid, String shortname, String name,
                String mergerName, Short level, String pinyin, String code,
                String zipCode, String first, String location) {
        super();
        this.id = id;
        this.pid = pid;
        this.shortname = shortname;
        this.name = name;
        this.mergerName = mergerName;
        this.level = level;
        this.pinyin = pinyin;
        this.code = code;
        this.zipCode = zipCode;
        this.first = first;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

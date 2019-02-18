package com.coder.provider.controller;


import com.coder.provider.elasticsearch.model.Area;
import com.coder.provider.elasticsearch.model.Book;
import com.coder.provider.elasticsearch.repository.AreaRepository;
import com.coder.provider.elasticsearch.repository.BookRepository;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class AreaController {

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 1、查  id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Area getBookById(@PathVariable Integer id) {
        return areaRepository.findById(id).get();
    }

    /**
     * 2、查  ++:全文检索（根据整个实体的所有属性，可能结果为0个）
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Book> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Book> searchResult = bookRepository.search(builder);
        Iterator<Book> iterator = searchResult.iterator();
        List<Book> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    public List<Book> elasticSerchTest() {

        //1.创建QueryBuilder(即设置查询条件)这儿创建的是组合查询(也叫多条件查询),后面会介绍更多的查询方法
        /*组合查询BoolQueryBuilder
         * must(QueryBuilders)   :AND
         * mustNot(QueryBuilders):NOT
         * should:               :OR
         */
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        //builder下有must、should以及mustNot 相当于sql中的and、or以及not

        //设置模糊搜索,博客的简诉中有学习两个字
        builder.must(QueryBuilders.fuzzyQuery("bookName", "aaa"));

        //设置要查询博客的标题中含有关键字
        builder.must(new QueryStringQueryBuilder("author").field("wujunlong"));

        //按照博客的评论数的排序是依次降低
        FieldSortBuilder sort = SortBuilders.fieldSort("id").order(SortOrder.DESC);

        //设置分页(从第一页开始，一页显示10条)
        //注意开始是从0开始，有点类似sql中的方法limit 的查询
        PageRequest page = PageRequest.of(0, 10);

        //2.构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //将搜索条件设置到构建中
        nativeSearchQueryBuilder.withQuery(builder);
        //将分页设置到构建中
        nativeSearchQueryBuilder.withPageable(page);
        //将排序设置到构建中
        nativeSearchQueryBuilder.withSort(sort);
        //生产NativeSearchQuery
        NativeSearchQuery query = nativeSearchQueryBuilder.build();

        // 单个匹配termQuery
        // 不分词查询 参数1： 字段名，参数2：字段查询值，因为不分词，所以汉字只能查询一个字，英语是一个单词.
        // QueryBuilder queryBuilder = QueryBuilders.termQuery("fieldName", "fieldlValue");
        // 分词查询，采用默认的分词器
        // QueryBuilder queryBuilder2 = QueryBuilders.matchQuery("fieldName", "fieldlValue");

        // 多个匹配
        // 不分词查询，参数1： 字段名，参数2：多个字段查询值,因为不分词，所以汉字只能查询一个字，英语是一个单词.
        // QueryBuilder queryBuilder=QueryBuilders.termsQuery("fieldName", "fieldlValue1","fieldlValue2...");
        // 分词查询，采用默认的分词器
        // QueryBuilder queryBuilder= QueryBuilders.multiMatchQuery("fieldlValue", "fieldName1", "fieldName2", "fieldName3");
        // 匹配所有文件，相当于就没有设置查询条件
        // QueryBuilder queryBuilder=QueryBuilders.matchAllQuery();

        //模糊查询（只要包含即可）
        //模糊查询常见的5个方法如下
        //1.常用的字符串查询
        // QueryBuilders.queryStringQuery("fieldValue").field("fieldName");//左右模糊
        //2.常用的用于推荐相似内容的查询
        // QueryBuilders.moreLikeThisQuery(new String[] {"fieldName"}).addLikeText("pipeidhua");//如果不指定filedName，则默认全部，常用在相似内容的推荐上
        //3.前缀查询  如果字段没分词，就匹配整个字段前缀
        // QueryBuilders.prefixQuery("fieldName","fieldValue");
        //4.fuzzy query:分词模糊查询，通过增加fuzziness模糊属性来查询,如能够匹配hotelName为tel前或后加一个字母的文档，fuzziness 的含义是检索的term 前后增加或减少n个单词的匹配查询
        // QueryBuilders.fuzzyQuery("hotelName", "tel").fuzziness(Fuzziness.ONE);
        //5.wildcard query:通配符查询，支持* 任意字符串；？任意一个字符
        // QueryBuilders.wildcardQuery("fieldName","ctr*");//前面是fieldname，后面是带匹配字符的字符串
        // QueryBuilders.wildcardQuery("fieldName","c?r?");

        //范围查询
        //闭区间查询
        // QueryBuilder queryBuilder0 = QueryBuilders.rangeQuery("fieldName").from("fieldValue1").to("fieldValue2");
        //开区间查询
        // QueryBuilder queryBuilder1 = QueryBuilders.rangeQuery("fieldName").from("fieldValue1").to("fieldValue2").includeUpper(false).includeLower(false);//默认是true，也就是包含
        //大于
        // QueryBuilder queryBuilder2 = QueryBuilders.rangeQuery("fieldName").gt("fieldValue");
        //大于等于
        // QueryBuilder queryBuilder3 = QueryBuilders.rangeQuery("fieldName").gte("fieldValue");
        //小于
        // QueryBuilder queryBuilder4 = QueryBuilders.rangeQuery("fieldName").lt("fieldValue");
        //小于等于
        // QueryBuilder queryBuilder5 = QueryBuilders.rangeQuery("fieldName").lte("fieldValue");

        //组合查询/多条件查询/布尔查询
        // QueryBuilders.boolQuery();
        // QueryBuilders.boolQuery().must();//文档必须完全匹配条件，相当于and
        // QueryBuilders.boolQuery().mustNot();//文档必须不匹配条件，相当于not
        // QueryBuilders.boolQuery().should();//至少满足一个条件，这个文档就符合should，相当于or



        //3.执行方法1
        Page<Book> books = bookRepository.search(query);

        //执行方法2：注意，这儿执行的时候还有个方法那就是使用elasticsearchTemplate
        //执行方法2的时候需要加上注解
        //@Autowired
        //private ElasticsearchTemplate elasticsearchTemplate;
        List<Book> blogList = elasticsearchTemplate.queryForList(query, Book.class);

        //4.获取总条数(用于前端分页)
        int total = (int) books.getTotalElements();

        //5.获取查询到的数据内容（返回给前端）
        List<Book> content = books.getContent();

        return content;
    }

    /**
     * 3、查   +++：分页、分数、分域（结果一个也不少）
     * @param page
     * @param size
     * @param q
     * @return
     * @return
     */
//    @GetMapping("/{page}/{size}/{q}")
//    public List<Book> searchCity(@PathVariable Integer page,
//                                 @PathVariable Integer size,
//                                 @PathVariable String q) {
//        // 分页参数
//        Pageable pageable = PageRequest.of(page,size);
//
//        // 分数，s
//        FunctionScoreQueryBuilder functionScoreQueryBuilder =
//                QueryBuilders.functionScoreQuery()
//                    .add(QueryBuilders.boolQuery()
//                    .should(QueryBuilders.matchQuery("name", q)),
//                ScoreFunctionBuilders.weightFactorFunction(1000)) // 权重：name 1000分
//                    .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("message", q)),
//                ScoreFunctionBuilders.weightFactorFunction(100)); // 权重：message 100分
//
//        // 分数、分页
//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
//
//        Page<Book> searchPageResults = bookRepository.search(searchQuery);
//        return searchPageResults.getContent();
//
//    }

    /**
     * 4、增
     * @param book
     * @return
     */
    @PutMapping("/insert")
    public Book insertBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    /**
     * 5、删 id
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Book insertBook(@PathVariable Integer id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    /**
     * 6、改
     * @param book
     * @return
     */
    @PutMapping("/update")
    public Book updateBook(Book book) {
        bookRepository.save(book);
        return book;
    }

}

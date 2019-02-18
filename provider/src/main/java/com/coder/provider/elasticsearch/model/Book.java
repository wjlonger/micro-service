package com.coder.provider.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName="elasticsearch",
        type="book",
        indexStoreType="fs",
        shards=5,
        replicas=1,
        refreshInterval="-1")
public class Book implements Serializable {

    private static final long serialVersionUID = 1910349036378083664L;

    @Id
    private  Integer id;

    @Field(analyzer = "ik", searchAnalyzer = "ik")
    private  String bookName;

    @Field(analyzer = "ik", searchAnalyzer = "ik")
    private  String author;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
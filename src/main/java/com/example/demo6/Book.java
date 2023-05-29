package com.example.demo6;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Book implements Serializable {
    private final String name;
    private final int author;
    private final int pageSize;
    private final float publication;
    private final int price;

    @JsonCreator
    public Book(
            @JsonProperty("name") String name,
            @JsonProperty("author") int author,
            @JsonProperty("pageSize") int pageSize,
            @JsonProperty("publication") float publication,
            @JsonProperty("price") int price) {
        this.name = name;
        this.author = author;
        this.pageSize = pageSize;
        this.publication = publication;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAuthor() {
        return author;
    }

    public int getPageSize() {
        return pageSize;
    }

    public float getPublication() {
        return publication;
    }

    public int getPrice() {
        return price;
    }
}
package com.iamjosephvarghese.retrofitroomsample.model;

public class QuoteAPIModel {
    public String author;
    public String data;
    public String url;

    public QuoteAPIModel(String author, String data, String url) {
        this.author = author;
        this.data = data;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public String getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }
}

package com.iamjosephvarghese.retrofitroomsample.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quoteTable")
public class Quote {

    @PrimaryKey(autoGenerate = true)
    int id;

    @NonNull
    @ColumnInfo(name = "author")
    String author;

    @NonNull
    @ColumnInfo(name = "data")
    String data;

    @NonNull
    @ColumnInfo(name = "url")
    String url;


    public Quote(int id, @NonNull String author, @NonNull String data, @NonNull String url) {
        this.id = id;
        this.author = author;
        this.data = data;
        this.url = url;
    }


    public Quote(@NonNull String author, @NonNull String data, @NonNull String url) {
        this.id = id;
        this.author = author;
        this.data = data;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getData() {
        return data;
    }

    @NonNull
    public String getUrl() {
        return url;
    }
}

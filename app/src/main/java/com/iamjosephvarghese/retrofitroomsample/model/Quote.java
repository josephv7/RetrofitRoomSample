package com.iamjosephvarghese.retrofitroomsample.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "quoteTable")
public class Quote {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "author")
    public String author;

    @NonNull
    @ColumnInfo(name = "data")
    public String data;


    @ColumnInfo(name = "url")
    public String url;


//    @Ignore
//    public Quote(int id, @NonNull String author, @NonNull String data, String url) {
//        this.id = id;
//        this.author = author;
//        this.data = data;
//        this.url = url;
//    }


    public Quote(@NonNull String author, @NonNull String data,String url) {
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

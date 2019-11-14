package com.iamjosephvarghese.retrofitroomsample.dao;

import com.iamjosephvarghese.retrofitroomsample.model.Quote;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Quote quote);

    @Query("DELETE FROM quoteTable")
    void deleteAll();

    @Query("DELETE FROM quoteTable WHERE author = :author")
    void deleteQuoteByAuthor(String author);

    @Query("SELECT * from quoteTable WHERE author = :author")
    LiveData<List<Quote>> getQuotes(String author);

    @Query("SELECT * from quoteTable")
    LiveData<List<Quote>> getAllQuotes();

}

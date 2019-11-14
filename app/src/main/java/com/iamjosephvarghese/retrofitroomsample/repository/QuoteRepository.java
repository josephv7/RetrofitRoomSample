package com.iamjosephvarghese.retrofitroomsample.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.iamjosephvarghese.retrofitroomsample.dao.QuoteDao;
import com.iamjosephvarghese.retrofitroomsample.model.Quote;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

public class QuoteRepository {

    private QuoteDao quoteDao;

    private LiveData<Quote> quoteLiveData;

    public QuoteRepository(Application application){
        QuoteDatabase db = QuoteDatabase.getDatabase(application);
        quoteDao = db.quoteDao();

//        quoteLiveData = quoteDao.getQuote("iamjosephvarghese");
    }


    public LiveData<List<Quote>> getQuotes(String author){
        return quoteDao.getQuotes(author);
    }

    public void insert(Quote quote){
        new insertAsyncTask(quoteDao).execute(quote);
    }


    private static class insertAsyncTask extends AsyncTask<Quote, Void, Void> {

        private QuoteDao mAsyncTaskDao;

        insertAsyncTask(QuoteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Quote... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}

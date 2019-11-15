package com.iamjosephvarghese.retrofitroomsample.viewModel;

import android.app.Application;

import com.iamjosephvarghese.retrofitroomsample.model.Quote;
import com.iamjosephvarghese.retrofitroomsample.repository.QuoteRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ViewModel extends AndroidViewModel {

    private QuoteRepository quoteRepository;

    public ViewModel(Application application){
        super(application);
        quoteRepository = new QuoteRepository(application);


    }

    public LiveData<List<Quote>> getQuotes(String author){
        return quoteRepository.getQuotes(author);
    }


    public void insert(Quote quote){
        quoteRepository.insert(quote);
    }

}

package com.iamjosephvarghese.retrofitroomsample.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iamjosephvarghese.retrofitroomsample.R;
import com.iamjosephvarghese.retrofitroomsample.model.Quote;
import com.iamjosephvarghese.retrofitroomsample.repository.QuoteRepository;
import com.iamjosephvarghese.retrofitroomsample.viewModel.ViewModel;

import java.sql.BatchUpdateException;

public class AddQuote extends AppCompatActivity {

    Button button;
    EditText author, data;
    ViewModel viewModel;

    QuoteRepository quoteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);
        button = findViewById(R.id.button);
        author = findViewById(R.id.authorBox);
        data = findViewById(R.id.dataBox);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(author.getText().toString() != null && data.getText().toString() != null){
                    viewModel.insert(new Quote(author.getText().toString(),data.getText().toString(),null));
                    Log.d("here","...");
                    Log.d("data",viewModel.getQuotes("hh").getValue().get(0).data);
                }
            }
        });


    }
}

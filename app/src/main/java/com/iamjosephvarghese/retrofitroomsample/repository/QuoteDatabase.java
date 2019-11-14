package com.iamjosephvarghese.retrofitroomsample.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.iamjosephvarghese.retrofitroomsample.dao.QuoteDao;
import com.iamjosephvarghese.retrofitroomsample.model.Quote;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Quote.class}, version = 1)
public abstract class QuoteDatabase extends  RoomDatabase{

    public abstract QuoteDao quoteDao();

    private static volatile QuoteDatabase INSTANCE;


    static QuoteDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuoteDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuoteDatabase.class, "quoteDatabase")
//                            .addMigrations(MIGRATION_1_2)
//                            .addCallback(sRoomDatabaseCallback)
                            .setJournalMode(JournalMode.AUTOMATIC)
                            .build();
                }
            }
        }
        return INSTANCE;
    }



    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };



    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {


        private final QuoteDao quoteDao;


        PopulateDbAsync(QuoteDatabase db) {
            quoteDao = db.quoteDao();

        }

        @Override
        protected Void doInBackground(final Void... params) {
            quoteDao.deleteAll();
            Quote quote = new Quote("iamjosephvarghese","data","url");
            quoteDao.insert(quote);

            return null;
        }
    }



}

package com.mvvm.room_mvvm.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.mvvm.room_mvvm.Dao.NoteDao;
import com.mvvm.room_mvvm.entity.Notes;

@Database(entities = Notes.class,version = 1)
public abstract class RoomDatabase extends androidx.room.RoomDatabase
{
    private static RoomDatabase instance;////creating instance of roomdatabase

    public abstract NoteDao noteDao();



    public static synchronized RoomDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),RoomDatabase.class,"note database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomcallback)
                    .build();
            ////fall back to miggarate to new database
        }
        return  instance;
    }

    private static   androidx.room.RoomDatabase.Callback roomcallback=new androidx.room.RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(instance).execute();


        }
    };


    private static  class PopulateAsyncTask extends AsyncTask<Void,Void,Void>
    {

        NoteDao noteDao;
        private PopulateAsyncTask(RoomDatabase roomDatabase)
        {
            noteDao=roomDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Notes("Title 1","description",1));
            noteDao.insert(new Notes("Title 2","description1",2));
            noteDao.insert(new Notes("Title 3","description2",3));
            noteDao.insert(new Notes("Title 4","description3",4));
            return null;
        }
    }
}

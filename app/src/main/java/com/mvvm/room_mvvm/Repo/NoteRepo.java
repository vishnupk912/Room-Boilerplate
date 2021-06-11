package com.mvvm.room_mvvm.Repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mvvm.room_mvvm.Dao.NoteDao;
import com.mvvm.room_mvvm.db.RoomDatabase;
import com.mvvm.room_mvvm.entity.Notes;

import java.util.List;

public class NoteRepo
{
    private NoteDao noteDao;
    private LiveData<List<Notes>> allnotes;

    public NoteRepo(Application application)
    {
        RoomDatabase roomDatabase=RoomDatabase.getInstance(application);
        noteDao=roomDatabase.noteDao();
        allnotes=noteDao.selectallnotes();
    }

    public void insert(Notes notes)
    {
        new InsertNoteAsyncTask(noteDao).execute(notes);

    }

    public void update(Notes notes)
    {
        new UpdateNoteAsyncTask(noteDao).execute(notes);
    }

    public void delete(Notes notes)
    {
        new DeleteNoteAsyncTask(noteDao).execute(notes);
    }

    public void deleteall()
    {
        new DeleteAllNoteAsyncTask(noteDao).execute();
    }


    public LiveData<List<Notes>> getAllnotes()
    {
        return  allnotes;
    }

    public static class DeleteNoteAsyncTask extends AsyncTask<Notes,Void,Void>
    {

        private NoteDao noteDao;
        private  DeleteNoteAsyncTask (NoteDao noteDao)
        {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Notes... notes)
        {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    public static class InsertNoteAsyncTask extends AsyncTask<Notes,Void,Void>
    {

        private NoteDao noteDao;
        private  InsertNoteAsyncTask (NoteDao noteDao)
        {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Notes... notes)
        {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    public static class UpdateNoteAsyncTask extends AsyncTask<Notes,Void,Void>
    {

        private NoteDao noteDao;
        private  UpdateNoteAsyncTask (NoteDao noteDao)
        {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Notes... notes)
        {
            noteDao.update(notes[0]);
            return null;
        }
    }
    public static class DeleteAllNoteAsyncTask extends AsyncTask<Void,Void,Void>
    {

        private NoteDao noteDao;
        private  DeleteAllNoteAsyncTask (NoteDao noteDao)
        {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Void... voids)
        {
            noteDao.deleteallnotes();
            return null;
        }
    }


}

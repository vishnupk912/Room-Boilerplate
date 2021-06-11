package com.mvvm.room_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mvvm.room_mvvm.Repo.NoteRepo;
import com.mvvm.room_mvvm.entity.Notes;

import java.util.List;

public class NoteViewModel extends AndroidViewModel
{
    NoteRepo noteRepo;
    LiveData<List<Notes>> allnotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRepo=new NoteRepo(application);
        allnotes=noteRepo.getAllnotes();

    }

    public void insert(Notes notes)
    {
        noteRepo.insert(notes);
    }


    public void update(Notes notes)
    {
        noteRepo.update(notes);
    }


    public void delete(Notes notes)
    {
        noteRepo.delete(notes);
    }


    public void deleteall(Notes notes)
    {
        noteRepo.deleteall();
    }

    public LiveData<List<Notes>> getAllnotes()
    {
        return allnotes;
    }

}

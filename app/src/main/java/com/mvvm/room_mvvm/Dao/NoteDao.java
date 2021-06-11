package com.mvvm.room_mvvm.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mvvm.room_mvvm.entity.Notes;

import java.util.List;

@Dao
public interface NoteDao
{
    @Insert
    void insert(Notes note);


    @Update
    void update(Notes notes);

    @Delete
    void delete (Notes notes);

    @Query("DELETE FROM notes_table")
    void deleteallnotes();

    @Query("SELECT * FROM notes_table ORDER BY priority DESC")
    LiveData<List<Notes>> selectallnotes();

}

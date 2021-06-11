 package com.mvvm.room_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.mvvm.room_mvvm.entity.Notes;
import com.mvvm.room_mvvm.viewmodel.NoteViewModel;

import java.util.List;

 public class MainActivity extends AppCompatActivity {

    NoteViewModel noteViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteViewModel= ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllnotes().observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes) {
                Toast.makeText(MainActivity.this, notes.get(1).getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
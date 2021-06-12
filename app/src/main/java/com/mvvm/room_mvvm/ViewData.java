package com.mvvm.room_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.mvvm.room_mvvm.entity.Notes;
import com.mvvm.room_mvvm.viewmodel.NoteViewModel;

import java.util.List;

public class ViewData extends AppCompatActivity {

    RecyclerView recyclerView;
    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        noteViewModel= ViewModelProviders.of(this).get(NoteViewModel.class);
        recyclerView=findViewById(R.id.rvid);


        noteViewModel.getAllnotes().observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes)
            {

                Adapter adapter = new Adapter(notes,ViewData.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ViewData.this));
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
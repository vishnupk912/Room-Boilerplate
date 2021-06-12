 package com.mvvm.room_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mvvm.room_mvvm.entity.Notes;
import com.mvvm.room_mvvm.viewmodel.NoteViewModel;

import java.util.List;

 public class MainActivity extends AppCompatActivity {

    NoteViewModel noteViewModel;
    Button linearLayout_Add,linearLayout_view;
    EditText  titletv,descpet,prorityet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titletv=findViewById(R.id.entertitletv);
        descpet=findViewById(R.id.enterdescription);
        prorityet=findViewById(R.id.priorityet);

        noteViewModel= ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllnotes().observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes) {
                Toast.makeText(MainActivity.this, notes.get(1).getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

        linearLayout_Add=findViewById(R.id.addlay);
        linearLayout_view=findViewById(R.id.viewlay);

        linearLayout_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ViewData.class);
                startActivity(intent);
            }
        });
        linearLayout_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteViewModel.insert(new Notes(titletv.getText().toString(),descpet.getText().toString(),Integer.parseInt(prorityet.getText().toString())));

            }
        });
    }


}
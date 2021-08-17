package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.blocodenotas.controller.NoteController;
import com.example.blocodenotas.model.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lstNotes);
    }

    public void newNote(View view) {
        Intent intent = new Intent(this, ActivityShowNote.class);
        intent.putExtra("id note", 0);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        NoteController noteController = new NoteController(this);

        ArrayList<String> notes = noteController.getAllNotesAsString();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notes);

        listView.setAdapter(adapter);
    }
}
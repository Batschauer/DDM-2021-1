package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.blocodenotas.controller.NoteController;
import com.example.blocodenotas.model.Note;

public class ActivityShowNote extends AppCompatActivity {

    private NoteController controller;
    private EditText edtTitle, edtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        controller = new NoteController(getApplicationContext());

        edtTitle = findViewById(R.id.edtTitle);
        edtDescription = findViewById(R.id.edtDescription);
    }

    public void saveNote(View view) {
        controller.insertNewNote(new Note(null, edtTitle.getText().toString(), edtDescription.getText().toString()));
    }
}
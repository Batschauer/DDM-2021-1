package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.blocodenotas.controller.NoteController;
import com.example.blocodenotas.model.Note;

public class ActivityShowNote extends AppCompatActivity {

    private Note note = null;

    private NoteController controller;
    private EditText edtTitle, edtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        controller = new NoteController(getApplicationContext());

        edtTitle = findViewById(R.id.edtTitle);
        edtDescription = findViewById(R.id.edtDescription);

        Bundle bundle = getIntent().getExtras();

        int idNote = bundle.getInt("id_note");
        if (idNote != 0)
            loadNote(idNote);
    }

    private void loadNote(int idNote) {
        note = controller.getNote(idNote);

        edtTitle.setText(note.getTitle());
        edtDescription.setText(note.getDescription());
    }

    public void saveNote(View view) {
        if (note == null) {
            note = controller.insertNewNote(new Note(null, edtTitle.getText().toString(), edtDescription.getText().toString()));
        }
        else {
            note = controller.updateNote(new Note(note.getId(), edtTitle.getText().toString(), edtDescription.getText().toString()));
        }
    }
}
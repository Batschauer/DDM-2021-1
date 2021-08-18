package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoteController controller = new NoteController(getApplicationContext());
                ArrayList<Note> notes = controller.getAllNotes();

                int idNote = notes.get(position).getId();

                Intent intent = new Intent(getApplicationContext(), ActivityShowNote.class);
                intent.putExtra("id_note", idNote);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                NoteController controller = new NoteController(getApplicationContext());
                ArrayList<Note> notes = controller.getAllNotes();

                Note note = notes.get(position);
                int idNote = note.getId();

                boolean itemRemoved = controller.deleteNote(idNote);

                if (itemRemoved) {
                    Toast.makeText(getApplicationContext(), "Nota " + note.getTitle() + " foi removido.", Toast.LENGTH_LONG).show();
                }

                adapter.remove(note.getTitle());
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    public void newNote(View view) {
        Intent intent = new Intent(this, ActivityShowNote.class);
        intent.putExtra("id_note", 0);
        startActivity(intent);
    }
}
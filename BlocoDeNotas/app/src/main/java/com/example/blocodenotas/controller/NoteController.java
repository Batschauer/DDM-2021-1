package com.example.blocodenotas.controller;

import android.content.Context;

import com.example.blocodenotas.model.Note;
import com.example.blocodenotas.model.NoteDAO;

import java.util.ArrayList;

public class NoteController {
    private Context context;
    private NoteDAO noteDAO;

    public NoteController(Context context) {
        this.context = context;
        this.noteDAO = new NoteDAO(context);
    }

    public Note insertNewNote(Note note) {
        return noteDAO.insertNote(note);
    }

    public ArrayList<Note> getAllNotes() {
        return noteDAO.getNotes();
    }

    public ArrayList<String> getAllNotesAsString() {
        ArrayList<String> notesAsString = new ArrayList<String>();
        for (Note note : this.getAllNotes()) {
            notesAsString.add(note.getTitle());
        }

        return notesAsString;
    }
}

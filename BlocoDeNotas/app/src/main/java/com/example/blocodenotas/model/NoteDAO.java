package com.example.blocodenotas.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NoteDAO {
    private SQLiteDatabase dataBase;

    public NoteDAO(Context context) {
        dataBase = context.openOrCreateDatabase("dbNotes", context.MODE_PRIVATE, null);
        dataBase.execSQL("CREATE TABLE IF NOT EXISTS notes (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "title VARCHAR," +
                "description VARCHAR)");
    }

    public Note insertNote(Note note) {
        ContentValues content = new ContentValues();
        content.put("title", note.getTitle());
        content.put("description", note.getDescription());

        int id = (int) dataBase.insert("notes", null, content);
        note.setId(id);

        return note;
    }

    public ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<Note>();

        Cursor cursor = dataBase.rawQuery("SELECT * FROM notes;", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            notes.add(new Note(
                  cursor.getInt(0),
                  cursor.getString(1),
                  cursor.getString(2)
            ));

            cursor.moveToNext();
        }

        return notes;
    }
}

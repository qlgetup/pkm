package com.bupt.dao;

import com.bupt.model.Note;

import java.util.List;

public interface NoteDao {
    int newnote(Note note);
    List<Note>  note(int uid);
    int deletenote(Note note);
    int renamenote(Note note);
    int updatenote(Note note);

}

package com.bupt.service;

import com.bupt.model.Note;

import java.util.List;

public interface NoteService {
    int newnote(Note note);
    List<Note> note(int uid);
    int deletenote(Note note);
    int renamenote(Note note);
    Note updatenote(Note note);
}

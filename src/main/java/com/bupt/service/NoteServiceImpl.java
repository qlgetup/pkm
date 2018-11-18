package com.bupt.service;

import com.bupt.dao.NoteDao;
import com.bupt.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;

    @Override
    public int newnote(Note note){
        return noteDao.newnote(note);
    }

    @Override
    public List<Note> note(int uid) {
        return noteDao.note(uid);
    }

    @Override
    public int deletenote(Note note) {
        return noteDao.deletenote(note);
    }

    @Override
    public int renamenote(Note note) {
        return noteDao.renamenote((note));
    }

    @Override
    public Note updatenote(Note note) {
         noteDao.updatenote(note);
         return note;
    }
}

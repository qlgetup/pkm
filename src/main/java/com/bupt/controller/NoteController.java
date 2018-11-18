package com.bupt.controller;

import com.bupt.model.Note;
import com.bupt.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteServiceImpl;

    @CrossOrigin
    @RequestMapping(value = "/newnote", method = RequestMethod.POST)
    public Note newnote(@RequestBody Note note,HttpServletRequest request) {
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        note.setUid(uid);
         noteServiceImpl.newnote(note);
         return note;
    }

    @CrossOrigin
    @RequestMapping(value = "/note", method = RequestMethod.POST)
    public List<Note> note(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        return noteServiceImpl.note(uid);
    }

    @CrossOrigin
    @RequestMapping(value = "/deletenote", method = RequestMethod.POST)
    public int deletenote(@RequestBody Note note) {
        return noteServiceImpl.deletenote(note);
    }
    @CrossOrigin
    @RequestMapping(value = "/renamenote", method = RequestMethod.POST)
    public int renamenote(@RequestBody Note note) {
        return noteServiceImpl.renamenote(note);
    }

    @CrossOrigin
    @RequestMapping(value = "/updatenote", method = RequestMethod.POST)
    public Note updatenote(@RequestBody Note note) {
        return noteServiceImpl.updatenote(note);
    }
}

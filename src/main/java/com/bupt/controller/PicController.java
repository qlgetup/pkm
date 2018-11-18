package com.bupt.controller;

import com.bupt.model.Pic;
import com.bupt.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PicController {
    @Autowired
    private PicService picServiceImpl;

    @CrossOrigin
    @RequestMapping(value = "/pic", method = RequestMethod.POST)
    public List<Pic> gencata(HttpServletRequest request){
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        return picServiceImpl.catalog(uid);
    }


    @CrossOrigin
    @RequestMapping(value = "/newpic", method = RequestMethod.POST)
    public Pic newfolder(@RequestBody Pic pic,HttpServletRequest request){
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        pic.setUid(uid);
        picServiceImpl.newfolder(pic);
        return pic;
    }

    @CrossOrigin
    @RequestMapping(value = "/deletepic", method = RequestMethod.POST)
    public int deletefolder(@RequestBody Pic pic){
        return picServiceImpl.deletefolder(pic);
    }

    @CrossOrigin
    @RequestMapping(value="/uploadpic",method=RequestMethod.POST)
    public Pic  upload(HttpServletRequest request,@RequestParam("file")MultipartFile file, @RequestParam("pid")int pid, @RequestParam("name")String name, @RequestParam("type")String type) {
        String fileName = file.getOriginalFilename(); //获取文件名
        System.out.println(fileName);
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        Pic pic=new Pic();
        pic.setName(name);
        pic.setPid(pid);
        pic.setType(type);
        pic.setUid(uid);
        return  picServiceImpl.newfile(pic,file);
    }

    @CrossOrigin
    @RequestMapping(value = "/renamepic", method = RequestMethod.POST)
    public int rename(@RequestBody Pic pic){
        return picServiceImpl.rename(pic.getId(),pic.getName());
    }
}

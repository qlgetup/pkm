package com.bupt.controller;

import com.bupt.model.MyFile;
import com.bupt.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    private FileService fileServiceImpl;

    @CrossOrigin
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public List<MyFile> gencata(HttpServletRequest request){
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        return fileServiceImpl.catalog(uid);
}


    @CrossOrigin
    @RequestMapping(value = "/newfolder", method = RequestMethod.POST)
    public MyFile newfolder(@RequestBody MyFile file,HttpServletRequest request){
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        file.setUid(uid);
        fileServiceImpl.newfolder(file);
        return file;
    }

    @CrossOrigin
    @RequestMapping(value = "/deletefolder", method = RequestMethod.POST)
    public int deletefolder(@RequestBody MyFile file){
        return fileServiceImpl.deletefolder(file);
    }

    @CrossOrigin
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public MyFile  upload(HttpServletRequest request,@RequestParam("file")MultipartFile file,@RequestParam("pid")int pid,@RequestParam("name")String name,@RequestParam("type")String type) {
        String fileName = file.getOriginalFilename(); //获取文件名
        System.out.println(fileName);
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        MyFile myfile=new MyFile();
        myfile.setName(name);
        myfile.setpId(pid);
        myfile.setType(type);
        myfile.setUid(uid);
      return  fileServiceImpl.newfile(myfile,file);
    }

    @CrossOrigin
    @RequestMapping(value = "/rename", method = RequestMethod.POST)
    public int rename(@RequestBody MyFile file){
        return fileServiceImpl.rename(file.getId(),file.getName());
    }
}

package com.bupt.service;

import com.bupt.dao.PicDao;
import com.bupt.model.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class PicServiceImpl implements PicService{
    @Autowired
    private PicDao picDao;

    @Override
    public List<Pic> catalog(int uid) {
        return picDao.catalog(uid);
    }

    @Override
    public int newfolder(Pic pic) {
        return(picDao.newfolder(pic));
    }

    @Override
    public int deletefolder(Pic pic){
        return picDao.deletefolder(pic);
    }
    @Override
    public int rename(int id,String name){
        return picDao.rename(id,name);
    }
    @Override
    public Pic newfile(Pic pic,MultipartFile file ){
        picDao.newfolder(pic);
        String path="D:/IdeaProjects/PKM/src/main/webapp/static/pic/"+pic.getId()+'.'+pic.getType();
        try{
            File newFile =new File(path);
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pic;
    }

}

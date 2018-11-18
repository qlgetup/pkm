package com.bupt.service;


import com.bupt.dao.FileDao;
import com.bupt.model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileDao fileDao;

    @Override
    public List<MyFile> catalog(int uid) {
        return fileDao.catalog(uid);
    }

    @Override
    public int newfolder(MyFile file ) {
           return(fileDao.newfolder(file));
    }

    @Override
    public int deletefolder(MyFile file){
        return fileDao.deletefolder(file);
    }
    @Override
    public int rename(int id,String name){
        return fileDao.rename(id,name);
    }
    @Override
    public MyFile newfile(MyFile myfile,MultipartFile file ){
        fileDao.newfolder(myfile);
        String path="D:/IdeaProjects/PKM/src/main/webapp/static/file/"+myfile.getId()+'.'+myfile.getType();
        try{
            File newFile =new File(path);
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myfile;
    }

}

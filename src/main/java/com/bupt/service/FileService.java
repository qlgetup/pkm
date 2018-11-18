package com.bupt.service;

import com.bupt.model.MyFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List<MyFile> catalog(int uid);
    int newfolder(MyFile file );
    MyFile newfile(MyFile myfile,MultipartFile file );
    int deletefolder(MyFile file);
    int rename(int id,String name);
}

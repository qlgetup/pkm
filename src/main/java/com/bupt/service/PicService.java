package com.bupt.service;

import com.bupt.model.Pic;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PicService {
    List<Pic> catalog(int uid);
    int newfolder(Pic pic);
    Pic newfile(Pic pic,MultipartFile file );
    int deletefolder(Pic pic);
    int rename(int id,String name);
}

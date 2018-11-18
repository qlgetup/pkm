package com.bupt.dao;

import com.bupt.model.MyFile;
import com.bupt.model.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileDao {
    List<MyFile> catalog(int uid);
    int newfolder(MyFile file);
    int deletefolder(MyFile file);
    int rename(@Param("id") int id,@Param("name") String name);
}


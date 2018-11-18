package com.bupt.dao;

import com.bupt.model.Pic;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface PicDao {
    List<Pic> catalog(int uid);
    int newfolder(Pic pic);
    int deletefolder(Pic pic);
    int rename(@Param("id") int id, @Param("name") String name);
}

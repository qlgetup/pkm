package com.bupt;

import com.bupt.dao.FileDao;
import com.bupt.model.MyFile;
import com.bupt.model.User;
import com.bupt.dao.UserDao;
import com.bupt.service.FileService;
import com.bupt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private UserDao dao;

    @Autowired
    private FileService f;



    @Test
    public void test() {
  User u= dao.login("q");
try{if(u==null)
        System.out.println(12);
        }
        catch(Exception e){
            System.out.println("cuole");
        }
    }
}
package com.bupt.controller;

import com.bupt.model.User;
import com.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user,HttpServletResponse response,HttpServletRequest request) {
        User u = userServiceImpl.login(user.getUsername());
        if (u!= null && u.getPassword().equals(user.getPassword())) {
           /* Cookie cookie = new Cookie("id",user.getUsername());
            // 有效期,秒为单位
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);*/
            //创建session对象
            HttpSession session = request.getSession();
            //把用户数据保存在session域对象中
            session.setAttribute("id",u.getId());
            return "login success";
        }
        return "login failed";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public List<User> userinfo(@RequestBody User user) {
        return userServiceImpl.selectuser(user.getUsername());
    }

    @RequestMapping(value="/showCookies")
    public void showCookies(HttpServletRequest request, HttpServletResponse response ){
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        if (null==cookies) {
            System.out.println("没有cookie=========");
        } else {
            for(Cookie cookie : cookies){
                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
            }
        }

    }

    @RequestMapping(value="/session")
    public String session(HttpServletRequest request, HttpServletResponse response ) {
        // 使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        // 将数据存储到session中
      //  session.setAttribute("java", "myJavaData");
        // 获取session的Id
        String sessionId = session.getId();
        // 判断session是不是新创建的
        if (session.isNew()) {
            return "session创建成功，session的id是：" + sessionId;
        } else {
            System.out.println(session.getAttribute("id")); // 值myJavaData

            return "服务器已经存在该session了，session的id是：" + sessionId;
        }
    }
    @CrossOrigin
    @RequestMapping(value = "/regis", method = RequestMethod.POST)
    public int regis(@RequestBody User user) {
        return userServiceImpl.regis(user);
    }
}

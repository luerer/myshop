package com.javen.controller;

/**
 * Created by Jay on 2017/6/21.
 */
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javen.service.IUserService;
import com.javen.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.javen.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@CrossOrigin(origins = "*",maxAge = 3600)        //允许跨域
@Controller
@RequestMapping("/user")    //"/user/**"
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/get")
    public void getUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = (User) this.userService.get(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping("/query")
    public void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> listUser =  userService.query();
        System.out.println("getAllUsers! listUser.size():"+listUser.size());
        for (int i=0;i<listUser.size();i++){
            System.out.println(listUser.get(i).toString());
        }
        response.setCharacterEncoding("UTF-8");
        String listjson = JsonUtil.listToJson(listUser);
        String jsonstring="{\"data\":"+listjson+",\"draw\":\"1\",\"recordsTotal\":"+listUser.size()+",\"recordsFiltered\":"+listUser.size()+"}";
//        String jsonstring="{data:"+listUser+",draw:1,recordsTotal:"+listUser.size()+",recordsFiltered:"+listUser.size()+"}";
//
        System.out.println("jsonstring:"+jsonstring);
        PrintWriter out = response.getWriter();
        out.print(jsonstring);
        out.flush();
        out.close();
    }

    @RequestMapping("/add")
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("addUser!");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String message=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            User user = new User();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Date birthday = sdf.parse(request.getParameter("birthday"));
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            int role;     //默认角色role=1，普通用户
            try {
                role = Integer.parseInt(request.getParameter("role"));
            }catch (Exception e){
                role=1;
                e.printStackTrace();
            }
            int level;    //默认等级level=0，最低等级
            try {
                level = Integer.parseInt(request.getParameter("level"));
            }catch (Exception e){
                level=0;
                e.printStackTrace();
            }
            user.setUsername(username);
            user.setPassword(password);
            user.setBirthday(birthday);
            user.setGender(gender);
            user.setPhone(phone);
            user.setEmail(email);
            user.setRole(role);
            user.settLevel(level);
            user.setLogin(false);
            this.userService.add(user);
            message="success";
        }catch (Exception e){
            message="error";
        }finally {
            String jsonstring = JsonUtil.msgToJson(message);
            PrintWriter out = response.getWriter();
            out.print(jsonstring);
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/delete")
    public void deleteUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String message=null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("deleteUserById! id="+id);
            this.userService.delete(id);
            message="success";
        }catch (Exception e){
            message="error";
        }finally {
            String jsonstring = JsonUtil.msgToJson(message);
            PrintWriter out = response.getWriter();
            out.print(jsonstring);
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/update")
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String message=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            User user = new User();
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("updateUser! id="+id);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Date birthday = sdf.parse(request.getParameter("birthday"));
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            int role = Integer.parseInt(request.getParameter("role"));
            int level = Integer.parseInt(request.getParameter("level"));
            boolean login = Boolean.parseBoolean(request.getParameter("login"));
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setBirthday(birthday);
            user.setGender(gender);
            user.setPhone(phone);
            user.setEmail(email);
            user.setRole(role);
            user.settLevel(level);
            user.setLogin(login);
            this.userService.update(user);
            message="success";
        }catch (Exception e){
            message="error";
        }finally {
            String jsonstring = JsonUtil.msgToJson(message);
            PrintWriter out = response.getWriter();
            out.print(jsonstring);
            out.flush();
            out.close();
        }
    }

    @RequestMapping("/login")
    public void checkUserIsLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String message=null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int size = this.userService.login(user);
//        System.out.println("发现"+size+"个用户登录！");
        if (size==1){
            message="success";
        }
        else{
            message="error";
        }
        String jsonstring = JsonUtil.msgToJson(message);
        PrintWriter out = response.getWriter();
        out.print(jsonstring);
        out.flush();
        out.close();
    }
}

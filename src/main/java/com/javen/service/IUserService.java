package com.javen.service;

import com.javen.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jay on 2017/6/21.
 */
@Transactional
public interface IUserService extends IBaseService{

    List<User> login(User user);

//    public User getUserById(int userId);
//
//    public List<User> getAllUsers();
//
//    public void addUser(User user);
//
//    public void deleteUserById(int id);
//
//    public void updateUser(User user);

}

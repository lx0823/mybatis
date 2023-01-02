package com.lx.dao;

import com.lx.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> getUserList();

    public User getUserById(int id);

    public int addUser(User user);

    public int updateUser();

    public int deleteUser();

    public int addUserByMap(Map<String,Object> map);

    public List<User> getUserByLike(String value);

}

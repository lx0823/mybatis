package com.lx.dao;

import com.lx.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> getUserList();

    public List<User> getUserLimit(Map<String,Integer> map);

    public List<User> getUserByRowBounds();

    public List<User> getUserByPageHelper();
}

package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public class UserServiceImp implements UserService {

    private final UserMapper userMapper;

    public UserServiceImp(UserMapper noteMapper) {
        this.userMapper = noteMapper;
    }

    @Override
    public User find(long userId) {
        var user = this.userMapper.find(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid note Id:" + userId);
        }
        return user;
    }

    /*@Override
    public User find(String userName) {
        var user = this.userMapper.find(userName);
        return user;
    }*/

    @Override
    public int insert(User user) {
        return this.userMapper.insert(user);
    }

    @Override
    public int delete(long userId) {
        var user = this.find(userId);
        return this.userMapper.delete(user.getUserId());
    }

    @Override
    public int update(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
};

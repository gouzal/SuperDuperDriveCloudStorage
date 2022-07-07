package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import java.util.List;
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

    @Override
    public User findByUsername(String username) {
        var user = this.userMapper.findByUsername(username);
        return user;
    }

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

    @Override
    public List<User> findAll() {
        return this.userMapper.findAll();
    }
};

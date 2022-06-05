package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public interface UserService extends AbstractPersistenceService<User> {

    User findByUserName(String userName);

}

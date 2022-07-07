package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public interface UserService extends AbstractPersistenceService<User> {

     Optional<User> findByUsername(String userName);

}

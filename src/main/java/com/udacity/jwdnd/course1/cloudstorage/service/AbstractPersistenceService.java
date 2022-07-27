package com.udacity.jwdnd.course1.cloudstorage.service;

import java.util.List;

/**
 *
 * @author Larbi
 */
public interface AbstractPersistenceService<T> /*permits NoteService, CredentialService, FileService, UserService*/ {

    T find(long id);

    int update(T obj);

    int insert(T obj);

    int delete(long id);

    List<T> findAll();

}

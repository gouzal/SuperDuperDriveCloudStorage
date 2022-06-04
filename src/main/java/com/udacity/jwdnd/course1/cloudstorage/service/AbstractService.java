package com.udacity.jwdnd.course1.cloudstorage.service;

import java.util.List;

/**
 *
 * @author Larbi
 */
public  interface AbstractService<T> /*permits NoteService, CredentialService, FileService, UserService*/ {

    public T find(long id);

    int update(T obj);

    int insert(T obj);

    int delete(long id);

}

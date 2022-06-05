package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import java.util.List;

/**
 *
 * @author Larbi
 */
public  interface CredentialService extends AbstractPersistenceService<Credential> {

    List<Credential> findAllByUserId(long userId);

}

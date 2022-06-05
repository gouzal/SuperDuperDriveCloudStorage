package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public class CredentialServiceImp implements CredentialService {
    
    private final CredentialMapper credentialMapper;
    
    public CredentialServiceImp(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }
    
    @Override
    public Credential find(long id) {
        var note = this.credentialMapper.find(id);
        if (note == null) {
            throw new IllegalArgumentException("Invalid note Id:" + id);
        }
        return note;
    }
    
    @Override
    public List<Credential> findAllByUserId(long userId) {
        var credentials = this.credentialMapper.findAllByUserId(userId);
        return credentials;
    }
    
    @Override
    public int insert(Credential credential) {
        return this.credentialMapper.insert(credential);
    }
    
    @Override
    public int delete(long id) {
        var note = this.find(id);
        return this.credentialMapper.delete(note.getCredentialId());
    }
    
    @Override
    public int update(Credential credential) {
      return  this.credentialMapper.update(credential);
    }

    @Override
    public List<Credential> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
};

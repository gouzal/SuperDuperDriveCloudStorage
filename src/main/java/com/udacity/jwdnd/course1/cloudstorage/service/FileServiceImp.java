package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public class FileServiceImp implements FileService {

    private final FileMapper fileMapper;

    public FileServiceImp(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public File find(long fileId) {
        var file = this.fileMapper.find(fileId);
        if (file == null) {
            throw new IllegalArgumentException("Invalid file Id:" + fileId);
        }
        return file;
    }

    @Override
    public List<File> findAllByUserId(long userid) {
        var files = this.fileMapper.findAllByUserId(userid);
        return files;
    }

    @Override
    public int insert(File file) {
        return this.fileMapper.insert(file);
    }

    @Override
    public int delete(long fileId) {
        var file = this.find(fileId);
        return this.fileMapper.delete(file.getFileId());
    }

    @Override
    public int update(File file) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<File> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
};

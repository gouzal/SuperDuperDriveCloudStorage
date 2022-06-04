package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public  interface FileService extends AbstractService<File> {

    List<File> findAllByUserId(long userId);

}

package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    File find( long fileId);

    @Select("SELECT * FROM FILES WHERE userid = #{userId}")
    List<File> findAllByUserId( long userId);

//    @Update("UPDATE  FILES SET notetitle='#{noteTitle}', notedescription='#{noteDescription}' WHERE noteid = #{noteId}")
//    List<File> update(File file);

    @Insert("INSERT INTO FILES(filename,contenttype,filesize, userid, filedata) VALUES(#{fileName},#{contentType},#{fileSize},#{userId},#{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insert(File file);

    @Delete("DELETE FROM FILES WHERE fileId = #{fileId}")
    int delete(long fileId);

}

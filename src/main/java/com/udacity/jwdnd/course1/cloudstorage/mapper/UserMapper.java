package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE USERID  = #{userId}")
    User find(long userId);

    @Select("SELECT * FROM USERS WHERE username  = '#{userName}'")
    User findByUserName(String userName);

    @Select("SELECT * FROM USERS")
    List<User> findAll();
    // todo : fix this bug
    @Update("UPDATE  FILES SET notetitle='#{noteTitle}', notedescription='#{noteDescription}' WHERE noteid = #{noteId}")
    List<User> update(User user);

    @Insert("INSERT INTO USERS(firstname,lastname,username,password,salt) VALUES('#{firstname}','#{lastname}','#{username}','#{password}','#{salt}')")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

    @Delete("DELETE FROM FILES WHERE fileId = #{userId}")
    int delete(long userId);

}

package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE USERID  = #{userId}")
    User find(long userId);

    @Select("SELECT * FROM USERS WHERE username  = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM USERS")
    List<User> findAll();

    @Update("UPDATE  USERS SET  salt=#{salt}, password=#{password}, firstname=#{firstname}, lastname=#{lastname}  WHERE userId = #{userId}")
    List<User> update(User user);

    @Insert("INSERT INTO USERS(firstname,lastname,username,password,salt) VALUES(#{firstname},#{lastname},#{username},#{password},#{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

    @Delete("DELETE FROM USERS WHERE userId = #{userId}")
    int delete(long userId);

}

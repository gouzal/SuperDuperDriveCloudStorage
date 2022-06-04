package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CredentialMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    Credential find( long credentialId);

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    List<Credential> findAllByUserId( long credentialId);

    @Update("UPDATE  CREDENTIALS SET url=#{url}, username=#{userName}, password=#{password},userid=#{userId} WHERE credentialId = #{credentialId}")
    int update(Credential credential);

    @Insert("INSERT INTO CREDENTIALS (url,username,key,password,userid) VALUES(#{url},#{userName},#{key},#{password},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int insert(Credential credential);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    int delete(long credentialId);

}

package com.udacity.jwdnd.course1.cloudstorage.mapper;

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
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Note find(@Param("noteid") long noteid);

    @Select("SELECT * FROM Notes WHERE userid = #{userid}")
    List<Note> findAllByUserId(@Param("userid") long userid);

    @Update("UPDATE  NOTES SET notetitle=#{noteTitle}, notedescription=#{noteDescription} WHERE noteid = #{noteId} ")//and userId = #{userId}
    int update(Note note);

    @Insert("INSERT INTO NOTES(notetitle,notedescription,userid) VALUES(#{noteTitle},#{noteDescription},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insert(Note note);

    @Delete("DELETE FROM Notes WHERE noteid = #{noteId}")
    int delete(long noteId);

}

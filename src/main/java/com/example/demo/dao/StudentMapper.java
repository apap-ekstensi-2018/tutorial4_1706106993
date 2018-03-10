package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.StudentModel;

@Mapper
public interface StudentMapper
{
  @Select("SELECT npm, name, gpa FROM student WHERE npm = #{npm}")
    StudentModel selectStudent (@Param("npm") String npm);

  @Select("SELECT npm, name, gpa FROM student")
    List<StudentModel> selectAllStudents ();

  @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
    void addStudent (StudentModel student);

  @Delete("DELETE FROM student WHERE npm = #{npm}")
    StudentModel deleteStudent (@Param("npm") String npm);

  @Update("UPDATE student SET npm = #{npm}, gpa = #{gpa} WHERE npm = #{npm}")
    StudentModel updateStudent (StudentModel student);
}

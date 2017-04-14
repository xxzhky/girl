package com.dt.mapper;

import com.dt.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by RID on 2017/4/14.
 */
@Mapper
@Service
public interface UserMapper {

    @Select("SELECT * FROM user WHERE NAME = #{name}")
    User findByName(@Param("name") String name);


    @Insert("INSERT INTO user(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);


    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
    /*realze the add,del,update query as showed above*/


    @Insert("INSERT INTO user(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);


    @Insert("INSERT INTO user(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(User user);



    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

}

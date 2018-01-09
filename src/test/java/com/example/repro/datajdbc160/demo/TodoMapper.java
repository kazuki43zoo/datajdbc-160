package com.example.repro.datajdbc160.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.data.jdbc.mybatis.MyBatisContext;

@Mapper
public interface TodoMapper {

	@Insert("INSERT INTO todo (title, details, finished) VALUES(#{instance.title}, #{instance.details}, #{instance.finished})")
	@Options(useGeneratedKeys = true, keyProperty = "instance.id")
	void insert(MyBatisContext param);

}
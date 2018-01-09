package com.example.repro.datajdbc160;

import com.example.repro.datajdbc160.demo.Todo;
import com.example.repro.datajdbc160.demo.TodoService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.DataAccessStrategy;
import org.springframework.data.jdbc.mybatis.MyBatisDataAccessStrategy;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * auto-generated key feature does not work on mybatis batch mode.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Datajdbc160Application.class, Datajdbc160BatchModeTests.SpringDataJdbcConfig.class},
		properties = "mybatis.configuration.default-executor-type=batch")
public class Datajdbc160BatchModeTests {

	@Autowired
	private TodoService todoService;

	@Test
	public void save() {
		Todo todo = new Todo();
		todo.setTitle("title");

		Todo savedTodo = todoService.save(todo);

		Assertions.assertThat(savedTodo.getId()).isNotEqualTo(0);
	}

	@EnableJdbcRepositories
	public static class SpringDataJdbcConfig {
		@Bean
		DataAccessStrategy dataAccessStrategy(SqlSessionFactory sqlSessionFactory) {
			return new MyBatisDataAccessStrategy(sqlSessionFactory);
		}
	}

}

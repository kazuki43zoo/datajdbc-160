package com.example.repro.datajdbc160.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoService {
	private final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo save(Todo todo) {
		return this.todoRepository.save(todo);
	}

}
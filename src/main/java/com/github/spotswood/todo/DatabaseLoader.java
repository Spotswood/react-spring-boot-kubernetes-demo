package com.github.spotswood.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final TodoItemRepository repository;

    @Autowired
    public DatabaseLoader(TodoItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new TodoItem("call mom"));
    }
}

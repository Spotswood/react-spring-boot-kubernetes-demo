package com.github.spotswood.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TodoItem {

    private @Id @GeneratedValue Long id;
    private String name;

    private TodoItem() {}

    public TodoItem(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem otherTodoItem = (TodoItem) o;
        return Objects.equals(id, otherTodoItem.getId()) &&
                Objects.equals(name, otherTodoItem.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

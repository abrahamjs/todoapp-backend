package com.todoapp.todoapp.todoItem;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Provide all common methods for CRUD operations
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
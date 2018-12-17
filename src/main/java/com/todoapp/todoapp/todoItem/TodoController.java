package com.todoapp.todoapp.todoItem;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 //Annotation to make this class a REST controller,converts all methods response to JSON as HTTP response.
@RestController
public class TodoController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    //This annotation maps  the url with the given method
    @GetMapping("/todos")
    public List<TodoItem> retrieveAllTodoItem() {
        return todoItemRepository.findAll();
    }

    @GetMapping("/todos/{id}")
    //Gets a lists of all Todo Items
    public TodoItem retrieveTodoItem(@PathVariable long id) {
        Optional<TodoItem> todoItem = todoItemRepository.findById(id);

        if (!todoItem.isPresent())
            throw new TodoItemNotFoundException("id-" + id);

        return todoItem.get();
    }
    //Deletes the item with the given id
    @DeleteMapping("/todos/{id}")
    public void deleteTodoItem(@PathVariable long id) {
        todoItemRepository.deleteById(id);
    }


    //Creates and adds a new ite to the list
    @PostMapping("/todos")
    public ResponseEntity<Object> createTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem savedTodoItem = todoItemRepository.save(todoItem);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTodoItem.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
    //Updates †odo item with the given id
    @PutMapping("/todos/{id}")
    public ResponseEntity<Object> updateTodoItem(@RequestBody TodoItem todoItem, @PathVariable long id) {

        Optional<TodoItem> todoItemOptional = todoItemRepository.findById(id);

        if (!todoItemOptional.isPresent())
            return ResponseEntity.notFound().build();

        todoItem.setId(id);

        todoItemRepository.save(todoItem);

        return ResponseEntity.noContent().build();
    }
}
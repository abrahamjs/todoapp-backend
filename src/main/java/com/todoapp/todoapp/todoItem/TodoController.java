package com.todoapp.todoapp.todoItem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 //Annotation to make this class a REST controller,converts all methods response to JSON as HTTP response.
@RestController
public class TodoController {
     //Injects the TodoItem service to access the the methods and the instance of the service
     @Autowired
     private TodoItemService todoItemService;

    //This annotation maps  the url with the given method
    @GetMapping("/todos")
    public List<TodoItem> retrieveAllTodoItem() {
        return todoItemService.retrieveAllTodoItem();
    }

    @GetMapping("/todos/{id}")
    //Gets a lists of all Todo Items
    public TodoItem retrieveTodoItem(@PathVariable long id) {

        return todoItemService.retrieveTodoItem(id);
    }
    //Deletes the item with the given id
    @DeleteMapping("/todos/{id}")
    public void deleteTodoItem(@PathVariable long id) { todoItemService.deleteTodoItem(id);
    }


    //Creates and adds a new ite to the list
    @PostMapping("/todos")
    public ResponseEntity<Object> createTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.createTodoItem(todoItem);

    }

    //Updates †odo item with the given id
    @PutMapping("/todos/{id}")
    public ResponseEntity<Object> updateTodoItem(@RequestBody TodoItem todoItem, @PathVariable long id) {
        return todoItemService.updateTodoItem(todoItem, id );
    }
}
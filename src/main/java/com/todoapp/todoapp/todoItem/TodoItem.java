package com.todoapp.todoapp.todoItem;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String time;


    public TodoItem() {
        super();
    }

    public TodoItem(Long id, String title, String description, String time) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

}

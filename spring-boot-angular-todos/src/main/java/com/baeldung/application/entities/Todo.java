package com.baeldung.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String title;
    private boolean completed;

	public Todo() {
        this.title = "";
        this.completed = false;
    }
    
    public Todo(String todoTitle) {
        this.title = todoTitle;
    }

    public long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}

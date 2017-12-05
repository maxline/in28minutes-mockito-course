package com.in28minutes.business.impl;

import com.in28minutes.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Mikhluk.
 */
public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    List<String> retrieveTodosRelatedToSpring(String user){
        List<String> allTodos = todoService.retrieveTodos(user);
        List<String> filteredTodos = new ArrayList<String>();
        for(String todo: allTodos){
            if (todo.contains("Spring")){
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}

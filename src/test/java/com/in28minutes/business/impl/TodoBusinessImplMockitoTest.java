package com.in28minutes.business.impl;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Sergey Mikhluk.
 */
public class TodoBusinessImplMockitoTest {
    @Test
    public void retrieveTodosRelatedToSpring() throws Exception {
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
        when(todoService.retrieveTodos("Sergey")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        assertEquals(2, todoBusinessImpl.retrieveTodosRelatedToSpring("Sergey").size());
        assertEquals(0, todoBusinessImpl.retrieveTodosRelatedToSpring("Alex").size());
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingBDD() throws Exception {
        //given
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
        when(todoService.retrieveTodos("Sergey")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        //when
        List<String> todosSergey = todoBusinessImpl.retrieveTodosRelatedToSpring("Sergey");
        List<String> todosAlex = todoBusinessImpl.retrieveTodosRelatedToSpring("Alex");

        //then
        assertEquals(2,  todosSergey.size());
        assertEquals(0,  todosAlex.size());
    }

    @Test
    public void letsDeleteNow() throws Exception {
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
        when(todoService.retrieveTodos("Sergey")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Sergey");
        verify(todoService, Mockito.times(1)).deleteTodo("Learn to dance");
        verify(todoService, never()).deleteTodo("Learn Spring MVC");
        verify(todoService, never()).deleteTodo("Learn Spring");

    }


}
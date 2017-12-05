package com.in28minutes.business.impl;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

}
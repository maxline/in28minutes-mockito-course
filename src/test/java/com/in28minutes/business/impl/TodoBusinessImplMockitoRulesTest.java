package com.in28minutes.business.impl;

import com.in28minutes.data.api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Sergey Mikhluk.
 */
public class TodoBusinessImplMockitoRulesTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void retrieveTodosRelatedToSpring() throws Exception {
        List<String> allTodos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
        when(todoService.retrieveTodos("Sergey")).thenReturn(allTodos);

        assertEquals(2, todoBusinessImpl.retrieveTodosRelatedToSpring("Sergey").size());
        assertEquals(0, todoBusinessImpl.retrieveTodosRelatedToSpring("Alex").size());
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingBDD() throws Exception {
        //given
        List<String> allTodos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
        when(todoService.retrieveTodos("Sergey")).thenReturn(allTodos);

        //when
        List<String> todosSergey = todoBusinessImpl.retrieveTodosRelatedToSpring("Sergey");
        List<String> todosAlex = todoBusinessImpl.retrieveTodosRelatedToSpring("Alex");

        //then
        assertEquals(2,  todosSergey.size());
        assertEquals(0,  todosAlex.size());
    }

    @Test
    public void letsDeleteNow() throws Exception {
        List<String> allTodos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
        when(todoService.retrieveTodos("Sergey")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Sergey");
        verify(todoService, Mockito.times(1)).deleteTodo("Learn to dance");
        verify(todoService, never()).deleteTodo("Learn Spring MVC");
        verify(todoService, never()).deleteTodo("Learn Spring");
    }

    @Test
    public void captureArgument(){
        List<String> allTodos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to dance");
        when(todoService.retrieveTodos("Sergey")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Sergey");
        verify(todoService).deleteTodo(argumentCaptor.capture());

        assertEquals("Learn to dance", argumentCaptor.getValue());
    }
}
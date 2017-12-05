package com.in28minutes.data.api;

import java.util.List;

/**
 * @author Sergey Mikhluk.
 */
public interface TodoService {

    List<String> retrieveTodos(String user);
}

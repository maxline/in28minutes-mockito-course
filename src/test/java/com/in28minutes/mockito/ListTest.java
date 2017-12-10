package com.in28minutes.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Sergey Mikhluk.
 */
public class ListTest {

    @Test
    public void letsMockListSize() {
        List list = mock(List.class);
        when(list.size()).thenReturn(12);
        list.add("1");

        assertEquals(12, list.size());
        list.clear();
        assertEquals(12, list.size());
    }

    @Test
    public void letsMockListSizeWithMultipleReturns() {
        List list = mock(List.class);
        when(list.size()).thenReturn(12).thenReturn(11);
        list.add("1");

        assertEquals(12, list.size());
        list.clear();
        assertEquals(11, list.size());
    }

    @Test
    public void letsMockListGet() {
        List list = mock(List.class);
        when(list.get(1)).thenReturn("hello");

        list.clear();
        assertEquals("hello", list.get(1));
        list.add("hi");
        assertEquals(null, list.get(0));
    }

    @Test
    public void letsMockListWithAny() {
        List list = mock(List.class);
        when(list.get(anyInt())).thenReturn("hello");

        list.clear();
        assertEquals("hello", list.get(1));
        assertEquals("hello", list.get(0));
    }

    @Test
    public void letsMockListGet_usingBDD() {
        //given
        List list = mock(List.class);
        String hello = "hello";
        given(list.get(Mockito.anyInt())).willReturn(hello);

        //when
        String firstElement = (String) list.get(0);

        //then
        assertThat(firstElement, is(hello));
    }
}

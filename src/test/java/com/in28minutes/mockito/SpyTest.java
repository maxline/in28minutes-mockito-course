package com.in28minutes.mockito;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Sergey Mikhluk.
 */
public class SpyTest {

    @Test
    public void  creatingASpyOnArrayList(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Sergey");

        verify(arrayListSpy).add("Sergey");
        verify(arrayListSpy, never()).remove("Sergey");

        assertEquals(1, arrayListSpy.size());
        assertEquals("Sergey", arrayListSpy.get(0));
    }

    @Test
    public void  creatingASpyOnArrayList_overridingSpecificMethod(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Sergey");
        stub(arrayListSpy.size()).toReturn(-1);

        assertEquals(-1, arrayListSpy.size());
        assertEquals("Sergey", arrayListSpy.get(0));
    }
}

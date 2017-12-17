package com.in28minutes.mockito;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Sergey Mikhluk.
 */
public class HarmcrestMatcherTest {
    @Test
    public void basicHarmcrestMathers(){
        List<Integer> scores = Arrays.asList(45, 66, 23, 99);

        assertThat(scores, hasSize(4));
        assertThat(scores, contains(45, 66, 23, 99));
        assertThat(scores, hasItems(66, 99));
        assertThat(scores, everyItem(lessThan(100)));
        assertThat(scores, everyItem(greaterThan(10)));

        //string
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());

        //arrays
        Integer[] marks = {1, 3, 2, 4};

        assertThat(marks, arrayWithSize(4));
        assertThat(marks, arrayContaining(1,3, 2, 4));
        assertThat(marks, arrayContainingInAnyOrder(1,2,3, 4));
    }
}



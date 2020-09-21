package com.learning.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Argument matchers allow flexible verification or stubbing.
 * https://javadoc.io/static/org.mockito/mockito-core/3.5.11/org/mockito/ArgumentMatchers.html
 * https://javadoc.io/static/org.mockito/mockito-core/3.5.11/org/mockito/hamcrest/MockitoHamcrest.html
 *
 * For information solely on custom argument matchers check out javadoc for ArgumentMatcher class.
 *
 * https://javadoc.io/static/org.mockito/mockito-core/3.5.11/org/mockito/ArgumentMatcher.html
 *
 */

public class ArgumentMatcherTest {

    @Test
    void argumentMatcherTest() {

        List mockedList = Mockito.mock(List.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains(anyInt())).thenReturn(true);

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        // argument matchers can also be written as Java 8 Lambdas
        // verify(mockedList).add(argThat(someString -> someString.length() > 5));
        // verify(mock).addAll(argThat(list -> list.size() == 2));


        /**
         * Warning on argument matchers:
         *
         * If you are using argument matchers, all arguments have to be provided by matchers.
         *
         * The following example shows verification but the same applies to stubbing:
         *
         *    verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
         *    //above is correct - eq() is also an argument matcher
         *
         *    verify(mock).someMethod(anyInt(), anyString(), "third argument");
         *    //above is incorrect - exception will be thrown because third argument is given without an argument matcher.
         *
         * Matcher methods like anyObject(), eq() do not return matchers. Internally, they record a matcher on a stack
         * and return a dummy value (usually null). This implementation is due to static type safety imposed by the java
         * compiler. The consequence is that you cannot use anyObject(), eq() methods outside of verified/stubbed method.
         */
    }


}

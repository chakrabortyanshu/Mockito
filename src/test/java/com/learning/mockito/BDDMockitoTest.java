package com.learning.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class BDDMockitoTest {

    @Test
    void bddMockingTest() {

        Person person = Mockito.mock(Person.class);

        BDDMockito.given(person.getName()).willReturn("EFGH");

        Assertions.assertEquals("EFGH",person.getName());

        BDDMockito.verify(person).getName();

    }
}

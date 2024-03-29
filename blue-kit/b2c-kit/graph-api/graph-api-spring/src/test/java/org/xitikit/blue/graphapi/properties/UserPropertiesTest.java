package org.xitikit.blue.graphapi.properties;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;

class UserPropertiesTest{

    @Test
    void testWYSIWYG(){

        UserProperties userProperties = new UserProperties();
        assertNull(userProperties.getCustomAttributes());

        userProperties = testCase();
        assertTrue(userProperties.getCustomAttributes().size() == 2);
        assertEquals("whatever", userProperties.getCustomAttributes().get(0));
        assertEquals("this is", userProperties.getCustomAttributes().get(1));
    }

    public UserProperties testCase(){

        return new UserProperties(asList("whatever", "this is"));
    }
}
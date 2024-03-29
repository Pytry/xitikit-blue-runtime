package test.xitikit.blue.nommoc.errors.exceptions;

import org.junit.jupiter.api.Test;
import org.xitikit.blue.nommoc.errors.http.BlueKitHttpException;
import org.xitikit.blue.nommoc.errors.http.exceptions.MethodNotAllowedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.xitikit.blue.nommoc.errors.http.ErrorCode.*;

/**
 * Copyright Xitikit.org 2017
 *
 * @author J. Keith Hoopes *
 */
class MethodNotAllowedExceptionTest{

    /**
     * Basic constructor and null checks
     */
    @Test
    void verify(){

        MethodNotAllowedException e;

        e = new MethodNotAllowedException();
        assertTrue(e.getArguments() != null);
        assertTrue(e.getArguments().length == 0);
        assertTrue(e.getErrorCode() == METHOD_NOT_ALLOWED);

        e = new MethodNotAllowedException(new Throwable("Test"));
        assertTrue(e.getArguments() != null);
        assertTrue(e.getArguments().length == 0);
        assertTrue(e.getErrorCode() == METHOD_NOT_ALLOWED);
        assertTrue("Test".equals(e.getCause().getMessage()));

        e = new MethodNotAllowedException("Test Input");
        assertTrue(e.getArguments() != null);
        assertTrue(e.getArguments().length == 1);
        assertTrue(e.getErrorCode() == METHOD_NOT_ALLOWED);
        assertTrue("Test Input".equals(e.getArguments()[0]));
    }

    /**
     * Ensures values remain unchanged when added.
     *
     * @throws MethodNotAllowedException when it sees dead people.
     */
    @Test
    void addArgument(){

        BlueKitHttpException e = new MethodNotAllowedException("test", "one", "two");
        e.withArguments("test").withArguments("test2");

        boolean found = false;
        for(Object code : e.getArguments()){

            if("test".equals(code)){
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    /**
     * Ensures values remain unchanged when added.
     *
     * @throws MethodNotAllowedException when it sees Bruce Willis.
     */
    @Test
    void addArguments(){

        BlueKitHttpException e = new MethodNotAllowedException();
        String[] arguments = new String[2];
        arguments[0] = "a";
        arguments[1] = "b";
        e.withArguments(arguments);

        boolean foundZero = false;
        boolean foundOne = false;

        for(String arg : e.getArguments()){

            if("a".equals(arg)){
                foundZero = true;
            }
            if("b".equals(arg)){
                foundOne = true;
            }
            if(foundZero && foundOne){
                break;
            }
        }
        assertTrue(foundZero);
        assertTrue(foundOne);
    }
}
package test.xitikit.blue.nommoc.errors.exceptions;

import org.junit.jupiter.api.Test;
import org.xitikit.blue.nommoc.errors.http.BlueKitHttpException;
import org.xitikit.blue.nommoc.errors.http.ErrorCode;
import org.xitikit.blue.nommoc.errors.http.exceptions.ForbiddenException;

import static junit.framework.TestCase.*;

/**
 * Copyright Xitikit.org 2017
 *
 * @author J. Keith Hoopes *
 */
class ForbiddenExceptionTest{

    /**
     * Basic constructor and null checks
     */
    @Test
    void verify(){

        ForbiddenException e;

        e = new ForbiddenException();
        assertTrue(e.getArguments() != null);
        assertTrue(e.getArguments().length == 0);
        assertTrue(e.getErrorCode() == ErrorCode.FORBIDDEN);

        e = new ForbiddenException(new Throwable("Test"));
        assertTrue(e.getArguments() != null);
        assertTrue(e.getArguments().length == 0);
        assertTrue(e.getErrorCode() == ErrorCode.FORBIDDEN);
        assertTrue("Test".equals(e.getCause().getMessage()));

        e = new ForbiddenException("Test Input");
        assertTrue(e.getArguments() != null);
        assertTrue(e.getArguments().length == 1);
        assertTrue(e.getErrorCode() == ErrorCode.FORBIDDEN);
        assertTrue("Test Input".equals(e.getArguments()[0]));
    }

    /**
     * Ensures values remain unchanged when added.
     *
     * @throws ForbiddenException when it sees dead people.
     */
    @Test
    void addArgument(){

        BlueKitHttpException e = new ForbiddenException("test", "one", "two");
        e.withArguments("test").withArguments("test2");

        boolean found = false;
        for(String code : e.getArguments()){

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
     * @throws ForbiddenException when it sees Bruce Willis.
     */
    @Test
    void addArguments(){

        BlueKitHttpException e = new ForbiddenException();
        String[] arguments = new String[2];
        arguments[0] = "zero";
        arguments[1] = "one";
        e.withArguments(arguments);

        boolean foundZero = false;
        boolean foundOne = false;

        for(String arg : e.getArguments()){

            if("zero".equals(arg)){
                foundZero = true;
            }
            if("one".equals(arg)){
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
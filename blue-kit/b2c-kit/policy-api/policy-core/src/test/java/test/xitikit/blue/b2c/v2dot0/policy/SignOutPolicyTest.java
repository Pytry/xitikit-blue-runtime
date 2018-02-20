package test.xitikit.blue.b2c.v2dot0.policy;

import org.junit.jupiter.api.Test;
import org.xitikit.blue.b2c.v2dot0.policy.PolicyForB2C;
import org.xitikit.blue.b2c.v2dot0.policy.SignOutPolicy;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Keith on 10/15/2017.
 */
class SignOutPolicyTest{

    private final SignOutPolicy b = new SignOutPolicy();

    @Test
    void testInheritance(){
        //Make sure it aways implements
        //noinspection ConstantConditions
        assertTrue(b instanceof PolicyForB2C);
    }

    @Test
    void testName(){

        b.setName("test");
        assertEquals("test", b.getName());
    }

    @Test
    void testRedirectUrl(){

        b.setRedirectUrl("test");
        assertEquals("test", b.getRedirectUrl());
    }

    @Test
    void testTemplateUrl(){

        b.setTemplateUrl("test");
        assertNull(b.getTemplateUrl());
    }

    @Test
    void testDisabled(){

        assertFalse(b.isDisabled());
        b.setDisabled(true);
        assertTrue(b.isDisabled());
        b.setDisabled(false);
        assertFalse(b.isDisabled());
    }
}
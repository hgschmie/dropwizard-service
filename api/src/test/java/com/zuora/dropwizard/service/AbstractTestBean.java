package com.zuora.dropwizard.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.zuora.dropwizard.service.api.Bean;
import org.junit.Test;

import java.util.UUID;

public abstract class AbstractTestBean
{
    public static final String USER_NAME = UUID.randomUUID().toString();
    public static final String DISPLAY_NAME = UUID.randomUUID().toString();

    public final Bean testBean = getBuilder().userName(USER_NAME).displayName(DISPLAY_NAME).build();

    protected abstract Bean.Builder<? extends Bean> getBuilder();

    @Test
    public void testSimple()
    {
        Bean.Builder<? extends Bean> builder = getBuilder();
        builder.userName(USER_NAME);
        builder.displayName(DISPLAY_NAME);

        Bean bean = builder.build();

        assertEquals(USER_NAME, bean.getUserName());
        assertEquals(DISPLAY_NAME, bean.getDisplayName());

        assertEquals(testBean, bean);
    }

    @Test
    public void testRoundtrip()
    {
        Bean.Builder<? extends Bean> builder = testBean.toBuilder();

        Bean bean = builder.build();

        assertEquals(testBean, bean);
    }

    @Test
    public void testDefaultDisplayName()
    {
        Bean.Builder<? extends Bean> builder = getBuilder();
        builder.userName(USER_NAME);

        Bean bean = builder.build();

        assertEquals(USER_NAME, bean.getUserName());
        assertEquals(USER_NAME, bean.getDisplayName());
    }

    @Test
    public void testNoEmpty()
    {
        try {
            getBuilder().build();
            fail();
        }
        catch (IllegalStateException e) {
            assertEquals("Property \"userName\" has not been set", e.getMessage());
        }
    }

    @Test
    public void testNoUsername()
    {
        try {
            getBuilder().displayName(DISPLAY_NAME).build();
            fail();
        }
        catch (IllegalStateException e) {
            assertEquals("Missing required properties: userName", e.getMessage());
        }
    }
}

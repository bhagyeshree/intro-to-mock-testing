package com.cognizant;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static com.cognizant.MockTwitterApi.twitterApi;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WidgetTest {
    public static void main (String... args) throws Exception {
        System.out.println(twitterApi.getClass());
        //mocking actually create a child class of class to be tested
        System.out.println(twitterApi.getClass().getSuperclass());
        System.out.println(twitterApi.getTweets());

        when(twitterApi.tweet("foo")).thenReturn(7L);
        when(twitterApi.tweet("Rohit")).thenReturn(9L);

        System.out.println(twitterApi.tweet("foo"));
        System.out.println(twitterApi.tweet("Rohit"));
    }


    @Test
    void sayHelloToSendsATweet() throws Exception {
        //Setup
        final Twitter twitterApi = mock(Twitter.class);

        //when(twitterApi.tweet("foo")).thenReturn(7L);
        when(twitterApi.tweet("test")).thenReturn(42L);

        final Widget widget = new Widget(twitterApi);

        //Exercise
        final long actual = widget.sayHelloTo("test");

        //assert
        assertThat(actual, is(42L));
        verify(twitterApi).tweet("test");

    }

    @Test
    void sayHelloThrowsExceptionWhenTwitterIsDown() throws Exception {

        //Setup
        final Twitter twitterApi = mock(Twitter.class);

        when(twitterApi.tweet("test")).thenThrow(new TimeoutException());

        final Widget widget = new Widget(twitterApi);

        //Exercise
        final RuntimeException exception = assertThrows(RuntimeException.class, () -> widget.sayHelloTo("test"));

        //assert

        assertThat(exception.getMessage(), is("Twitter is down"));
        verify(twitterApi).tweet("test");
    }
}
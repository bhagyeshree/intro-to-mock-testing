package com.cognizant;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class WidgetTest {
//    public static void main (String... args) throws Exception {
//        System.out.println(twitterApi.getClass());
//        System.out.println(twitterApi.getClass().getSuperclass());
//        System.out.println(twitterApi.getTweets());
//
//        when(twitterApi.tweet("foo")).thenReturn(7L);
//        when(twitterApi.tweet("Rohit")).thenReturn(9L);
//
//        System.out.println(twitterApi.tweet("foo"));
//        System.out.println(twitterApi.tweet("Rohit"));
//    }

    @Test
    void sayHelloToSendsATweet() throws Exception {
        //Setup
        final Twitter twitterApi = mock(Twitter.class);

        //when(twitterApi.tweet("foo")).thenReturn(7L);
        when(twitterApi.tweet("Hello Rohit!")).thenReturn(42L);

        final Widget widget = new Widget(twitterApi);

        //Exercise
        final long actual = widget.sayHelloTo("Rohit");

        //assert
        assertThat(actual, is(42L));
        verify(twitterApi).tweet("Hello Rohit!");

    }

    @Test
    void sayHelloThrowsExceptionWhenTwitterIsDown() throws Exception {

        //Setup
        final Twitter twitterApi = mock(Twitter.class);

        when(twitterApi.tweet("Hello Rohit!")).thenThrow(new TimeoutException());

        final Widget widget = new Widget(twitterApi);

        //Exercise
        final RuntimeException exception = assertThrows(RuntimeException.class, () -> widget.sayHelloTo("Rohit"));

        //assert

        assertThat(exception.getMessage(), is("Twitter is down"));
        verify(twitterApi).tweet("Hello Rohit!");
    }
}
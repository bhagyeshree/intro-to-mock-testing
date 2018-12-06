package com.cognizant;

import static org.mockito.Mockito.mock;

class MockTwitterApi  {
    static TwitterApi twitterApi = mock(TwitterApi.class);

    public static void main (String... args) {
        System.out.println(twitterApi.getClass());
    }
}

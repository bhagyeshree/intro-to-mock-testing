package com.cognizant;

final class Widget {

    private final Twitter twitter;

    public Widget(Twitter twitterApi)
    {
        twitter = twitterApi;
    }

    long sayHelloTo(final String name) throws Exception {

        try {
            return twitter.tweet("test");
        } catch (final Exception ex) {
            throw new RuntimeException("Twitter is down", ex);
        }

    }
}

package com.cognizant;

final class Widget {

    private final Twitter twitter;

    public Widget(Twitter twitterApi) {
        this.twitter = twitterApi;
    }

    long sayHelloTo(String name) throws Exception {

        try {
            return twitter.tweet("test");
        } catch (final Exception ex) {
            throw new RuntimeException("Twitter is down", ex);
        }

    }
}

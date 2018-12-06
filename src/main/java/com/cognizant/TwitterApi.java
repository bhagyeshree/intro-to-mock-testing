package com.cognizant;

import javax.naming.CompositeName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwitterApi implements Twitter {

    private final List<String> tweets = new ArrayList<String>();
    @Override
    public List<String> getTweets() {
        return Collections.unmodifiableList(tweets);
    }
    @Override
    public long tweet(final String message) throws Exception {
        Thread.sleep(1000);
        tweets.add(message);
        return tweets.size();
    }


}

package com.cognizant;

import javax.naming.CompositeName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 class TwitterApi {

    private final List<String> tweets = new ArrayList<String>();

    public List<String> getTweets() {
        return Collections.unmodifiableList(tweets);
    }

     long tweet(final String message) throws Exception{
        Thread.sleep(1000);
        tweets.add(message);
        return tweets.size();
    }
}

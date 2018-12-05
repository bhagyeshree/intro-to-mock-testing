package com.cognizant;

import java.util.List;

public interface Twitter {
    public List<String> getTweets();
    long tweet(final String message) throws Exception;

}

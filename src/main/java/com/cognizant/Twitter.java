package com.cognizant;

import java.util.List;

public interface Twitter {
     List<String> getTweets();
    long tweet(final String message) throws Exception;

}

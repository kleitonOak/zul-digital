package com.zuldigital.tweet.outputmessage.core.usercase;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;

import java.util.List;

public interface TweetMessageSource {
    public List<Tweet> getTweetList();
}

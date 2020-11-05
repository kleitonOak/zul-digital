package com.zuldigital.tweet.outputmessage.dataproviders.rest;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;
import com.zuldigital.tweet.outputmessage.core.usercase.TweetMessageSource;
import com.zuldigital.tweet.outputmessage.dataproviders.rest.client.TokenClient;
import com.zuldigital.tweet.outputmessage.dataproviders.rest.client.TweetClient;
import com.zuldigital.tweet.outputmessage.dataproviders.rest.converter.TweetConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TweetRepository implements TweetMessageSource {
    private TweetClient tweetClient;
    private TokenClient tokenClient;

    @Override
    public List<Tweet> getTweetList() {
        return TweetConverter.dtoToEntity(tweetClient.getTweet(tokenClient.getToken()));
    }
}

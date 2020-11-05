package com.zuldigital.tweet.outputmessage.core.usercase;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TweetMessageUserCase {
    private TweetMessageSource tweetMessageSource;
    private SliceMessageUserCase sliceMessageUserCase;

    public List<Tweet> tweetMessage(){
        return sliceMessageUserCase.sliceMessageList(tweetMessageSource.getTweetList());
    }
}

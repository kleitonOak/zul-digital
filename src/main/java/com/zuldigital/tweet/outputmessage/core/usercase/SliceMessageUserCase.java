package com.zuldigital.tweet.outputmessage.core.usercase;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;
import com.zuldigital.tweet.outputmessage.core.exceptions.CoreBusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SliceMessageUserCase {
    private static final Integer LENGTH = 45;

    public Tweet sliceMessage(Tweet unprocessedTweet){
        if(Objects.nonNull(unprocessedTweet) && StringUtils.isEmpty(unprocessedTweet.getMessage())){
            int index = 0;
            List<String> outputList = new ArrayList<>();
            while (index < unprocessedTweet.getMessage().length()) {
                outputList.add(unprocessedTweet.getMessage().substring(index, Math.min(index + LENGTH, unprocessedTweet.getMessage().length())));
                index += LENGTH;
            }
            return Tweet.builder().message(unprocessedTweet.getMessage()).messageSliced(outputList).build();
        }
        throw new CoreBusinessException("You shall not pass empty message on unprocessedTweet Object!");
    }

    public List<Tweet> sliceMessageList(List<Tweet> unprocessedTweetList){
        if(!CollectionUtils.isEmpty(unprocessedTweetList)){
            return unprocessedTweetList.stream().filter(Objects::nonNull).map(this::sliceMessage).collect(Collectors.toList());
        }

        throw new CoreBusinessException("You shall not pass empty unprocessedTweetList!");
    }
}

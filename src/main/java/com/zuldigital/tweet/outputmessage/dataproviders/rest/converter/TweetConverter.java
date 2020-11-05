package com.zuldigital.tweet.outputmessage.dataproviders.rest.converter;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;
import com.zuldigital.tweet.outputmessage.dataproviders.rest.client.dto.TweetDto;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TweetConverter {
    private TweetConverter(){

    }
    public static Tweet dtoToEntity(TweetDto dto){
        return Tweet.builder().message(dto.getText()).build();
    }

    public static List<Tweet> dtoToEntity(List<TweetDto> dtoList){
        List<Tweet> tweetList = null;
        if(!CollectionUtils.isEmpty(dtoList)){
            tweetList = dtoList.stream().filter(Objects::nonNull).map(TweetConverter::dtoToEntity).collect(Collectors.toList());
        }
        return tweetList;
    }
}

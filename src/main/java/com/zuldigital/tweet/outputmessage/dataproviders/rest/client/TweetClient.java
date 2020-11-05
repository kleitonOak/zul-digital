package com.zuldigital.tweet.outputmessage.dataproviders.rest.client;

import com.zuldigital.tweet.outputmessage.core.exceptions.CoreIntegrationException;
import com.zuldigital.tweet.outputmessage.dataproviders.rest.client.dto.TweetDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class TweetClient {
    private RestTemplate restTemplate;

    @Value("$dataproviders.rest.tweet}")
    private String tweetUrl;

    public List<TweetDto> getTweet(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", token);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<TweetDto[]> response = this.restTemplate.exchange(tweetUrl, HttpMethod.GET,request , TweetDto[].class);
        if(response.getStatusCode().is2xxSuccessful()){
            return Arrays.asList(response.getBody().clone());
        }
        throw new CoreIntegrationException("Invalid Tweet Integration!");
    }
}

package com.zuldigital.tweet.outputmessage.dataproviders.rest.client;

import com.zuldigital.tweet.outputmessage.core.exceptions.CoreIntegrationException;
import com.zuldigital.tweet.outputmessage.dataproviders.rest.client.dto.TokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenClient {
    private RestTemplate restTemplate;

    public TokenClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${dataproviders.rest.token}")
    private String tokenUrl;

    public String getToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<TokenDto> response = this.restTemplate.exchange(tokenUrl, HttpMethod.POST,request , TokenDto.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody().getToken();
        }
        throw new CoreIntegrationException("Invalid access token!");
    }
}

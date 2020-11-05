package com.zuldigital.tweet.outputmessage.dataproviders.rest.client;

import com.zuldigital.tweet.outputmessage.core.exceptions.CoreIntegrationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class TokenClient {
    private RestTemplate restTemplate;

    @Value("$dataproviders.rest.token}")
    private String tokenUrl;

    public String getToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = this.restTemplate.exchange(tokenUrl, HttpMethod.POST,request , String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        throw new CoreIntegrationException("Invalid access token!");
    }
}

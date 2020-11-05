package com.zuldigital.tweet.outputmessage.core.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Tweet {
    private String message;
    private List<String> messageSliced;
}

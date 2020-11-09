package com.zuldigital.tweet.outputmessage.configuration;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;
import com.zuldigital.tweet.outputmessage.core.usercase.TweetMessageUserCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.zuldigital.tweet.outputmessage")
public class OutputMessageApplication {

	public static void main(String[] args) {
		var app = SpringApplication.run(OutputMessageApplication.class, args);
		TweetMessageUserCase tweetUserCase = app.getBean(TweetMessageUserCase.class);

		printTweetMessageConsole(tweetUserCase);

		System.exit(0);

	}

	private static void printTweetMessageConsole(TweetMessageUserCase tweetUserCase){
		List<Tweet> tweetList = tweetUserCase.tweetMessage();

		if(!CollectionUtils.isEmpty(tweetList)){
			System.out.printf("Text\t\t\t\t\t | Output");
			for(Tweet tweet: tweetList) {
				System.out.printf(tweet.getMessage());
				int index = 1;
				for(String message: tweet.getMessageSliced()) {
					System.out.printf("\nTweet #%d: %s",index,message);
					index++;
				}
				System.out.print("\n----------------------x-------------------\n");
			}

			System.out.println("THANK YOU!");
		}
	}
}

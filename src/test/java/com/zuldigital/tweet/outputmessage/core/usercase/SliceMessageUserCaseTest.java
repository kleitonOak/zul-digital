package com.zuldigital.tweet.outputmessage.core.usercase;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class SliceMessageUserCaseTest {
    private SliceMessageUserCase sliceMessageUserCase;
    private static final String MESSAGE = "Interferência na Av. Washington Luis sentido Bairro, próximo Praça. Comte. Linneu Gomes. Ocupa uma faixa. #ZS.";

    @BeforeEach
    void setUp() {
        sliceMessageUserCase = new SliceMessageUserCase();
    }

    @Test
    void sliceMessage() {
        Tweet tweet = sliceMessageUserCase.sliceMessage(Tweet.builder().message(MESSAGE).build());
        assertTrue("Interferência na Av. Washington Luis sentido ".equalsIgnoreCase(tweet.getMessageSliced().get(0)));
    }

    @Test
    void sliceMessageList() {
        List<Tweet> tweets = sliceMessageUserCase.sliceMessageList(Arrays.asList(new Tweet[]{Tweet.builder().message(MESSAGE).build()}));
        assertThat(tweets).isNotEmpty();
    }


}
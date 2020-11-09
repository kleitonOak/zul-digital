package com.zuldigital.tweet.outputmessage.core.usercase;

import com.zuldigital.tweet.outputmessage.core.entity.Tweet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class TweetMessageUserCaseTest {
    @MockBean
    private TweetMessageSource tweetMessageSource;
    @MockBean
    private SliceMessageUserCase sliceMessageUserCase;

    private TweetMessageUserCase tweetMessageUserCase;

    @BeforeEach
    void setUp() {
        tweetMessageUserCase = new TweetMessageUserCase(tweetMessageSource,sliceMessageUserCase);
    }

    @Test
    void tweetMessage() {
        Mockito.when(tweetMessageSource.getTweetList()).thenReturn(getMocks());
        Mockito.when(sliceMessageUserCase.sliceMessageList(Mockito.anyList())).thenCallRealMethod();
        List<Tweet> returnedList = tweetMessageUserCase.tweetMessage();
        assertThat(returnedList).isNotEmpty();
    }

    private List<Tweet> getMocks(){

        return Arrays.asList(new Tweet[]{Tweet.builder().message("hiadshudaiuhfdauisdhshuih ").build(), Tweet.builder().message("uhidfwuydgsuydgydugudgdygdu adshgudysgyudd s bdsyug ").build()});
    }
}

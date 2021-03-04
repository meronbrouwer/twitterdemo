package nl.han.meron.resource;

import nl.han.meron.datasource.NoTweetsFromAuthorException;
import nl.han.meron.datasource.TweetsDAO;
import nl.han.meron.resource.dto.TweetDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

class TwitterResourceTest {

    @Test
    void getAllReturns200() {
        // Arrange
        var twitterResource = new TwitterResource();
        var tweets = new ArrayList<TweetDTO>();

        var tweetsDao = Mockito.mock(TweetsDAO.class);
        Mockito.when(tweetsDao.getTweets(-1)).thenReturn(tweets);

        twitterResource.setTweetsDAO(tweetsDao);

        // Act
        var all = twitterResource.getAll();

        // Assert
        Assertions.assertEquals(200, all.getStatus());
    }

    @Test
    void getAllThrowsDoorExceptionFromDao() {
        // Arrange
        var twitterResource = new TwitterResource();
        var tweetsDao = Mockito.mock(TweetsDAO.class);
        Mockito.when(tweetsDao.getTweets(-1)).thenThrow(NoTweetsFromAuthorException.class);

        twitterResource.setTweetsDAO(tweetsDao);

        // Act & Assert
        Assertions.assertThrows(NoTweetsFromAuthorException.class, () -> twitterResource.getAll());
    }
}

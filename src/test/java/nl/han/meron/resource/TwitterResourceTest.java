package nl.han.meron.resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

class TwitterResourceTest {

    @Test
    void getAllReturns200() {
        // Arrange
        var twitterResource = new TwitterResource();

        // Act
        Response all = twitterResource.getAll();

        // Assert
        Assertions.assertEquals(200, all.getStatus());
    }

}

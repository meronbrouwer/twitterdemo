package nl.han.meron.resource;

import nl.han.meron.datasource.NoTweetsFromAuthorException;
import nl.han.meron.datasource.TweetsDAO;
import nl.han.meron.resource.dto.TweetDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/twitter")
public class TwitterResource {

    private TweetsDAO tweetsDAO;

    public TwitterResource() {
        tweetsDAO = new TweetsDAO();
    }

    @GET
    @Path("/tweets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLastTweets(@QueryParam("aantal") int numberOfTweets) {
        return Response.ok(tweetsDAO.getTweets(numberOfTweets)).build();
    }

    @GET
    @Path("/tweets/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTweetsContaining(@QueryParam("contains") String searchString) {
        return Response.ok(tweetsDAO.getTweetsContaing(searchString)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(tweetsDAO.getTweets(-1)).build();
    }

    @GET
    @Path("/tweets/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTweetsForAuthor(@PathParam("author") String author) {
        List<TweetDTO> tweets;

        try {
            tweets = tweetsDAO.getTweets(author);
        } catch (NoTweetsFromAuthorException ex) {
            return Response.status(404).build();
        }

        return Response.ok(tweets).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tweetTweet(TweetDTO tweetDTO) {
        tweetsDAO.addTweet(tweetDTO);

        return Response.status(201).build();
    }
}

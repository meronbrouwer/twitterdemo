package nl.han.meron.resource.dto;

public class TweetDTO {
    private String author;
    private String tweet;

    public TweetDTO() {

    }

    public TweetDTO(String author, String tweet) {
        this.author = author;
        this.tweet = tweet;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

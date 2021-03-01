package nl.han.meron.datasource;

import nl.han.meron.resource.dto.TweetDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TweetsDAO {

    private List<TweetDTO> tweetDTOS = new ArrayList<>();

    public TweetsDAO() {
        tweetDTOS.add(new TweetDTO("Meron Brouwer", "Vandaag weer les geven"));
        tweetDTOS.add(new TweetDTO("Mark Rutte", "Het is van groot belang dat we ons allemaal aan de Corona regels houden"));
        tweetDTOS.add(new TweetDTO("Thierry Baudet", "Corona is onzin"));
        tweetDTOS.add(new TweetDTO("Jesse Klaver", "Mijn zusje heeft een buurvrouw, wiens dochter op een IC werkt"));
        tweetDTOS.add(new TweetDTO("Linus Torvalds", "I pronounce Linux as Linux"));
    }

    public List<TweetDTO> getTweets(int numberOfTweets) {
        if (numberOfTweets == -1) {
            return tweetDTOS;
        }
        return tweetDTOS.subList(0, numberOfTweets);
    }

    public void addTweet(TweetDTO tweetDTO) {
        tweetDTOS.add(tweetDTO);
    }

    public List<TweetDTO> getTweets(String author) {
        var tweets = tweetDTOS.stream().filter(t -> t.getAuthor().toLowerCase().contains(author.toLowerCase())).collect(Collectors.toList());

        if (tweets.isEmpty()) {
            throw new NoTweetsFromAuthorException();
        }

        return tweets;
    }

    public Object getTweetsContaing(String searchString) {
        var filteredList = tweetDTOS.stream().filter(tweet -> tweet.getTweet().toLowerCase().contains(searchString.toLowerCase())).collect(Collectors.toList());

        return filteredList;
    }
}

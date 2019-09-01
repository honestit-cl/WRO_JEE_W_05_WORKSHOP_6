package pl.coderslab.workshop.twitter.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.workshop.twitter.dto.AddTweetDTO;
import pl.coderslab.workshop.twitter.model.Tweet;
import pl.coderslab.workshop.twitter.model.User;
import pl.coderslab.workshop.twitter.repositories.TweetRepository;
import pl.coderslab.workshop.twitter.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
@Transactional
public class UserService {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public UserService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void tweet(String email, AddTweetDTO tweetData) {
        Tweet tweet = new Tweet();
        tweet.setContent(tweetData.getContent());
        tweet.setCreated(LocalDateTime.now());

        User user = userRepository.getByEmail(email);
        tweet.setUser(user);

        tweetRepository.save(tweet);
    }
}

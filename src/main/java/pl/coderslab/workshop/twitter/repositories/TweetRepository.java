package pl.coderslab.workshop.twitter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop.twitter.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}

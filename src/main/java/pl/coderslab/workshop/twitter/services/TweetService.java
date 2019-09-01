package pl.coderslab.workshop.twitter.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.workshop.twitter.dto.TweetDTO;
import pl.coderslab.workshop.twitter.model.Tweet;
import pl.coderslab.workshop.twitter.repositories.TweetRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TweetService {

    private TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<TweetDTO> getTopTweets() {
        Page<Tweet> tweets = tweetRepository.findAll(new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "created")));
        List<Tweet> content = tweets.getContent();
        return content.stream().map(source -> {
            TweetDTO dto = new TweetDTO();
            dto.setContent(source.getContent());
            dto.setCreated(source.getCreated());
            dto.setOwnerUsername(source.getUser().getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

}

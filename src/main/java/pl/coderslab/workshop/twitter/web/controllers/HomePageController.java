package pl.coderslab.workshop.twitter.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.workshop.twitter.dto.AddTweetDTO;
import pl.coderslab.workshop.twitter.services.TweetService;
import pl.coderslab.workshop.twitter.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomePageController {

    private UserService userService;
    private TweetService tweetService;

    public HomePageController(UserService userService, TweetService tweetService) {
        this.userService = userService;
        this.tweetService = tweetService;
    }

    @GetMapping
    public String prepareHomePage(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        model.addAttribute("tweetData", new AddTweetDTO());
        model.addAttribute("latestTweets", tweetService.getTopTweets());
        return "index";
    }

    @PostMapping("/addTweet")
    public String processAddTweet(@ModelAttribute("tweetData") @Valid AddTweetDTO tweetData, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "index";
        }
        userService.tweet(principal.getName(), tweetData);
        return "redirect:/";
    }
}

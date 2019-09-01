package pl.coderslab.workshop.twitter.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TweetDTO {

    private String content;
    private String ownerUsername;
    private LocalDateTime created;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}

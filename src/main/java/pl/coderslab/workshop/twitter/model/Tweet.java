package pl.coderslab.workshop.twitter.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tweets")
public class Tweet extends AbstractEntity {

    @Column(nullable = false, length = 140)
    private String content;
    private LocalDateTime created;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package pl.coderslab.workshop.twitter.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message extends AbstractEntity {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne(optional = false)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}

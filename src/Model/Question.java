package Model;

import Model.UserModel.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {
    private UUID id;
    private String question;
    private List<Comment> comments;
    private List<Tag> tags;
    private Integer bounty;
    private Status status;
    private List<StatusVoteCount> statusVoteCounts;
    private Integer upvote;
    private List<Answer> answers;
    private UUID userId;
    private List<User> subscribers;

    public Question(String question, UUID userId) {
        this.id = UUID.randomUUID();
        this.question = question;
        this.userId = userId;
        this.status = Status.Open;
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public Question(String question, UUID userId, Integer bounty) {
        this.id = UUID.randomUUID();
        this.question = question;
        this.userId = userId;
        this.bounty = bounty;
        this.status = Status.Open;
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }
    public void setBounty(Integer bounty) {
        this.bounty = bounty;
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
    public void addStatusVoteCount(StatusVoteCount statusVoteCount) {
        statusVoteCounts.add(statusVoteCount);
    }
    public void addVote() {
        this.upvote++;
    }

    public UUID getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getBounty() {
        return bounty;
    }

    public Status getStatus() {
        return status;
    }

    public List<StatusVoteCount> getStatusVoteCounts() {
        return statusVoteCounts;
    }

    public Integer getUpvote() {
        return upvote;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public UUID getUserId() {
        return userId;
    }
    public void addSubscriber(User user) {
        this.subscribers.add(user);
    }
    public void removeSubscriber(User user) {
        this.subscribers.remove(user);
    }

    public List<User> getSubscribers() {
        return subscribers;
    }
}

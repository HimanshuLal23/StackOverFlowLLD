package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer {
    private UUID id;
    private UUID userId;
    private String answer;
    private int votes;
    private List<Comment> comments;

    public Answer(UUID userId, String answer) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.answer = answer;
        this.comments = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getAnswer() {
        return answer;
    }

    public int getVotes() {
        return votes;
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public void setVote() {
        this.votes++;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}

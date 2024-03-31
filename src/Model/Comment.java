package Model;

import java.util.UUID;

public class Comment {
    private UUID id;
    private UUID userId;
    private String comment;

    public Comment(UUID userId, String comment) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }
}

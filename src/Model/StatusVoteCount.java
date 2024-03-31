package Model;

public class StatusVoteCount {
    private Status status;
    private Integer count;

    public StatusVoteCount(Status status, Integer count) {
        this.status = status;
        this.count = count;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

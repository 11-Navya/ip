package duke;

public class Task {
    protected String description;
    protected boolean isDone = false;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getTask(){
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
    public void setStatusIcon(Boolean done){
        isDone = done;
    }

}


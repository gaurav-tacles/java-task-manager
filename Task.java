import java.time.LocalDate;

public class Task{
   private int taskID;
    private String taskName;
    private String description;
    private LocalDate creationDate;
    private String dueDate;
    private String priority;
    private String status;

   public Task(int taskID, String taskName, String description, LocalDate creationDate, String dueDate, String priority, String status){
    this.taskID = taskID;
    this.taskName = taskName;
    this.description = description;
    this.creationDate = creationDate;
    this.dueDate = dueDate;
    this.priority = priority;
    this.status = status;
    } 
    public int getTaskID() {
        return taskID;
    }
    public String getTaskName() {
        return taskName;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getPriority() {
        return priority;
    }
    public String getStatus() {
        return status;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
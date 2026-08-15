public class Main{
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask();
        taskManager.viewTasks();
        taskManager.updateTask();
        taskManager.viewTasks();
    }
}
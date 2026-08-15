import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.FileWriter;
import java.io.IOException;

public class TaskManager {

    private Scanner sc = new Scanner(System.in);

    private ArrayList<Task> tasks;
    public TaskManager() {
        this.tasks = new ArrayList<Task>();
    }
    public void addTask(){
        System.out.print("Enter Task Name : ");
        String taskName = sc.nextLine();
        System.out.print("Enter Task Description : ");
        String description = sc.nextLine();
        System.out.print("Enter Task Due Date [YYYY-MM-DD] : ");
        String dueDate = sc.nextLine();
        System.out.print("Enter Task priority [LOW/MEDIUM/HIGH] : ");
        String priority = sc.nextLine();
        taskIDCounter++;
            Task newTask = new Task(
                taskIDCounter,
                taskName,
                description,
                LocalDate.now(),
                dueDate,
                priority,
                "Pending"
            );
            tasks.add(newTask);
            saveTasksToFile();
            System.out.println("Task Added Successfully!");
            
    }
    private int taskIDCounter;

    public void viewTasks() {
        for(Task task : tasks) {
            System.out.println("Task ID: " + task.getTaskID());
            System.out.println("Task Name: " + task.getTaskName());
            System.out.println("Task Description: " + task.getDescription());
            System.out.println("Task Creation Date: " + task.getCreationDate());
            System.out.println("Task Due Date: " + task.getDueDate());
            System.out.println("Task Priority: " + task.getPriority());
            System.out.println("Task Status: " + task.getStatus());
            System.out.println();
        }
    }
    public void updateTask(){
        System.out.print("Enter Task ID to Update : ");
        int taskIdUpdate = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        boolean taskFound = false;
        for(Task task : tasks){
            if(task.getTaskID() == taskIdUpdate){
                System.out.println("Task Found !");

                System.out.println("What do you want to update ?");
                System.out.println("1. Task Name");
                System.out.println("2. Task Description");
                System.out.println("3. Task Due Date");
                System.out.println("4. Task Priority");
                System.out.println("5. Task Status");
                System.out.print("Enter your choice [1-5] : ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch(choice){
                    case 1:
                        System.out.print("Your Current Task Name : " + task.getTaskName() + "\n");
                        System.out.print("Enter New Task Name : ");
                        String newTaskName = sc.nextLine();
                        task.setTaskName(newTaskName);
                        break;
                    case 2:
                        System.out.print("Your Current Task Description : " + task.getDescription() + "\n");
                        System.out.print("Enter New Task Description : ");
                        String newDescription = sc.nextLine();
                        task.setDescription(newDescription);
                        break;
                    case 3:
                        System.out.print("Your Current Task Due Date : " + task.getDueDate() + "\n");
                        System.out.print("Enter New Task Due Date [YYYY-MM-DD] : ");
                        String newDueDate = sc.nextLine();
                        task.setDueDate(newDueDate);
                        break;
                    case 4:
                        System.out.print("Your Current Task Priority : " + task.getPriority() + "\n");
                        System.out.print("Enter New Task Priority [LOW/MEDIUM/HIGH] : ");
                        String newPriority = sc.nextLine();
                        task.setPriority(newPriority);
                        break;
                        case 5:
                        System.out.print("Your Current Task Status : " + task.getStatus() + "\n");
                        System.out.print("Select New Task Status : " + "\n");
                        System.out.println("1. Pending");
                        System.out.println("2. In Progress");
                        System.out.println("3. Completed");
                        System.out.print("Enter your choice [1-3] : ");
                        int statusChoice = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        String newStatus;
                        switch(statusChoice){
                            case 1:
                                newStatus = "Pending";
                                break;
                            case 2:
                                newStatus = "In Progress";
                                break;
                            case 3:
                                newStatus = "Completed";
                                break;
                            default:
                                System.out.println("Invalid choice. No updates made.");
                                return;
                        }
                        task.setStatus(newStatus);
                        break;
                    default:
                        System.out.println("Invalid choice. No updates made.");
                }
                taskFound = true;
                break;
                
            }
        }
        if(!taskFound){
            System.out.println("Task ID not found in your task list.");
        }
    }
    public void deleteTask(){
        System.out.print("Enter Task ID to Delete : ");
        int taskIdDelete = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        boolean taskFound = false;
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getTaskID() == taskIdDelete){
                tasks.remove(i);
                System.out.println("Task Deleted Successfully!");
                taskFound = true;
                break;
            }
        }
        if(!taskFound){
            System.out.println("Task ID not found in your task list.");
        }
    }
    public void saveTasksToFile(){
        try {
            FileWriter Writer = new FileWriter("tasks.txt");
            for (Task task : tasks) {
                Writer.write(task.getTaskID() + "|" +
                 task.getTaskName() + "|" +
                 task.getDescription() + "|" +
                 task.getCreationDate() + "|" +
                 task.getDueDate() + "|" +
                 task.getPriority() + "|" +
                 task.getStatus() + "\n");
                
            }
             Writer.close();
            
        }
        catch (IOException e) {
            

        }
 
    }
    public void loadTasksFromFile(){
        try {
            Scanner fileScanner = new Scanner(new java.io.File("tasks.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("\\|");
                int taskID = Integer.parseInt(data[0]);
                String taskName = data[1];
                String description = data[2];
                LocalDate creationDate = LocalDate.parse(data[3]);
                String dueDate = data[4];
                String priority = data[5];
                String status = data[6];

                Task task = new Task(
                    taskID, 
                    taskName, 
                    description, 
                    creationDate, 
                    dueDate, 
                    priority, 
                    status);

                tasks.add(task);

            }
            fileScanner.close();
           
                
        }
        catch (java.io.FileNotFoundException e) {
            System.out.println("An error occurred while loading tasks from file.");
        }   
    }
}
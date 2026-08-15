import java.util.Scanner;

import javax.sound.sampled.Line;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();
        taskManager.loadTasksFromFile();

        if(Line.trim().isEmpty()){
            continue;
        }

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("====================");
            System.out.println(" TASK MANAGER ");
            System.out.println("====================");


            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.println("====================");

            System.out.print("Enter your choice [1-5] : ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    taskManager.updateTask();
                    break;
                case 4:
                    taskManager.deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
        sc.close();
    }

}
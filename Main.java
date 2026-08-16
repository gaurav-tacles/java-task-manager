import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();
        taskManager.loadTasksFromFile();

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("====================");
            System.out.println(" TASK MANAGER ");
            System.out.println("====================");


            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Mark Task as Completed");
            System.out.println("7. Task Statistics");
            System.out.println("8. Show Overdue Tasks");
            System.out.println("9. Show Due Soon Tasks");
            System.out.println("10. Exit");
            
            System.out.println("====================");
            int choice;

            while (true) {
                System.out.print("Enter your choice [1-10] : ");

                    if (sc.hasNextInt()) {
                        choice = sc.nextInt();
                        sc.nextLine();
                            if (choice >= 1 && choice <= 10) {
                                break;
                        }
                            System.out.println("Invalid choice! Please enter a number between 1 and 10.");
                    }
            else {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                }
            }
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
                    taskManager.searchTask();
                    break;
                case 6:
                    taskManager.markTaskCompleted();
                    break;
                case 7:
                    taskManager.showTaskStatistics();
                    break;
                case 8:
                    taskManager.showOverdueTasks();
                    break;
                case 9:
                    taskManager.showDueSoonTasks();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 10.");
            }
        }
        sc.close();
    }

}
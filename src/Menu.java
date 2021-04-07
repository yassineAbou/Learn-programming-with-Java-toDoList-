import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    //write a user menu
    public static void showMenu() {
        int option = 0;
        System.out.println("\nWelcome to the ToDoList application.\n");
        System.out.println("What would you like to do?\n");
        System.out.println("" + "0. Show options\n" + "1. Add a topic\n" + "2. Create task.\n" + "3. Display task.\n" + "4. Mark as done.\n"
                + "5. Remove task. \n" + "6. change Task.\n" + "7. Rename task. \n" + "8. Assign Task.\n"
                + "9. Assign deadline.\n\n" + "10. Quit.");

        do {

            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nEnter an option: ");
                int option1 = scanner.nextInt();
                option = option1;

                switch (option) {
                    //Case 1 allows the user to know the options.
                    case 0:
                        System.out.println("\nWelcome to the ToDoList application.\n");
                        System.out.println("What would you like to do?\n");
                        System.out.println("" + "0. Show options\n" + "1. Add a topic\n" + "2. Create task.\n" + "3. Display task.\n" + "4. Mark as done.\n"
                                + "5. Remove task. \n" + "6. change Task.\n" + "7. Rename task. \n" + "8. Assign Task.\n"
                                + "9. Assign deadline.\n\n" + "10. Quit.");
                        break;
                    //Case 2 allows the user to add a topic.
                    case 1:
                        ToDoList topic = new ToDoList();
                        break;
                    //Case 2 allow the user to create new tasks.
                    case 2:
                        ToDoList.createTask();
                        break;
                    //Case 3 allows the user to display tasks.
                    case 3:
                        ToDoList.display();
                        break;
                    //Cae 4 allows the user to mark tasks as done.
                    case 4:
                        ToDoList.markAsDone();
                        break;
                    //Case 5 allows the user to remove tasks.
                    case 5:
                        ToDoList.removeTask();
                        break;
                    //Case 6 allows the user to change tasks.
                    case 6:
                        ToDoList.changeTask();
                        break;
                    //Case 7 allows the user to rename tasks.
                    case 7:
                        ToDoList.renameTask();
                        break;
                    //case 8 allows the user to assign new employee for the task
                    case 8:
                        ToDoList.assignTask();
                        break;
                    //Case 9 allows the user to assign new deadline for the task
                    case 9:
                        ToDoList.assignDeadLine();
                        break;
                    //Case 10 allows the user to quit from the ToDoList.
                    case 10:
                        System.out.println("==============================================================================================================================================================");
                        break;
                    //The default allows the user to choose what they want.
                    default:
                        System.out.println("Error: invalid option please try again!");

                }

            } catch (InputMismatchException e) {
                System.out.println("Error: invalid option please try again!");
                continue;

            }
            


        } while (option != 10) ;
        System.out.println("thank you for using our ToDoList application, happy to see you again.");
    }
}



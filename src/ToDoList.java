import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ToDoList {

    static String topic;
    static List<Task> tasks = new ArrayList<>();

    public ToDoList() {
        tasks.clear();
        Scanner enteredTopic = new Scanner(System.in);
        System.out.println("Enter topic for the ToDoList:");
        String entered = enteredTopic.nextLine();
        System.out.println("Topic added successfully.");
        topic = entered;

    }




    //below, implement the methods provided in the UML diagram
    //I provided the task creation and the task creation methods
    //display, markAsDone, removeTask and renameTask

// create new tasks
    public static void createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter task name:");
        String name = sc.nextLine();
        if (tasks.stream().anyMatch(task -> name.equals(task.getName()))) {
           System.out.println("This Task is already exists please enter another Task.");
        }
        else {
            System.out.println("enter employee name:");
            String employee = sc.nextLine();
            System.out.println("enter due date:");
            System.out.println("Please enter your date in the format MM-dd-yyyy");
            Scanner scanner = new Scanner(System.in);
            Date d = null;
            try {
                d = new SimpleDateFormat("MM-dd-yyyy").parse(scanner.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Task t = new Task();
            t.setName(name);
            t.setDeadLine(d);
            t.setEmployee(employee);
            tasks.add(t);
            System.out.println("Task added successfully.");
        }
    }

    //display tasks
    public static void display() {
                if (tasks.size() == 0) {
                    System.out.println("================================================     Our Todo List for " + topic + " is currently empty!     ================================================================");
                } else {
                    System.out.println("================================================     Here is our Todo List for " + topic + "     ============================================================================\n");

                    for(int i=0;i<tasks.size();i++) {
                        System.out.println("Task " + i + " is " + tasks.get(i));
                        System.out.println("=====================================================================================================================================================================");
                    }
                }
    }

    //mark tasks asDonne
    public static void markAsDone() {
        Scanner mark = new Scanner(System.in);
        System.out.println("enter the name of the Task that you've done:");
        String done = mark.nextLine();

        if (tasks.stream().anyMatch(task -> done.equals(task.getName()))) {
            System.out.println("Marking Task: " + done + " as completed.");
            int index = tasks.stream()
                    .map(user -> user.getName())
                    .collect(Collectors.toList())
                    .indexOf(done);

            tasks.get(index).setDone(true);
            System.out.println("Task marked as done successfully");
        } else {
            System.out.println(" No such task at this name!");
        }
    }

    //remove tasks that have been created
    public static void removeTask() {
        Scanner delete = new Scanner(System.in);
        System.out.println("enter the name of the Task that you want to remove: ");
        String rmv = delete.nextLine();

               if(tasks.stream().anyMatch(task -> rmv.equals(task.getName()))) {
                   System.out.println("Removing Task: " + rmv);
                   tasks.removeIf(task -> task.getName().equals(rmv));
                   System.out.println("Task removed successfully.");
               }
               else {
                   System.out.println("Could not remove task, no task at this name!");
               }
               }


    //Change the tasks that have been created
    public static void changeTask() {
        Scanner mark = new Scanner(System.in);
        System.out.println("enter the name of the task name that you want to change:");
        String xxx = mark.nextLine();

        if (tasks.stream().anyMatch(task -> xxx.equals(task.getName()))) {
            Scanner update = new Scanner(System.in);
            System.out.println("enter a new Task:");
            String nt = update.nextLine();
            System.out.println("enter the employee name:");
            String ne = update.nextLine();
            System.out.println("enter due date:");
            Scanner scanner = new Scanner(System.in);
            Date ddd = null;
            try {
                ddd = new SimpleDateFormat("MM-dd-yyyy").parse(scanner.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Changing task " + xxx + " to " + nt + ".");
            Task t = new Task();
            t.setEmployee(ne);
            t.setDeadLine(ddd);
            t.setName(nt);
            int index = tasks.stream()
                    .map(user -> user.getName())
                    .collect(Collectors.toList())
                    .indexOf(xxx);
            tasks.set(index, t);
            System.out.println("Task has changed successfully.");

        } else {
            System.out.println("Could not change task, no task at this name!");
        }
    }

    //Rename the Task that you've created
    public static void renameTask() {
        Scanner rename = new Scanner(System.in);
        System.out.println("enter the name of the task name that you want to rename:");
        String rnm = rename.nextLine();
        if (tasks.stream().anyMatch(task -> rnm.equals(task.getName()))) {
            Scanner retask = new Scanner(System.in);
            System.out.println("enter a new name of the Task: ");
            String nnn = retask.nextLine();
            System.out.println("Renaming Task " + rnm + " to " + nnn);
            int index = tasks.stream()
                    .map(user -> user.getName())
                    .collect(Collectors.toList())
                    .indexOf(rnm);

            tasks.get(index).setName(nnn);
            tasks.get(index).setDone(false);
            System.out.println("Task renamed successfully");
        } else {
            System.out.println("No such Task at this name!");
        }
        }


    //implement boolean method for assignTask
    public  static Boolean assignTask() {
        Scanner assign = new Scanner(System.in);
        System.out.println("enter the name of the task name that you want to assign:");
        String agn = assign.nextLine();
        if (tasks.stream().anyMatch(task -> agn.equals(task.getName()))) {
            Scanner asstask = new Scanner(System.in);
            System.out.println("enter new employee:");
            String eee = asstask.nextLine();
            System.out.println("Assigning " + eee + " to the Task: " + agn + ".");
            int index = tasks.stream()
                    .map(user -> user.getName())
                    .collect(Collectors.toList())
                    .indexOf(agn);
            tasks.get(index).setEmployee(eee);
            tasks.get(index).setDone(false);
            System.out.println("Task assigned successfully.");
            return true;
        } else {
            System.out.println("No such Task at this name!");
            return false;
        }
    }

    //implement boolean method for assignDeadLine
    public static Boolean assignDeadLine() {
        Scanner deadline = new Scanner(System.in);
        System.out.println("enter the name of the task name that you want to assign deadline:");
        String agnd = deadline.nextLine();
        if (tasks.stream().anyMatch(task -> agnd.equals(task.getName()))) {
            System.out.println("assign new deadline: ");
            System.out.println("enter the date in the format MM-dd-yyyy:");
            Scanner scanner = new Scanner(System.in);
            Date de = null;
            try {
                de = new SimpleDateFormat("MM-dd-yyyy").parse(scanner.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Assigning the Deadline " + de + " to the Task: " + agnd);
            int index = tasks.stream()
                    .map(user -> user.getName())
                    .collect(Collectors.toList())
                    .indexOf(agnd);
            tasks.get(index).setDeadLine(de);
            tasks.get(index).setDone(false);
            System.out.println("Deadline assigned successfully.");
            return true;

        } else {
            System.out.println("No such Task at this name!");
            return false;
        }
    }



    }















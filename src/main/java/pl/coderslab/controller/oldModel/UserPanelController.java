package pl.coderslab.controller.oldModel;

import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.dao.UserDAO;
import pl.coderslab.entity.Solution;

import java.util.List;
import java.util.Scanner;

import static pl.coderslab.controller.oldModel.AdminController.closeApp;
import static pl.coderslab.controller.oldModel.MainController.getInt;
import static pl.coderslab.controller.oldModel.MainController.scanner;

public class UserPanelController {

    public static void main(String[] args) throws Exception {
        int userID;
        try {
            userID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new Exception("Wrong user id.");
        }
        if (UserDAO.loadUserById(userID) == null) throw new Exception("Enter valid id.");
        scanner = new Scanner(System.in);
        userToolsOptions(userID);
    }


    public static void userToolsOptions(int userId) {
        while (true) {
            System.out.println("What would you like to do: \n(1) add a solution\n(2) view your solutions\n(0) quit");
            switch (getInt(scanner)) {
                case 1:
                    addSolution(userId);
                    break;
                case 2:
                    viewSolutions(userId);
                    break;
                case 0:
                    closeApp();
                    break;
                default:
                    System.out.println("Incorrect input - try again.");

            }
        }
    }


    public static void addSolution(int id) {
        try {
            List<Solution> solutions = SolutionDAO.loadAllNotDone(id);

            for (Solution solution : solutions) {
                System.out.println(solution);
            }
        } catch (Exception e) {
            System.out.println("You have no exercises pending");
            userToolsOptions(id);
        }
        int taskId = getIntFromUser(Type.SOLUTION_ID);
        String description = getDescription();
        Solution solution = new Solution(description, taskId, id);
        try {
            SolutionDAO.saveToDb(solution);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewSolutions(int id) {
        try {
            for (Solution solution : SolutionDAO.loadAllByUserID(id)) {
                System.out.println(solution);
            }
        } catch (Exception e) {
            System.out.println("You have no solutions in the database");
        }
    }

    public static String getDescription() {
        System.out.println("Enter solution: ");
        return scanner.nextLine();
    }

    public static int getIntFromUser(Type type) {
        switch (type) {
            case USER_ID:
                System.out.println("Enter your id: ");
                break;
            case SOLUTION_ID:
                System.out.println("Enter your solution id: ");
                break;
        }
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Wrong input - you have to enter a number");
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public enum Type {
        USER_ID,
        SOLUTION_ID,
    }
}

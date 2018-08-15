package pl.coderslab.controller.oldModel;


import pl.coderslab.dao.GroupDAO;
import pl.coderslab.entity.Group;

import java.util.List;

import static pl.coderslab.controller.oldModel.AdminController.closeApp;
import static pl.coderslab.controller.oldModel.AdminController.getUserConfirmation;
import static pl.coderslab.controller.oldModel.MainController.getInt;
import static pl.coderslab.controller.oldModel.MainController.scanner;

public class GroupController {
    static void groupOptions() {
        while (true) {
            printAllGroups();
            System.out.println("What would you like to do: \n(1) edit group\n(2) add a new group\n(3) delete a group\n(0) quit the app");
            switch (getInt(scanner)) {
                case 1:
                    editGroup();
                    break;
                case 2:
                    addGroup();
                    break;
                case 3:
                    deleteGroup();
                    break;
                case 0:
                    closeApp();
                    break;
                default:
                    System.out.println("Incorrect input - try again.");
            }
        }

    }

    public static void editGroup() {
        int id = getID();
        String name = getStringFromUser();
        Group newGroup = new Group(id, name);
        try {
            GroupDAO.saveToDb(newGroup);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addGroup(){
        Integer id = null;
        String name = getStringFromUser();
        Group newGroup = new Group(id, name);
        try {
            GroupDAO.saveToDb(newGroup);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteGroup() {
        int id = getID();
        if (getUserConfirmation() == true && id != 0)
            GroupDAO.delete(id);
    }

    public static void printAllGroups() {
        try {
            List<Group> allGroups = GroupDAO.findAll();
            for (Group group : allGroups) {
                System.out.println(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getStringFromUser() {
        System.out.println("Enter group name: ");
        return scanner.nextLine();
    }

    public static int getID() {
        System.out.println("Enter group id: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Id has to be a number. \nEnter id: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}

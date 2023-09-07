package util;

import java.util.Scanner;
import menu.Menu;

public class MenuUtil {

    public static String name;
    public static String surname;

    public static void start() {
        System.out.println("Welcome to file send application!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        MenuUtil.name = name.trim();

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter surname: ");
        String surname = sc.nextLine();
        MenuUtil.surname = surname.trim();
        showMenu();
    }

    public static void showMenu() {
        Menu[] services = Menu.values();
        System.out.println("Menu: ");
        for (Menu service : services) {
            if (service != Menu.UNKNOWN) {
                System.out.println(service);
            }
        }
        selectService();
    }

    public static void selectService() {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Select operation: ");
            int id = sc.nextInt();

            Menu menuService = Menu.select(id);

            if (menuService != Menu.UNKNOWN) {
                menuService.process();

            } else {
                System.out.println(Menu.UNKNOWN.getLabel());
            }
        } catch (Exception ex) {
            System.out.println("Please enter number of operation!");
        }
        showMenu();
    }

}

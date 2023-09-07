package menu;

import menu.services.Exit;
import menu.services.SendFile;
import menu.services.interfaces.MenuService;

public enum Menu {
    SEND(1, new SendFile(), "Send File"),
    EXIT(2, new Exit(), "Exit"),
    UNKNOWN("Invalid operation");

    private int id;
    private MenuService menuService;
    private String label;

    Menu(String label) {
        this.label = label;
    }

    Menu(int id, MenuService menuService, String label) {
        this.id = id;
        this.menuService = menuService;
        this.label = label;
    }

    @Override
    public String toString() {
        return id + ". " + label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Menu select(int id) {
        Menu[] services = Menu.values();
        for (Menu service : services) {
            if (id == service.getId()) {
                return service;
            }
        }
        return UNKNOWN;
    }

    public void process() {
        menuService.proccess();
    }

}

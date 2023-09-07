package menu.services;

import menu.services.interfaces.MenuService;

public class Exit implements MenuService {
    
    @Override
    public void proccess() {
        System.exit(0);
    }
    
}

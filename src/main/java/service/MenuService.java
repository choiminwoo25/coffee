package service;

import controller.MenuRegisterRequest;
import dao.MenuDao;
import domain.Menu;

import java.util.List;

public class MenuService {

    private final MenuDao menuDao;

    public MenuService(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public Long register(MenuRegisterRequest req) {
        Menu menu = new Menu();
        menu.setMenuName(req.getMenuName());
        menu.setCategory(req.getCategory());
        menu.setPrice(req.getPrice());
        menu.setReleaseDate(req.getReleaseDate());
        return menuDao.insert(menu);
    }

    public List<Menu> getMenuList() {

        return menuDao.findAll();
    }

    public Menu getMenu(Long id) {

        return menuDao.findById(id);
    }
}

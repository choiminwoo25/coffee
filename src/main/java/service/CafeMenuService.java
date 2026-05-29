package service;

import controller.CafeMenuRegisterRequest;
import dao.CafeMenuDao;
import domain.CafeMenu;

import java.util.List;

public class CafeMenuService {

    private final CafeMenuDao cafeMenuDao;

    public CafeMenuService(CafeMenuDao cafeMenuDao) {
        this.cafeMenuDao = cafeMenuDao;
    }

    public Long register(CafeMenuRegisterRequest req) {
        CafeMenu cafeMenu = new CafeMenu();
        cafeMenu.setMenuName(req.getMenuName());
        cafeMenu.setCategory(req.getCategory());
        cafeMenu.setPrice(req.getPrice());
        cafeMenu.setReleaseDate(req.getReleaseDate());
        return cafeMenuDao.insert(cafeMenu);
    }

    public List<CafeMenu> getMenuList() {

        return cafeMenuDao.findAll();
    }

    public CafeMenu getMenu(Long id) {

        return cafeMenuDao.findById(id);
    }
}

package controller;

import domain.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.MenuService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {

        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Menu> menus = menuService.getMenuList();
        model.addAttribute("menus", menus);
        return "menu/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Menu menu = menuService.getMenu(id);
        model.addAttribute("menu", menu);
        return "menu/detail";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("menuRegisterRequest", new MenuRegisterRequest());
        return "menu/form";
    }

    @PostMapping("/new")
    public String register(@Valid @ModelAttribute MenuRegisterRequest menuRegisterRequest,
                           Errors errors) {
        if (errors.hasErrors()) {
            return "menu/form";
        }
        Long id = menuService.register(menuRegisterRequest);
        return "redirect:/menu/" + id;   // PRG 패턴
    }
}

package controller;

import domain.CafeMenu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.CafeMenuService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cafemenu")
public class CafeMenuController {

    private final CafeMenuService cafeMenuService;

    public CafeMenuController(CafeMenuService cafeMenuService) {

        this.cafeMenuService = cafeMenuService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<CafeMenu> cafeMenus = cafeMenuService.getMenuList();
        model.addAttribute("menus", cafeMenus);
        return "menu/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        CafeMenu cafeMenu = cafeMenuService.getMenu(id);
        model.addAttribute("menu", cafeMenu);
        return "menu/detail";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("cafeMenuRegisterRequest", new CafeMenuRegisterRequest());
        return "menu/form";
    }

    @PostMapping("/new")
    public String register(@Valid @ModelAttribute CafeMenuRegisterRequest cafeMenuRegisterRequest,
                           Errors errors) {
        if (errors.hasErrors()) {
            return "menu/form";
        }
        Long id = cafeMenuService.register(cafeMenuRegisterRequest);
        return "redirect:/cafemenu/" + id;   // PRG 패턴
    }
}

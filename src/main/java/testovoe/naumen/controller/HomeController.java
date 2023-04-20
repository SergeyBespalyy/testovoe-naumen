package testovoe.naumen.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер HomeController главной страницы сервиса
 * */

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    @GetMapping
    public String main(Model model) {
        log.info("Получен запрос к эндпоинту: /");
        model.addAttribute("title", "Главная страница");
        return "home";
    }
}

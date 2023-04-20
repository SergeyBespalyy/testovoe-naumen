package testovoe.naumen.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import testovoe.naumen.service.PersonServiceImpl;

/** Класс описывающий RestController со следующими энпоинтами:
 * * GET "/statistic/age - получение статистики по самому большому возрасту имени из файла
 * * GET "/statistic/count - получение статистики по количеству запросов имен,
 * то происходит поиск на стороннем ресурсе
 */

@Controller
@RequestMapping("/statistic")
@Slf4j
public class StatisticController {

    private final PersonServiceImpl personService;

    public StatisticController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public String index(){
        log.info("Получен запрос к эндпоинту: /statistic");
        return "statistic/statistic";
    }

    @GetMapping("/age")
    public String age(Model model){
        log.info("Получен запрос к эндпоинту: /statistic/age");
        model.addAttribute("person", personService.findAgeUp());
        return "statistic/age";
    }

    @GetMapping("/count")
    public String count(Model model){
        log.info("Получен запрос к эндпоинту: /statistic/count");
        model.addAttribute("persons", personService.findCountUp());
        model.addAttribute("personsOut", personService.findCountOut());
        return "statistic/count";
    }

}

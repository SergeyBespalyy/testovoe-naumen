package testovoe.naumen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import testovoe.naumen.service.PersonService;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    private final PersonService personService;

    public StatisticController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String index(){
        return "statistic/statistic";
    }


    @GetMapping("/age")
    public String age(Model model){
        model.addAttribute("person", personService.findAgeUp());
        return "statistic/age";
    }

    @GetMapping("/count")
    public String count(Model model){
        model.addAttribute("persons", personService.findCountUp());
        model.addAttribute("personsOut", personService.findCountOut());
        return "statistic/count";
    }

}

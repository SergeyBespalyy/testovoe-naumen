package testovoe.naumen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import testovoe.naumen.model.ApiModel;
import testovoe.naumen.model.Person;
import testovoe.naumen.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(required = false, name = "sh") String name){
        if (name == null || name.isEmpty()){
            String messageError = "Введите имя";
            model.addAttribute("exception", messageError);
            return "person/search";
        } else {
            model.addAttribute("person", personService.searchPerson(name));
        }
        return "person/search";
    }

    @GetMapping("/otherapi")
    public String getAge(@RequestParam(name = "sh", required = false) String name,
                         Model model) {
        if (name == null || name.isEmpty()){
            String messageError = "Введите значение";
            model.addAttribute("exception", messageError);
            return "person/otherapi";
        } else {
            Person person = personService.searchPerson(name);
            if (person != null && person.getPersonId()!=null){
                model.addAttribute("person", person);
            } else {
                String url = "https://api.agify.io/?name=" + name;
                RestTemplate restTemplate = new RestTemplate();
                ApiModel response = restTemplate.getForObject(url, ApiModel.class);
                person.setPersonName(response.getName());
                person.setAge(response.getAge());
                model.addAttribute("person", person);
            }
        }
        return "person/otherapi";
    }
}

package ru.gotoqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gotoqa.model.Person;
import ru.gotoqa.service.PersonService;

/**
 * @author Muflikhunov Roman
 */

@Controller
public class PersonController {
    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "persons", method = RequestMethod.GET)
    public String listPersons(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());

        return "persons";
    }

    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person){
        if(person.getId() == 0){
            this.personService.addPerson(person);
        }else {
            this.personService.updatePerson(person);
        }

        return "redirect:/persons";
    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);

        return "redirect:/persons";
    }

    @RequestMapping("edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());

        return "persons";
    }

    @RequestMapping("personInfo/{id}")
    public String personInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));

        return "personInfo";
    }
}

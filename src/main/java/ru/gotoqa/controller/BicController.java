package ru.gotoqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gotoqa.model.Bic;
import ru.gotoqa.service.BicService;

/**
 * @author Muflikhunov Roman
 */

@Controller
public class BicController {
    private BicService bicService;

    @Autowired(required = true)
    @Qualifier(value = "bicService")
    public void setBicService(BicService bicService) {
        this.bicService = bicService;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String listTest(Model model){
        model.addAttribute("bic", new Bic());
        model.addAttribute("listBics", this.bicService.listBics());
        return "test";
    }

    @RequestMapping(value = "bics", method = RequestMethod.GET)
    public String listBic(Model model){
        model.addAttribute("bic", new Bic());
        model.addAttribute("listBics", this.bicService.listBics());

        return "bics";
    }

    @RequestMapping(value = "/bics/add", method = RequestMethod.POST)
    public String addBic(@ModelAttribute("bic") Bic bic){
        if(bic.getId() == 0){
            this.bicService.addBic(bic);
        }else {
            this.bicService.updateBic(bic);
        }

        return "redirect:/bics";
    }

    @RequestMapping("/remove/{id}")
    public String removeBic(@PathVariable("id") int id){
        this.bicService.removeBic(id);

        return "redirect:/bics";
    }

    @RequestMapping("edit/{id}")
    public String editBic(@PathVariable("id") int id, Model model){
        model.addAttribute("bic", this.bicService.getBicById(id));
        model.addAttribute("listBics", this.bicService.listBics());

        return "bics";
    }

    @RequestMapping("bicInfo/{id}")
    public String personInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("bic", this.bicService.getBicById(id));

        return "bicInfo";
    }
}

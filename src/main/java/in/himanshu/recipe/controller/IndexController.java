package in.himanshu.recipe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @RequestMapping({"","/","/index"})
    public String indexPage(Model theModel){

        theModel.addAttribute("coach",coachName);
        theModel.addAttribute("team",teamName);
        return "index";
    }

}

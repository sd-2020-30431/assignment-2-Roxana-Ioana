package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import wasteless.service.*;

@Controller
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @RequestMapping(value = "/goal", method = RequestMethod.GET)
    public String goal(@RequestParam(value = "idUser") int idUser, Model model) {

        int nbOfCalories = goalService.caloriesToday(idUser);

        int goal = goalService.getGoal(idUser);
        boolean isWaste = nbOfCalories > goal;
        String message = "";

        if(isWaste)
        {
            message = "YES";
        }else
        {
            message = "NO";
        }

        model.addAttribute("caloriesToday", nbOfCalories);
        model.addAttribute("goal", goal);
        model.addAttribute("waste", message);
        model.addAttribute("idUser", idUser);

        return "goals";
    }

    @RequestMapping(value = "/goal", method = RequestMethod.POST)
    public String createGoal(@RequestParam(value = "goall") int goall, @RequestParam(value = "idUser") int idUser, RedirectAttributes redirectAttrs) {
        goalService.createGoal(idUser, goall);
        redirectAttrs.addAttribute("idUser", idUser);

        return "redirect:/goal";
    }
}

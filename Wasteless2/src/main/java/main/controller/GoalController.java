package main.controller;

import main.dto.*;
import main.mapper.*;
import main.model.*;
import main.service.*;
import main.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/goal")
public class GoalController {

    private final GoalService goalService;
    private GoalMapper goalMapper;
    private GoalValidator goalValidator;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
        this.goalMapper = new GoalMapper();
        this.goalValidator = new GoalValidator();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createGoal(@RequestBody GoalDTO goalDTO) {
        try {
            goalValidator.validate(goalDTO);
            goalService.createGoal(goalMapper.convert(goalDTO));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getGoal(@PathVariable("idUser") int idUser) {
        Goal goal = goalService.getGoal(idUser);
        return new ResponseEntity<>(goal.getDailyCalories(), HttpStatus.OK);
    }

    @RequestMapping(value = "/dailyCalories/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getDailyCalories(@PathVariable("idUser") int idUser) {
        int calories = goalService.getNecessaryDailyCalories(idUser);
        return new ResponseEntity<>(calories, HttpStatus.OK);
    }
}

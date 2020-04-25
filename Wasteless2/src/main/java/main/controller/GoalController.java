package main.controller;

import main.dto.*;
import main.mapper.*;
import main.model.*;
import main.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/goal")
public class GoalController {

    private final GoalService goalService;
    private GoalMapper goalMapper;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
        this.goalMapper = new GoalMapper();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createGoal(@RequestBody GoalDTO goalDTO) {
        goalService.createGoal(goalMapper.convert(goalDTO));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/{idUser}",method = RequestMethod.GET)
    public ResponseEntity<GoalDTO> getGoal(@PathVariable("idUser") int idUser) {
        Goal goal = goalService.getGoal(idUser);
        return new ResponseEntity<>(goalMapper.convertToDTO(goal), HttpStatus.OK);
    }
}

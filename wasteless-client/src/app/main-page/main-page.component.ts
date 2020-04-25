import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { GoalService } from '../goal.service';
import { Goal } from '../login/goal';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  idUser: number;
  weeklyType: string = "WEEKLY";
  monthlyType: string = "MONTHLY";
  goal: Goal = new Goal();
  currentGoal: Observable<number>;
  calories:Observable<number>;

  constructor(private route:ActivatedRoute,private router: Router, private goalService:GoalService) { }

  ngOnInit(): void {
    this.idUser = this.route.snapshot.params['idUser'];
    this.reLoad();
  }

    getWeeklyReport()
    {
      this.router.navigate(['report', this.idUser, this.weeklyType]);
    }

    getMonthlyReport()
    {
      this.router.navigate(['report', this.idUser, this.monthlyType]);
    }

    manageGroceryLists()
    {
      this.router.navigate(['grocery-lists', this.idUser]);
    }

    onSubmitGoal()
    {
      this.goal.idUser=this.idUser;
      this.goalService.createGoal(this.goal).subscribe(data=>{console.log(data)
                                                              this.reLoad()});
    }

    reLoad()
    {
        this.currentGoal = this.goalService.getGoal(this.idUser);
        this.calories = this.goalService.getDailyCalories(this.idUser);
    }
}

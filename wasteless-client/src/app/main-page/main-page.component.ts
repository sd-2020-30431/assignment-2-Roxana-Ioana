import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { GoalService } from '../goal.service';
import { Goal } from '../login/goal';
import { Observable } from 'rxjs';
import { SubjectHandler } from '../subject-handler';
import { ObserverHandler } from '../observer-handler';
import { GroceryItemsService } from '../grocery-items.service';
import { GroceryItem } from '../grocery-items/item';

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
  observer: ObserverHandler;
  subject: SubjectHandler;
  groceryItems: GroceryItem[];

  constructor(private route:ActivatedRoute,private router: Router, private goalService:GoalService, private groceryItemsService:GroceryItemsService) { }

  ngOnInit(): void {
    
    this.subject = new SubjectHandler();
    this.observer = new ObserverHandler(this.subject);

    this.idUser = this.route.snapshot.params['idUser'];

    this.groceryItemsService.getGroceryItemsWhichExpire(this.idUser).subscribe(data=>{this.groceryItems=data;
    this.subject.setGroceryItemsWhichExpire(this.groceryItems);
   });  

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

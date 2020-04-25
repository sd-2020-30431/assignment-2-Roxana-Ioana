import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  idUser: number;
  weeklyType: string = "WEEKLY";
  monthlyType: string = "MONTHLY";

  constructor(private route:ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.idUser = this.route.snapshot.params['idUser'];
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
}

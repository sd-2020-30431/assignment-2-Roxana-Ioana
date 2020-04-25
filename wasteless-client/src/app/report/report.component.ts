import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReportService } from '../report.service';
import { Report } from './report';
import { Observable } from 'rxjs';
import { GroceryItem } from '../grocery-items/item';
import { of } from 'rxjs';
import {Location} from '@angular/common';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  type: string;
  idUser:number;
  wastedItems: Observable<GroceryItem[]>;
  purchasedItems: Observable<GroceryItem[]>;
  report: Report;

  constructor(private reportService: ReportService,
    private router: Router, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.idUser = this.route.snapshot.params['idUser'];
    this.type = this.route.snapshot.params['type'];
    this.reportService.getReport(this.idUser, this.type).subscribe(data=>{this.report=data;
                                                                          this.purchasedItems = of(this.report.groceryItems);
                                                                          this.wastedItems = of(this.report.wastedGroceryItems);
                                                                          });
                                                                         

  }

  turnBack()
  {
    this.location.back();
  }
}

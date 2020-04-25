import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { GroceryListService } from '../grocery-list.service';
import { GroceryList } from '../grocery-list';
import { Observable } from "rxjs";

@Component({
  selector: 'app-view-all-lists',
  templateUrl: './view-all-lists.component.html',
  styleUrls: ['./view-all-lists.component.css']
})
export class ViewAllListsComponent implements OnInit {

  list:GroceryList=new GroceryList();
  idUser:number;
  groceryLists: Observable<GroceryList[]>;

  constructor(private route: ActivatedRoute, private router:Router, private groceryListService:GroceryListService) { }

  ngOnInit(): void {
    this.idUser = this.route.snapshot.params['idUser'];
    this.reloadData();
  }

  createList(){
    //this.list.IdUser=+this.route.snapshot.paramMap.get('idUser');
    this.list.idUser = this.route.snapshot.params['idUser'];
    this.groceryListService.createGroceryList(this.list).subscribe(data=>{console.log(data);
                                                                          this.reloadData();});
  }

  onSubmit() {
    this.createList();    
  }

  reloadData() {
    this.groceryLists = this.groceryListService.getAllGroceryLists(this.idUser);
  }

  deleteGroceryList(id:number)
  {
    console.log(id);
    this.groceryListService.deleteGroceryList(id)
    .subscribe(
      data => {
        this.reloadData();
      },
      error => console.log(error));
  }

  updateGroceryList(id: number){
    this.router.navigate(['grocery-items', id]);
  }

}

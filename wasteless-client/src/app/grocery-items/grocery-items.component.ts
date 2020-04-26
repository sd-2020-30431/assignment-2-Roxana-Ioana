import { Component, OnInit } from '@angular/core';
import { GroceryItem } from './item';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { GroceryItemsService } from '../grocery-items.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-grocery-items',
  templateUrl: './grocery-items.component.html',
  styleUrls: ['./grocery-items.component.css']
})
export class GroceryItemsComponent implements OnInit {

  item: GroceryItem = new GroceryItem();
  idList:number;
  groceryItemsList:Observable<GroceryItem[]>;
  isUpdate:boolean;

  constructor(private groceryItemsService: GroceryItemsService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.idList = this.route.snapshot.params['idList'];
    this.reloadData();
  }

  reloadData() {
    this.groceryItemsList = this.groceryItemsService.getAllGroceryItems(this.idList);
  }

  addItem()
  {
    this.item.idList = this.idList;
    this.groceryItemsService.addGroceryItem(this.item).subscribe(data=>{console.log(data); this.reloadData()});
  }

  onSubmit()
  {
    if(this.isUpdate)
    {
      this.finalizeUpdate(this.item);
      this.isUpdate = false;
      window.location.reload();
    }
    else
    {
      this.addItem();
    }
  }

  donate(idItem:number)
  {
    this.groceryItemsService.deleteGroceryItem(idItem).subscribe( data => {
                                                                    this.reloadData();
                                                                  },
                                                                  error => console.log(error));
  }

  finalizeUpdate(item:GroceryItem)
  {
    this.groceryItemsService.updateGroceryItem(item).subscribe( data => {
      this.reloadData();
    },
    error => console.log(error));
  }

  update(item:GroceryItem)
  {
    this.item = item;
    this.isUpdate=true;
  }
  
}

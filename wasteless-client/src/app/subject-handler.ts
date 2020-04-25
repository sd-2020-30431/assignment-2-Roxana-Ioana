import { Observer } from './observer';
import { GroceryItem } from './grocery-items/item';
import { Subject } from './subject';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SubjectHandler implements Subject{

    private observers: Observer[] = [];
    private groceryItems: GroceryItem[];

    registerObserver(o: Observer) {
        this.observers.push(o);
    }

    removeObserver(o: Observer) {
        let index = this.observers.indexOf(o);
        this.observers.splice(index, 1);
    }

    notifyObservers() {
        for (let observer of this.observers) {
            observer.update(this.groceryItems);
        }
    }

    setGroceryItemsWhichExpire(groceryItems: GroceryItem[]) {
        this.groceryItems = groceryItems;
        this.notifyObservers();
    }
}
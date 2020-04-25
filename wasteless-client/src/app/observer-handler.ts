import { Observer } from './observer';
import { Subject } from './subject';
import { GroceryItem } from './grocery-items/item';

export class ObserverHandler implements Observer{

    constructor(private subject:Subject){
        subject.registerObserver(this);
    }

    update(groceryItems:GroceryItem[]) {
        if(groceryItems.length>0)
        {
            console.log("This items will expire in the next 5 days");
            console.log(groceryItems);
        }
        else
        {
            console.log("Nothing expires soon");
        }
    }
}
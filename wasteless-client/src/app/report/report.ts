import { GroceryItem } from '../grocery-items/item';

export class Report{

    nbOfGroceryItems:number;
    groceryItems: GroceryItem[];
    nbOfEatenCalories:number;
    nbOfWastedCalories:number;
    wastedGroceryItems:GroceryItem[];
}

import { GroceryItem } from './grocery-items/item';

export interface Observer{
    update(groceryItems:GroceryItem[]);
}
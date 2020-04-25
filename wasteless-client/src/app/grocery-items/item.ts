export class GroceryItem{

    idItem:number;
    idList:number;
    name: string;
    quantity:number;
    calories:number;
    purchaseDate:Date;
    expirationDate:Date;
    consumptionDate:Date;

    toString(): string {
        return this.name + ' ' + this.calories;
    }
}
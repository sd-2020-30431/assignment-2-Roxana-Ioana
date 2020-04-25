export class GroceryList{

    idList:number;
    idUser: number;
    name:string;

    /*constructor(name: string) {
        this.name = name;
    }
    */

    set IdUser(idUser:number)
    {
        this.IdUser = idUser;
    }
}
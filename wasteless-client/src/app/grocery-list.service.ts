import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroceryListService {

  private baseUrl = 'http://localhost:8080/grocery-lists';

  constructor(private http: HttpClient) { }

  createGroceryList(groceryList:Object):Observable<Object>{
    return this.http.post(`${this.baseUrl}`, groceryList);
  }

  deleteGroceryList(idList:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/${idList}`);
  }

  getAllGroceryLists(idUser:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/${idUser}`);
  }

}

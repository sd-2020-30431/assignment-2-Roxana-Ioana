import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroceryItemsService {

  private baseUrl = 'http://localhost:8080/grocery-items';

  constructor(private http: HttpClient) { }

  addGroceryItem(groceryItem:Object):Observable<Object>{
    return this.http.post(`${this.baseUrl}`, groceryItem);
  }

  deleteGroceryItem(idList:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/${idList}`);
  }

  getAllGroceryItems(idList:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/${idList}`);
  }

  getGroceryItemsWhichExpire(idUser:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/to-expire/${idUser}`);
  }

  updateGroceryItem(groceryItem:Object):Observable<any>{
    return this.http.put(`${this.baseUrl}`, groceryItem);
  }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {FormControl} from '@angular/forms'
import {User} from './login/user'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = 'http://localhost:8080/authenticate';
  
  constructor(private http: HttpClient) { }

  findUser(user:Object):Observable<any>{
    return this.http.post(`${this.baseUrl}`, user);
  }
}

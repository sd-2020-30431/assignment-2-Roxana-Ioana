import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login.service'
import { Router, ActivatedRoute } from '@angular/router';
import { User } from './user';
import { FormsModule } from '@angular/forms';
import { SubjectHandler } from '../subject-handler';
import { GroceryItem } from '../grocery-items/item';
import { GroceryItemsComponent } from '../grocery-items/grocery-items.component';
import { GroceryItemsService } from '../grocery-items.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  groceryItems:GroceryItem[];
  user: User=new User();
  userId:number;
  submitted = false;

  constructor(private loginService: LoginService,
    private router: Router) { }

  ngOnInit(): void {

  }

  findUser()
  {
     this.loginService.findUser(this.user)
      .subscribe(data=>{this.userId = data,
                        this.goToNextPage(data);
                        },
                 error=>{console.log("Fail to log in")});

    this.user = new User();
  }

  onSubmit() {
    this.submitted = true;
    this.findUser();    
  }

  goToNextPage(idUser:Object) {
    this.router.navigate(['/main-page', idUser]);
  }

}

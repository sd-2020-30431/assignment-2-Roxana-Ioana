import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login.service'
import { Router, ActivatedRoute } from '@angular/router';
import { User } from './user';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  data1:User;
  user: User=new User();
  submitted = false;

  constructor(private loginService: LoginService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  findUser()
  {
     this.loginService.findUser(this.user)
      .subscribe(data=>{console.log(data),
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

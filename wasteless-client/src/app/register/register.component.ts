import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../login/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
 
  user:User = new User();

  constructor(private loginService: LoginService,
    private router: Router) { }

  ngOnInit(): void {
  }

  createUser()
  {
     this.loginService.createUser(this.user)
      .subscribe(data=>{console.log(data);
                        this.goToNextPage(data);
                        },
                 error=>{console.log("Fail to register")});
  }

  onSubmit() {
    this.createUser();    
  }

  goToNextPage(idUser:Object) {
    this.router.navigate(['/login']);
  }

}

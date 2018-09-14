import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from './../model/userModel';
import { Router, ActivatedRoute } from '@angular/router'; 
@Injectable()

export class AuthenticationService {
  loginURL = 'http://localhost:3000/login';
  //regURL ='http://localhost:3000/registration';
  constructor(private http: HttpClient,    private route: ActivatedRoute,
    private router: Router) {
  }

  login(user: User=null): Promise<any> {
    // tslint:disable-next-line:prefer-const  
    // let user_1 = user ? user : new User("", ""),
    let promise = new Promise((resolve, reject) => {
      this.http.post<User>(this.loginURL,user)
      .subscribe(data => {
        resolve(data);
        console.log("auth service"+data);
        this.router.navigate(['/snapshop']),
        localStorage.setItem('currentUser',JSON.stringify(data));
      },
      error => {
        this.router.navigate(['/']),
        reject(error);
      });
    });
    return promise;
  }

  logout(){
    localStorage.removeItem('currentUser');
  }

  getUsers(){
    let promise = new Promise((resolve, reject) => {
      this.http.get<Array<User>>(this.loginURL)
      .subscribe(data => {
        resolve(data);
        console.log("all users:"+data);
      },
      error => {
        this.router.navigate(['/']),
        reject(error);
      });
    });
    return promise;
  }

}



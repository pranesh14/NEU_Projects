import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Reg } from './../model/regModel';
import { Router, ActivatedRoute } from '@angular/router'; 
@Injectable()

export class RegistrationService {
 // loginURL = 'http://localhost:3000/login';
  regURL ='http://localhost:3000/registration';
  constructor(private http: HttpClient,    private route: ActivatedRoute,
    private router: Router) {
  }
  register(reg: Reg=null): Promise<any> {
    // tslint:disable-next-line:prefer-const  
    // let user_1 = user ? user : new User("", ""),
    console.log(reg);
    let promise = new Promise((resolve, reject) => {
      this.http.post<Reg>(this.regURL,reg)
      .subscribe(data => {
        resolve(data);
        console.log(data);
        alert("User Created");
      },
      error => {
        this.router.navigate(['/']),
        reject(error);
      });
    });
    return promise;
  }

}



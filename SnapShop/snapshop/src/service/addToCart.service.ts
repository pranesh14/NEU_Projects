import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Product } from './../model/addToCart';
@Injectable()

export class addToCartService {
  scanURL = 'http://localhost:3000/cart';
  constructor(private http: HttpClient) {
  }
addToCart(product: Product): Promise<any> {
    console.log("angular service");
    // tslint:disable-next-line:prefer-const  
    let promise = new Promise((resolve, reject) => {
      this.http
      .post<Array<Product>>(this.scanURL,product)
      .subscribe(data => {
        resolve(data);
        console.log("service:"+data);
      },
      error => {
        reject(error);
        alert("Error while adding product");
      });
    });
    return promise;
  }
}

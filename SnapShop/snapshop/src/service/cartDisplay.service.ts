import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Product, SearchProduct, SearchProductByName } from './../model/productScannerModel';
import { Cart } from '../model/cartModel';
@Injectable()

export class cartDisplayService {
  searchURL = 'http://localhost:3000/cart';
//   sp: SearchProduct;

  constructor(private http: HttpClient) {
  }

  cartDisplay(search:String): Promise<any> {
    // tslint:disable-next-line:prefer-const  
    // let sp = new SearchProductByName(search);
    // console.log("A "+search)
    let promise = new Promise((resolve, reject) => {
      this.http
      .get<Array<Cart>>(this.searchURL)
      .subscribe(data => {
        resolve(data);
        console.log("fr "+JSON.stringify(data))
      },
      error => {
        alert("No results found!");
      });
    });
    return promise;
  }

//   remove(cartItem: Product): Promise<any>{
//     let promise = new Promise((resolve, reject) => {
//       this.http
//       .post(this.searchURL,cartItem)
//       .subscribe(data => {
//         resolve(data);
//         console.log("fr "+JSON.stringify(data))
//       },
//       error => {
//         alert("No results found!");
//       });
//     });
//     console.log("AB"+JSON.stringify(promise));
//     return promise;
//   }
}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Product, SearchProduct } from './../model/productScannerModel';
@Injectable()

export class scanProductService {
  scanURL = 'http://localhost:3000/scanProduct';
  constructor(private http: HttpClient) {
  }
  scanProduct(product: Product): Promise<any> {
    // tslint:disable-next-line:prefer-const  
    console.log(product)
    let promise = new Promise((resolve, reject) => {
      this.http
      .post<Product>(this.scanURL,product)
      .subscribe(data => {
        resolve(data);
        console.log("fr "+JSON.stringify(data))
      },
      error => {
        alert("No results found!");
      });
    });
    console.log("A"+JSON.stringify(promise));
    return promise;
  }
}

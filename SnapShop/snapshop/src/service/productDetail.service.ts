import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { ProductDetail } from './../model/productDetailModel';
@Injectable()

export class ProductDetailService {
  productDetailURL = 'http://localhost:3000/productdetail';
  constructor(private http: HttpClient) {
  }
  getProduct(productId:String): Promise<any> {
    // tslint:disable-next-line:prefer-const  
    let promise = new Promise((resolve, reject) => {
      this.http
      .get<ProductDetail>(this.productDetailURL+"/"+productId)
      .subscribe(data => {
        resolve(data);
      },
      error => {
        reject(error);
      });
    });
    return promise;
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Product, SearchProduct, SearchProductByName } from './../model/productScannerModel';
import { ProductDetail } from './../model/productDetailModel';
import { ProductDetailService } from './productDetail.service';
import { Router } from '@angular/router';
@Injectable()

export class searchProductService {
  searchURL = 'http://localhost:3000/searchProduct';
  sp: SearchProduct;
  product:ProductDetail;
  constructor(private http: HttpClient,private pservice:ProductDetailService,private router:Router) {
  }
  searchProduct(search:String): Promise<any> {
    // tslint:disable-next-line:prefer-const  
    let sp = new SearchProductByName(search);
   // console.log("A "+search)
    let promise = new Promise((resolve, reject) => {
      this.http
      .post<Array<Product>>(this.searchURL,sp)
      .subscribe(data => {
        resolve(data);
       // console.log("fr "+JSON.stringify(data))
      },
      error => {
        alert("No results found!");
      });
    });
   // console.log("A"+JSON.stringify(promise));
    return promise;
  }

  navigate(product){
    console.log("search Prod Service"+product._id);
   this.pservice.getProduct(product._id);
   localStorage.removeItem('ProductId');
   localStorage.setItem('ProductId',product._id);
   this.router.navigate(['/productDetail']);
  }
}

import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { FormControl, FormArray, FormBuilder, FormGroup } from '@angular/forms';
import 'rxjs/add/operator/finally';
import { ProductDetail } from '../../model/productDetailModel';
import { Product } from '../../model/productScannerModel';
import { ProductDetailService } from '../../service/productDetail.service';
import { addToCartService } from '../../service/addToCart.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-productview',
  templateUrl: './productview.component.html',
  styleUrls: ['./productview.component.scss'],
  providers: [ProductDetailService, addToCartService]
})
export class ProductviewComponent implements OnInit {

  productDetail: String;
  productAdd: Product;
  name = "";
  description = "";
  url = "";
  price = 0.0;
  inventorycount = 0;
  rating = 0;
  quantity;

  constructor(private productDetailService: ProductDetailService, private _location: Location, private addToCart: addToCartService) { 
    this.productDetailService=productDetailService; 
  }

  ngOnInit() {
    this.productDetailService.getProduct(localStorage.getItem("ProductId")).then(
     // console.log("vfvaf");
      data =>{
        var productDetails=JSON.parse(JSON.stringify(data));
        this.description = productDetails.description;
        this.name = productDetails.name;
        this.url = productDetails.imageurl;
        this.price = productDetails.price;
        this.inventorycount = productDetails.inventorycount;
        this.rating = productDetails.rating;
      }
    );
  }

  goBack(){
    this._location.back();
  }

  onSelectQty(qty){
    this.quantity = qty;
  }

  addtocart(){
    if(isNaN(this.quantity) || this.quantity==0) {
      alert("Please select quantity");
    }
    else{
    this.productAdd = this.prepareAddToCart();
    alert("Product added successfully");
    this.addToCart.addToCart(this.productAdd).then(
      product => { 
        alert("Product added successfully");
        }
      );
    }
  }

  prepareAddToCart(): Product {
    const product: Product = {
      id: '',
      name: this.name as string,
      description: '',
      price: this.price as number,
      quantity: this.quantity as number,
      image: this.url as string
    };
    return product;
  }

    getStars(rating: number){
    var val = rating;
    var size = val/5*100;
    return size + '%';
  }

}
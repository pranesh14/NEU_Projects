import { Component, OnInit, Input } from '@angular/core';
import { searchProductService } from '../../service/searchProduct.service';
import 'rxjs/add/operator/finally';
import { Product } from '../../model/productScannerModel';
import { products } from '../../model/addToCart';
import { ProductDetail } from '../../model/productDetailModel';
import { ProductDetailService } from '../../service/productDetail.service'


@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss'],
  providers: [searchProductService,ProductDetailService]
})

export class SearchPageComponent implements OnInit {
  
  @Input() products:ProductDetail[];
  selectedProduct:ProductDetail;
  selectedItem :ProductDetail;
  search : string;
  searchFound: boolean;

  constructor(private searchService: searchProductService) {
    this.searchService = searchService;
   }

  ngOnInit() {
    this.onSearch();
  }

  onSearch(){
    this.search = (<HTMLInputElement>document.getElementById("searchProduct")).value;
    // console.log(this.search);
    this.searchFound = false;
    this.searchService.searchProduct(this.search).then( /*product assignment*/ 
      product => 
      {
        this.products = (product);
        console.log("A"+JSON.stringify(product));
        this.searchFound = true;
      }
    );
  }

  nav(sproduct: ProductDetail){
    this.selectedProduct=sproduct;
    console.log(this.selectedProduct);
    this.searchService.navigate(this.selectedProduct);
  }



  onSort(){
  //  this.ngOnChanges();
  if((<HTMLInputElement>document.getElementById("sort")).value=="Name | A-Z"){
    this.nameAsc();
  }else if((<HTMLInputElement>document.getElementById("sort")).value=="Name | Z-A"){
    this.nameDesc();
  }else if((<HTMLInputElement>document.getElementById("sort")).value=="Price | High - Low"){
    this.priceDesc();
  }
  else if((<HTMLInputElement>document.getElementById("sort")).value=="Rating | High - Low"){
    this.ratingAsc();
  }
  else if((<HTMLInputElement>document.getElementById("sort")).value=="Rating | Low - High"){
    this.ratingDesc();
  }
  else {
    this.priceAsc();
  }
  }

  nameAsc(){
    this.products.sort(function(a:ProductDetail,b:ProductDetail){
      if(a.name < b.name){
        return -1;
      }
      if(a.name > b.name){
        return 1;
      }
      return 0;
    });
  }

  nameDesc(){
    this.products.sort(function(a:ProductDetail,b:ProductDetail){
      if(a.name > b.name){
        return -1;
      }
      if(a.name < b.name){
        return 1;
      }
      return 0;
    });
  }

  priceDesc(){
    this.products.sort(function(a:ProductDetail,b:ProductDetail){
      if(a.price > b.price){
        return -1;
      }
      if(a.price < b.price){
        return 1;
      }
      return 0;
    });
  }

  priceAsc(){
    this.products.sort(function(a:ProductDetail,b:ProductDetail){
      if(a.price < b.price){
        return -1;
      }
      if(a.price > b.price){
        return 1;
      }
      return 0;
    });
  }

  ratingDesc(){
    this.products.sort(function(a:ProductDetail,b:ProductDetail){
      if(a.rating > b.rating){
        return -1;
      }
      if(a.price < b.price){
        return 1;
      }
      return 0;
    });
  }

  ratingAsc(){
    this.products.sort(function(a:ProductDetail,b:ProductDetail){
      if(a.rating < b.rating){
        return -1;
      }
      if(a.price > b.price){
        return 1;
      }
      return 0;
    });
  }

}
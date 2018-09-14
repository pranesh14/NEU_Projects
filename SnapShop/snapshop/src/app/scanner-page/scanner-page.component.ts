import { Component, OnInit, OnChanges, Input } from '@angular/core';
import { FormControl, FormArray, FormBuilder, FormGroup } from '@angular/forms';

import 'rxjs/add/operator/finally';
import { Product, SearchProduct } from '../../model/productScannerModel';
import { scanProductService } from '../../service/scanProduct.service';
import { addToCartService } from '../../service/addToCart.service';


@Component({
  selector: 'app-scanner-page',
  templateUrl: './scanner-page.component.html',
  styleUrls: ['./scanner-page.component.scss'],
  providers: [scanProductService,addToCartService]
  
})
export class ScannerPageComponent implements OnInit, OnChanges {
  
  @Input() product: Product;
  @Input() productAdd: Product;
  // product: Product;
  id = new FormControl();
  name = new FormControl();
  price= new FormControl();
  quantity=new FormControl();  
  image=new FormControl();  
  addToCartForm: FormGroup;
  search1 = false;
  noresult : boolean;
  scanProductForm: FormGroup;
  searchResultForm: FormGroup;

  constructor( private formbuilder: FormBuilder, private scanService: scanProductService,private addToCart: addToCartService) {
    this.scanService=scanService;
    this.addToCart=addToCart;    
    this.createForm();
  }

  ngOnChanges() {
    if(!(this.search1)){
      console.log(this.search1)
      alert("No results found");
    }
  }

  ngOnInit() {
  }
  onSelectQty(qty){
    console.log("A"+qty);
    this.product.quantity=qty;
    this.addToCartForm.reset({
      id: this.product.id,
      name: this.product.name,
      description: this.product.description,
      price: this.product.price,
      quantity: this.product.quantity,
      image: this.product.image });

  
  }
  createForm() {
    // throw new Error("Method not implemented.");

    this.scanProductForm = this.formbuilder.group({
      search: ''
    });

    this.searchResultForm = this.formbuilder.group({
      id: '',
      name: '',
      description: '',
      price: '',
      quantity: '',
      image: ''
    });
    this.addToCartForm = this.formbuilder.group({
      id: '',
      name: '',
      description: '',
      price: '',
      quantity: '',
      image: ''
    });

  }

  onSearch(){
    this.search1=false;
    this.product = this.prepareSearchProduct();
    this.scanService.scanProduct(this.product).then( /*product assignment*/ 
      product => 
      {
        this.product = (product[0]);
        console.log("A"+JSON.stringify(product[0]));
        this.search1 = true;
        this.noresult = false;
        console.log(this.search1) 

        this.addToCartForm.reset({
          id: this.product.id,
          name: this.product.name,
          description: this.product.description,
          price: this.product.price,
          quantity: this.product.quantity,
          image: this.product.image });
    
      }
      
    );
    this.search1=false;
  }
  onAddToCart()
  {
    if(isNaN(this.product.quantity)) {
      alert("Please select quantity");
    }
    else{
    this.productAdd = this.prepareAddToCart();
    this.addToCart.addToCart(this.productAdd).then( /*product assignment*/ product => { 
      alert("Product added successfully");
      
    });}
    // this.ngOnChanges();
    // if(!this.search){
    //   alert("No results found");
    // }

    
  }
  prepareAddToCart(): Product {
    const formModel = this.addToCartForm.value;
    // return new `Hero` object containing a combination of original hero value(s)
    // and deep copies of changed form model values
    const product: Product = {
      id: '',
      name: formModel.name as string,
      description: '',
      price: formModel.price as number,
      quantity: formModel.quantity as number,
      image: formModel.image as string
    };
    return product;
  }
  prepareSearchProduct(): Product {
    const formModel = this.scanProductForm.value;
    // return new `Hero` object containing a combination of original hero value(s)
    // and deep copies of changed form model values
    const product: Product = {
      id: formModel.search as string,
      name: '',
      description: '',
      price: 0,
      quantity: 0,
      image: ''
    };
    return product;
  }
}

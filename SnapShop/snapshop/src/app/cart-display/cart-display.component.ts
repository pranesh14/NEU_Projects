import { Component, OnInit, Input } from '@angular/core';
import { Cart } from '../../model/cartModel';
import { cartDisplayService } from '../../service/cartDisplay.service';
import { removeFromCartService } from '../../service/removeFromCart.service';
import { Product, products } from '../../model/addToCart';

@Component({
  selector: 'app-cart-display',
  templateUrl: './cart-display.component.html',
  styleUrls: ['./cart-display.component.scss'],
  providers:[cartDisplayService,removeFromCartService]
})
export class CartDisplayComponent implements OnInit {

  @Input() cartItems : Cart[]
  selectedCartItem: Cart;
  selectedItem: Product;
  flag = false;
  
  constructor(private cartDisplayService: cartDisplayService,private removeFromCartService: removeFromCartService) { }

  ngOnInit() {
    let search:String = "";
    // console.log(this.search);
    // let searchFound = false;
    this.cartDisplayService.cartDisplay(search).then( /*product assignment*/ 
      product => 
      {
        this.cartItems = (product);
        console.log(this.cartItems);
        // searchFound = true;
      }
    );
    if(this.cartItems == null)
      this.flag = true;
    console.log(this.flag);
  }

  isValidForm() {
    return this.flag;
  }

  remove(cartItem: Product){
    this.selectedItem = cartItem;
    this.removeFromCartService.remove(this.selectedItem).then();
    window.location.reload();
    alert("Product has been removed from cart successfully");
  }
  

}

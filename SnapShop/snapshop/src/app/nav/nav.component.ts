import { Component, OnInit ,Input} from '@angular/core';
import { Router } from '@angular/router';
import { PaymentService } from '../../service/payment.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss'],
  providers: [PaymentService]
})
export class NavComponent implements OnInit {

// @Input a:String;
user="";
  constructor(private router: Router, private paymentService: PaymentService) {
    //let a= JSON.parse(localStorage.currentUser)[0].username;
   }

  ngOnInit() {
    this.user= JSON.parse(localStorage.currentUser)[0].username; 
  }

  logout(){
    this.paymentService.deleteCart().then(
      data =>{
        console.log(JSON.parse(JSON.stringify(data)));
      }
    );
    localStorage.clear();
    this.router.navigate(['/']);
  }

}

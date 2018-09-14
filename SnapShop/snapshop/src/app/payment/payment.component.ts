import { Component, OnInit, OnChanges } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { FormControl, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import 'rxjs/add/operator/finally';
import { PaymentService } from '../../service/payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss'],
  providers: [PaymentService]
})
export class PaymentComponent implements OnInit, OnChanges {

  paid = false;
  paymentForm: FormGroup;
  amount = 0.0;
  cnumber = "";

  constructor(private fb: FormBuilder,private paymentService: PaymentService) { 
    this.createForm();
    this.paymentService=paymentService; 
  }

  ngOnInit() {
    this.paymentService.payment().then(
      data =>{
        var cartDetails=JSON.parse(JSON.stringify(data));
        var obj = 0.0;
        for(var i = 0; i < cartDetails.length; i++) {
          obj += cartDetails[i].price*cartDetails[i].quantity;
        }
        this.amount = obj;
      }
    );
  }

  createForm() {
    this.paymentForm = this.fb.group({
      cardNumber: ['', Validators.compose([Validators.required, Validators.pattern(/^\d{16}$/)])],
      cvv: ['', Validators.compose([Validators.required, Validators.pattern(/^\d{3,6}$/)])],
      mm: ['', Validators.compose([Validators.required, Validators.min(1), Validators.max(12)])],
      yyyy: ['', Validators.compose([Validators.required, Validators.min(2017), Validators.max(2050)])]
    });
  }

  onSubmit() {
    this.paid = true; 
    const formModel = this.paymentForm.value;
    this.cnumber = formModel.cardNumber.toString().substr(formModel.cardNumber.toString().length-4); 
    this.paymentService.deleteCart().then(
      data =>{
        console.log(JSON.parse(JSON.stringify(data)));
      }
    );
    this.ngOnChanges();
  }

  ngOnChanges() {
    this.paymentForm.reset({
      cardNumber: '',
      cvv: '',
      mm: '',
      yyyy: ''
    });
  }

}
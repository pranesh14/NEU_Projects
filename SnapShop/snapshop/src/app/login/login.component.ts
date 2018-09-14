import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { FormControl, FormArray, FormBuilder, FormGroup,Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router'; 
import 'rxjs/add/operator/finally';
import { User } from '../../model/userModel';
import { Reg } from '../../model/regModel';
import { AuthenticationService } from '../../service/authentication.service';
import { RegistrationService } from '../../service/register.service';

@Component({
  moduleId: module.id,
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [AuthenticationService,RegistrationService]
})

export class LoginComponent implements OnInit, OnChanges {

  @Input() user: User;
  @Input() reg:Reg;
  login = true;
  userForm: FormGroup;
  regForm: FormGroup;
  returnUrl: string;
  loading:false;
  users;
  notExists = false;
  count =0;
  notUser = false;
  notPassword = false;
  notUnique = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthenticationService,private regService:RegistrationService) 
{
      this.authService=authService;
      this.regService=regService;
      this.createForm();
  }

  ngOnChanges() {
    this.userForm.reset({
      username: "",
      password:""
    });
   
  }

  ngOnChangesReg() {
    this.regForm.reset({
      uname: "",
      pwd:"",
      fname:"",
      lname:"",
      phno:"",
      email:""
    });
   
  }

  onSubmit() {
    this.user = this.prepareSaveUser();
    for(var i in this.users){
      if(this.users[i].username == this.user.username && this.users[i].password == this.user.password){
       this.count++;
      }
    }
    if(this.count > 0){
         this.notExists=false;
    }
    else{
      this.notExists=true;
    }
    console.log(this.notExists);
    // console.log(this.user);
  if(!this.notExists){
      this.authService.login(this.user).then(
        data => console.log("returned promise:"+JSON.stringify(data))
        //this.router.navigate([this.returnUrl])
      );
    }
    this.ngOnChanges();
    this.notExists = true;
  }

  onSubmit2() {
    this.count=0;
    this.reg = this.prepareSaveReg();
    for(var i in this.users){
      if(this.users[i].username == this.reg.username){
        this.count++;
        
      }
    }
    if(this.count>0){
      this.notUnique=true;
    }
    console.log("Not Unique"+this.notUnique);
    
    
    if(!this.notUnique){
    this.regService.register(this.reg).then(
      data =>{ console.log("returned promise:"+JSON.stringify(data))
      //this.router.navigate([this.returnUrl])
      alert("User has been Registered");
    }
    );
    }
    else{
      this.notUnique =false;
    }
    this.ngOnChangesReg();
  }

  prepareSaveUser(): User {
    const formModel = this.userForm.value;
    console.log(formModel);
    // return new `Hero` object containing a combination of original hero value(s)
    // and deep copies of changed form model values
    const saveUser: User = {
      username: formModel.username as string,
      password: formModel.password as string
    };
    return saveUser;
  }
  prepareSaveReg(): Reg {
    const formModel = this.regForm.value;
    // return new `Hero` object containing a combination of original hero value(s)
    // and deep copies of changed form model values
    const saveReg: Reg = {
      username: formModel.uname as string,
      password: formModel.pwd as string,
      firstname :formModel.fname as string,
      lastname : formModel.lname as string,
      phonenumber : formModel.phno as string,
      email : formModel.email as string

    };
    return saveReg;
  }
  revert() { this.ngOnChanges(); }

  createForm() {
    this.userForm = this.fb.group({
      username: '',
      password: ''
    });

    this.regForm = this.fb.group({
      uname:  ['', Validators.compose([Validators.required, Validators.pattern(/^(?=(.*\d){2,})(?=(.*[a-zA-Z]){8,})[0-9a-zA-Z]{10,}/)])],
      fname: ['', Validators.compose([Validators.required, Validators.pattern(/[A-Za-z]{2,50}/)])],
      lname: ['', Validators.compose([Validators.required, Validators.pattern(/[A-Za-z]{2,50}/)])],
      pwd:  ['', Validators.compose([Validators.required, Validators.pattern(/^(?=(.*\d){3,})(?=.*[a-zA-Z])(?=(.*[A-Z]){1,})(?=(.*[!@#$_%]){1,})[0-9a-zA-Z!_@#$%]{8,}/)])],
      email: ['', Validators.compose([Validators.required, Validators.pattern(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)])],
      phno: ['', Validators.compose([Validators.required, Validators.pattern(/^[1-9]\d{9}$/)])]
    });
  }

  ngOnInit() {
    this.authService.logout();
    this.authService.getUsers().then(
      data => {
        this.users=JSON.parse(JSON.stringify(data));
        // console.log(this.users);
      }
    );    
           // get return url from route parameters or default to '/'
          //  this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  ifLogin() { this.login = true; console.log(this.login); }
  ifRegister() { this.login = false; console.log(this.login); }

}

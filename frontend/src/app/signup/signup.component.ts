import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  loginRef = new FormGroup({
    email:new FormControl(),
    password:new FormControl(),
    typesOfRole:new FormControl(),
    id:new FormControl(),
    companyName:new FormControl(),
    companyAddress:new FormControl(),
    registerNumber:new FormControl(),
    firstName:new FormControl(),
    lastName:new FormControl()
  });
  msg:string=""
  constructor(public ls:LoginService){}
  ngOnInit(): void {
    
  }
  signUp()
  {
    let login  =   this.loginRef.value;
    this.ls.signUp(login).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>this.msg=error,
      complete:()=>console.log("completed")
    });
  }

}

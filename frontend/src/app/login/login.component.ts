import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms'
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
loginRef= new FormGroup({
  email:new FormControl(),
  password:new FormControl(),
  typesOfRole:new FormControl()

});
msg:string=""
constructor(public ls:LoginService,public route:Router,public es:EmployeeService){}
ngOnInit(): void {
  
}
signIn()
{
    let login =  this.loginRef.value;
    
    this.ls.signIn(login).subscribe({
      next:(result:any)=>
      {
        
         if(result=="Admin Successfully Login")
         {
          
          this.ls.getUserById(login.email).subscribe({
          
            next:(result:any)=>  {
              console.log(result);
              this.es.getEmployeeByCompanyName(result).subscribe({
               next:(result:any)=> sessionStorage.setItem("EmployeeRecord",result),
               error:(error:any)=>console.log(error),
                complete:()=>console.log("complete")
              })
              sessionStorage.setItem("userById",result)},
            error:(error:any)=>console.log(error),
            complete:()=>console.log("complete")

          })
         
          sessionStorage.setItem("userDetails",login.email);
            this.route.navigate(["adminHome"]);
         }
         else if(result=="User LoginSuccessfully")
         {
          sessionStorage.setItem("userDetails",login.email);
          this.route.navigate(["userHome"])
         }
         else
         {
           this.ls.signInEmployee(login).subscribe({
            next:(result:any)=>{

              if(result=="Admin Successfully Login")
              {
              
               sessionStorage.setItem("userDetails",login.email);
                 this.route.navigate(["adminHome"]);
              }
              else if(result=="User LoginSuccessfully")
              {
                console.log(login.email)
                this.es.findEmployeeById(login.email).subscribe({
                  next:(result:any)=>{
                    
                  
                    this.ls.getUserByCompanyName(result).subscribe({
                     next:(result:any) =>sessionStorage.setItem("loginRecord",result),
                     error:(error:any)=>console.log(error),
                     complete:()=>console.log("complete")
                    })
                    console.log(result+"empid")
                    sessionStorage.setItem("empid",result)

                  
                  },
                  error:(error:any)=>console.log(error),
                  complete:()=>console.log("complete")
                 })
               
                sessionStorage.setItem("userDetails",login.email);
                

               this.route.navigate(["userHome"])
              }
              else
              {
                this.msg=result;
              }
            }
           })
         }
      },
      error:(error:any)=>this.msg=error,
      complete:()=>console.log("complete")
    });

  

}
}

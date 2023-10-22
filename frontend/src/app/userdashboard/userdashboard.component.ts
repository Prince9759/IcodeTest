import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit{


  empId:string=""
  count:number=0
  companyName:string=""
   constructor(private router:Router,public es:EmployeeService){}
   ngOnInit(): void {
   let x = sessionStorage.getItem("empid");
   
    if(x!=null)
    {
      this.empId=x;
      this.companyName=this.empId
    }
    this.es.getEmployeeByCompanyName(this.empId).subscribe({
        next:(result:any)=>{
         this.count=Number(result)
         let loginRecord = sessionStorage.getItem("loginRecord");
         if(loginRecord!=null)
         {
          this.count = this.count+Number(loginRecord);
         }

        },
        error:(error:any)=>console.log(error),
        complete:()=>console.log("complete")
    })
  
   
     
   }

    logout() {
        sessionStorage.removeItem("userDetails");
        this.router.navigate(["login"]);
      }
    


}

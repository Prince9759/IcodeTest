import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css'],
  
})
export class AdmindashboardComponent implements OnInit {
   user:string=""
   userById :string=""
   count:number=0
   comapanyName:string=""
   
  constructor(public ls:LoginService,private router:Router){}
  ngOnInit(): void {
    
   // let obj = sessionStorage.getItem("userDetails")
    let obj1 = sessionStorage.getItem("userById")
    // if(obj!=null)
    // {
    //  this. user=obj;
    // }

    if(obj1!=null)
    {
      this.userById=obj1
      this.comapanyName=obj1
      
    }

    this.ls.getUserByCompanyName(this.userById).subscribe({
      next:(result:any)=>{
        this.count=Number(result)
        let employecompanyrecord = sessionStorage.getItem("EmployeeRecord")
        if(employecompanyrecord!=null)
        {
         
         this.count=this.count+Number(employecompanyrecord);
     

        } 
       
        console.log(result)},
      error:(error:any)=>console.log(error),
      complete:()=>console.log("complete")
    })
    
   

    

  


  }
    logout() {
        sessionStorage.removeItem("userDetails");
        this.router.navigate(["login"]);
      }
    




}

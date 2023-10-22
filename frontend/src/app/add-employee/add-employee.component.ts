import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent  implements OnInit{

  employeeRef = new FormGroup({
   eid:new FormControl(),
   firstName: new FormControl(),
   lastName:new FormControl(),
   email:new FormControl(),
   password:new FormControl(),
   typesOfRole: new FormControl(),
   companyName:new FormControl()
  })
  storemsg:string=""
  constructor(public es:EmployeeService){}
  ngOnInit(): void {
    
  }
  storeEmployee()
  {
    let employee =  this.employeeRef.value;
    this.es.storeEmployee(employee).subscribe({
      next:(result:any)=>this.storemsg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("complete")

    })

    this.employeeRef.reset();
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  baseURL:string="http://localhost:8081/employee"
  constructor(public http:HttpClient ) { }
 
  storeEmployee(employee:any):Observable<string>
  {
    return this.http.post(this.baseURL+"/add",employee,{responseType:"text"});
  }

  updateEmployee(employee:any):Observable<string>
  {
    return this.http.patch(this.baseURL+"/update",employee,{responseType:"text"});
  }

  findAllEmployee():Observable<Employee[]>
  {
    return this.http.get<Employee[]>(this.baseURL+"findAllEmp");
  }

  findEmployeeById(email:string):Observable<string>
  {
    return this.http.get(this.baseURL+"/findEmployeeById/"+email,{responseType:"text"});
  }

  deleteEmployeeById(email:string):Observable<string>
  {
    return this.http.delete(this.baseURL+"deleteEmployee/"+email,{responseType:"text"});
  }

  getEmployeeByCompanyName(companyName:string):Observable<string>
  {
    return this.http.get(this.baseURL+"/getEmployeeByCompanyName/"+companyName,{responseType:"text"})
  }
  



 

}

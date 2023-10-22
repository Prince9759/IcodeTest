import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Login } from './login';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseURL:string="http://localhost:8081"
  constructor(public http:HttpClient) { }
  signIn(login:any):Observable<string>
  {
    return this.http.post(this.baseURL+"/signIn",login,{responseType:"text"});
  }
  signInEmployee(login:any):Observable<string>
  {
    return this.http.post(this.baseURL+"/signInemp",login,{responseType:"text"});
  }


  signUp(login:any):Observable<string>
  {
    return this.http.post(this.baseURL+"/signUp",login,{responseType:"text"});
  }


  getUserById(email:string):Observable<string>
  {
    return this.http.get(this.baseURL+"/getUserById/"+email,{responseType:"text"})
  }
  
  getUserByCompanyName(companyName:string):Observable<string>
  {
    return this.http.get(this.baseURL+"/getUserByCompanyName/"+companyName,{responseType:"text"})
  }



 
}

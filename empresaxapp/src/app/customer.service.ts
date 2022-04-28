import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customerUrl !: string;

  constructor(private http: HttpClient) {
    this.customerUrl = "http://localhost:8080/customers";
  }
  //Obteniendo todos los Customers{GET}
  public findAll(): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.customerUrl);
  }
  //Guardando nuevo Customer{POST}
  public save(customer: Customer) {
    return this.http.post<Customer>(this.customerUrl, customer);

  //Falta implemtentacion para update & delete
  }
}

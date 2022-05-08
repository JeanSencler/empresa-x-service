import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customerUrl !: string;

  constructor(private http: HttpClient) {
    this.customerUrl = 'http://localhost:8080/customers';
  }
  //Obteniendo todos los Customers{GET}
  public findAll(): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.customerUrl);
  }
  findCustomer(id: number): Observable<Customer> {
    const url = `${this.customerUrl}/${id}`;
    return this.http.get<Customer>(url);
  }
  //Guardando nuevo Customer{POST}
  public save(customer: Customer) {
    return this.http.post<Customer>(this.customerUrl, customer);
  }
  //Actualizando Customer{PUT}
  public update(customer: Customer){
    return this.http.put<Customer>(this.customerUrl, customer);
  }

  deleteCustomer(id: number): Observable<Customer> {
    const url = `${this.customerUrl}/${id}`;
    return this.http.delete<Customer>(url);
  }
}

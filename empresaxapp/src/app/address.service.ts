import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Address } from './address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private addressUrl !: string;

  constructor(private http: HttpClient) {
    this.addressUrl = "http://localhost:8080/addresses";
  }
  //Obteniendo todos los address{GET}
  public findAll(): Observable<Address[]>{
    return this.http.get<Address[]>(this.addressUrl);
  }
  //Obteniendo por id{GET}
  findAddress(id: number): Observable<Address> {
    const url = `${this.addressUrl}/${id}`;
    return this.http.get<Address>(url);
  }
  //Guardando nuevo Address{POST}
  public save(address: Address) {
    return this.http.post<Address>(this.addressUrl, address);
  }
  //Actualizando Address{PUT}
  public update(address: Address) {
    return this.http.put<Address>(this.addressUrl, address);
  }
  //Borrar por id
  deleteAddress(id: number): Observable<Address> {
    const url = `${this.addressUrl}/${id}`;
    return this.http.delete<Address>(url);
  }
}

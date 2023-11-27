import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import { HttpClient } from '@angular/common/http';
import {Product} from "../model/product.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  //Ajout
  addProduct(product: Product):Observable<any> {
    const url = `${this.baseUrl}/api/product/add`;
    return this.http.post(url, product);
  }

  //Récupération
  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/api/product/`);
  }

  // Suppression
  deleteProduct(id: number): Observable<any> {
    const url = `${this.baseUrl}/api/product/${id}`;
    return this.http.delete(url);
  }

}

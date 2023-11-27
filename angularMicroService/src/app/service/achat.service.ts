import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Product} from "../model/product.model";
import {Observable} from "rxjs";
import {Achat} from "../model/achat.model";

@Injectable({
  providedIn: 'root'
})
export class AchatService {

  baseUrl = environment.apiUrlAchat;

  constructor(private http: HttpClient) { }

  //Ajout
  addAchat(achat: Achat):Observable<any> {
    const url = `${this.baseUrl}/api/achat/add`;
    return this.http.post(url, achat);
  }

  //Récupération
  getAllAchats(): Observable<Achat[]> {
    return this.http.get<Achat[]>(`${this.baseUrl}/api/achat/`);
  }

  // Suppression
  deleteAchat(id: number): Observable<any> {
    const url = `${this.baseUrl}/api/achat/${id}`;
    return this.http.delete(url);
  }
}

import {Component, OnInit} from '@angular/core';
import {Product} from "../model/product.model";
import {ProductService} from "../service/product.service";
import {FormBuilder} from "@angular/forms";
import {AchatService} from "../service/achat.service";
import {Achat} from "../model/achat.model";

@Component({
  selector: 'app-achat',
  templateUrl: './achat.component.html',
  styleUrls: ['./achat.component.css']
})
export class AchatComponent implements OnInit{

  achats: Achat[] = [];
  constructor(private achatService : AchatService,
              private fb : FormBuilder) {
  }

  ngOnInit() {
    this.getAllAchat();
  }

  getAllAchat() {
    this.achatService.getAllAchats().subscribe(
      (data: Achat[]) => {
        this.achats = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération des achats:', error);
      }
    );

  }

}

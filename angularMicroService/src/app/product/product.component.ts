import {Component, OnInit} from '@angular/core';
import {ProductService} from "../service/product.service";
import {Product} from "../model/product.model";
import { FormBuilder, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{

  products: Product[] = [];


  product: Product = {
    category: "",
    id: 0,
    price: 0,
    productName: ""
  };

  constructor(private productService : ProductService,
              private fb : FormBuilder) {
  }
  ngOnInit() {
    this.getAllProduct();
  }

  getAllProduct() {

      this.productService.getAllProducts().subscribe(
        (data: Product[]) => {
          this.products = data;
        },
        (error) => {
          console.error('Erreur lors de la récupération des products:', error);
        }
      );

  }

  addProduct() {
    // Effectuez la requête HTTP avec le token dans l'en-tête
    this.productService.addProduct(this.product).subscribe(
      (response) => {
        Swal.fire({
          icon: 'success',
          title: 'Enregistré',
          text: 'Produit ajouté avec succcés'
        });

        console.log('Produit enregistré:', response);
        this.getAllProduct();

      },
      (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Enregistrement non effectué',
          text: "Oupos une erreur est survenue."
        });

        console.error('Erreur lors de l\'enregistrement d\' un produit:', error);
      }
    );
  }

  // Suppression
  deleteProduct(id: number) {
    Swal.fire({
      title: 'Voulez-vous vraiment supprimer ce product ?',
      text: 'Le Produit sera définitivement supprimé!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Oui, supprimer!'
    }).then((result) => {
      if (result.value) {

        this.productService.deleteProduct(id).subscribe(
          () => {
            Swal.fire({
              title: 'Supprimé!',
              text: 'Le produit a été supprimé avec succès.',
              icon: 'success'
            });
            this.productService.getAllProducts().subscribe(updatedProducts => {
              this.products = updatedProducts;
            });
          },
          (error) => {
            Swal.fire({
              title: 'Oups!',
              text: 'Impossible de supprimer ce product.',
              icon: 'error'
            });
          }
        );
      }
    });
  }










}

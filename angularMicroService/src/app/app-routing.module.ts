import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductComponent} from "./product/product.component";
import {AchatComponent} from "./achat/achat.component";

const routes: Routes = [
  {
    path: '', component : ProductComponent
  },
  {
    path: 'product', component : ProductComponent
  },

  {
    path: 'achat', component : AchatComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

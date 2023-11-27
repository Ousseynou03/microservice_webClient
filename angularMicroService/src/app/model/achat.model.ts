import {Product} from "./product.model";

export interface Achat {
  id : number;
  date : string;
  currency : string;
  total : number;
  product : Product;

}

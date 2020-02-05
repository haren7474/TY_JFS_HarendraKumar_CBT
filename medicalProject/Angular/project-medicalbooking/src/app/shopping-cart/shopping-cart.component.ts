import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { ShoppingcartService } from '../shoppingcart.service';
import { Router } from '@angular/router';
import { ShoppingCart } from '../shoppingcart';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  message: string;
  statusCode: number;
  description: string;
  error: string;
 
  products: Product[];
  cartsArray: ShoppingCart[];

  constructor(private productService: ProductService,
    private shoppingcartService: ShoppingcartService,
    private router: Router) {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    this.viewMyCart(userDetails.userBean[0].userId);
  }

  viewMyCart(userId: number) {
    this.shoppingcartService.viewCart(userId).subscribe(response => {
      console.log(response);
      this.cartsArray = response.shoppingList;
    }, err => {
      console.log(err);
    });
  }



  deleteMessage() {
    this.message = null;
    this.statusCode = null;
  }

  selectProduct(product: Product) {
    this.productService.selectedProductToUpdate = product;
    this.router.navigateByUrl('/updateProduct');
  }



  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';
import { ShoppingcartService } from '../shoppingcart.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  message: string;
  statusCode: number;
  description: string;
  error: string;
  buttonDisabled: boolean;
  inputQuantity: number;

  // onIncrement(): void {
  //   this.count += 1;
  //   }

  //   onDecrement(): void {
  //   this.count -= 1;
  //   }


  products: Product[];

  constructor(private productService: ProductService,
    private shoppingcartService: ShoppingcartService,
    private router: Router) {
    this.getProducts();
  }

  getProducts() {
    this.productService.getData().subscribe(response => {
      console.log(response);
      this.products = response.productBean;
    }, err => {
      console.log(err);
    });
  }

  deleteProduct(product: Product) {
    this.productService.deleteData(product).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.products.splice(this.products.indexOf(product), 1);
        this.statusCode = res.statusCode;
        this.message = res.description;
      } else {
        this.error = res.description;
      }
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

  isAdmin() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.userBean[0].userType === 'admin') {
      return true;
    } else {
      return false;
    }
  }

  isUser() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.userBean[0].userType === 'user') {
      return true;
    } else {
      return false;
    }
  }

  isSeller() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.userBean[0].userType === 'seller') {
      return true;
    } else {
      return false;
    }
  }

  addToCart(product: Product, count: number) {
    product.productQuantity = count;
    this.inputQuantity = count;
    this.shoppingcartService.addCartData(product).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.message = data.description;
      } else {
        this.error = data.description;
      }
      setTimeout(() => {
        this.error = null;
        this.message == null;
      }, 2000);
    });
  }

  sendCount(count) {
    console.log(count);
  }
  ngOnInit() {
    // if(this.inputQuantity>0) {
    // this.buttonDisabled = true;
    // } else {
    //   this.buttonDisabled = false;
    // }
    this.buttonDisabled = false;
    
  }

}

import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  message: string;
  statusCode: number;
  description: string;

  products: Product[];

  constructor(private productService: ProductService,
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
      } else {
        this.message = res.description;
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

  ngOnInit() {
  }

}

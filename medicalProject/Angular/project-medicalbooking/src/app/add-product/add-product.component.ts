import { Component, OnInit } from '@angular/core';
import { User } from '../users';
import { ProductService } from '../product.service';
import { UsersService } from '../users.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  error: string;
  users: User[];
  constructor(private productService: ProductService, private userService: UsersService, private router: Router) {
    this.getOwnerUsers();
  }

  getOwnerUsers() {
    this.userService.getData().subscribe(response => {
      console.log(response);
      this.users = response.userBean.filter((user, index) => {


        let userDetails = JSON.parse(localStorage.getItem('userDetails'));
        if (userDetails && userDetails.userBean[0].userType === 'seller') {
          return user.userId === userDetails.userBean[0].userId;
        } else {
          return user.userType.toLowerCase() === 'seller';
        }
      });
    });
  }

  addProduct(form: NgForm) {
    this.productService.postData(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.router.navigateByUrl('/products');
      } else {
        this.error = data.description;
        setTimeout(() => {
          this.error = null;
        }, 2000);
      }
    });
  }

  ngOnInit() {
  }

}

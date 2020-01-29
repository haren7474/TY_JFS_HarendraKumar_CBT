import { Component, OnInit } from '@angular/core';
import { User } from '../users';
import { ProductService } from '../product.service';
import { UsersService } from '../users.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  message: string;
  statusCode: number;
  error: string;
  users: User[];
  constructor(private productService: ProductService, private userService: UsersService) {
    this.getOwnerUsers();
  }

  getOwnerUsers() {
    this.userService.getData().subscribe(response => {
      console.log(response);
      this.users = response.userBean.filter((user, index) => {
        return user.userType.toLowerCase() === 'seller';
      });
    });
  }

  addProduct(form: NgForm) {
    this.productService.postData(form.value).subscribe(data => {
      console.log(data);
      if (this.statusCode === 201) {
        this.message = data.description;
        form.reset();
      } else {
        this.error = data.description;
      }
      setTimeout(() => {
        this.error = null;
        this.message = null;
      }, 2000);
    });
  }


  ngOnInit() {
  }

}

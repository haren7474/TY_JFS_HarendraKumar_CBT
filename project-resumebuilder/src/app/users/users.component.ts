import { Component, OnInit } from '@angular/core';
import { User } from '../users';
import { UsersService } from '../users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  message: string;
  statusCode: number;
  description: string;

  users: User[];

  constructor(private userService: UsersService,
    private router: Router) {
    this.getUsers();
  }

  // To be  checked
  getUsers() {
    this.userService.getData().subscribe(response => {
      console.log(response);
      this.users = response.userBean;
    }, err => {
      console.log(err);
    });
  }

  deleteUser(user: User) {
    this.userService.deleteData(user).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.users.splice(this.users.indexOf(user), 1);
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

  selectUser(user) {
    this.userService.selectedUserToUpdate = user;
    this.router.navigateByUrl('/updateUser');
  }

  ngOnInit() {
  }

}

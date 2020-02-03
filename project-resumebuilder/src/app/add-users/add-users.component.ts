import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsersService } from '../users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.css']
})
export class AddUsersComponent implements OnInit {

  message: string;
  statusCode: number;
  description: string;
  error: string;
  constructor(private auth: UsersService, private router: Router) { }

  addUser(form: NgForm) {
    this.auth.postData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
      } else if (res.statusCode === 401) {
        this.error = res.description;
        setTimeout(() => {
          this.message = null;
          this.error = null;
        }, 5000);
      }

    });
  }

  deleteMessage() {
    this.message = null;
    this.router.navigateByUrl('/login');
  }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: string;
  statusCode: number;
  description: string;
  error: string;

  constructor(private auth: AuthenticationService,
    private router: Router) { }

  login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        console.log('user details stored in local storage.');
        let userDetails = JSON.parse(localStorage.getItem('userDetails'));
        this.router.navigateByUrl('/');
      } else {
        form.reset();
        this.error = res.description;
        setTimeout(() => {
          this.message = null;
          this.error = null;
        }, 5000);
      }


    });
  }

  ngOnInit() {
  }

}

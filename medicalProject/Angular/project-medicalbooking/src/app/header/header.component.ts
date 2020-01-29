import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }
  currentUser: string;
  yourRole: string;

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

  isLoggedIn() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
      this.currentUser = userDetails.userBean[0].userName;
      this.yourRole = userDetails.userBean[0].userType;
      return true;
    } else {
       this.currentUser = null;
       this.yourRole = null;
      return false;
    }
  }

  displayUserDetails() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
      this.currentUser = userDetails.userBean[0].userName;
      this.yourRole = userDetails.userBean[0].userType;
    } else {
       this.currentUser = null;
       this.yourRole = null;
    }
  }
  logout() {
    localStorage.removeItem('userDetails');
    this.router.navigateByUrl('/login');
  }

  ngOnInit() {
    //this.displayUserDetails();
  }

}
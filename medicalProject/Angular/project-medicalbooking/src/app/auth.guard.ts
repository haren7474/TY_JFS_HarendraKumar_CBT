import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  canActivate(route: ActivatedRouteSnapshot): boolean {
    let expectedRolesArray = route.data.expectedRoles;
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    let expectedRole: string;

    for (let index in expectedRolesArray) {
      if (userDetails && userDetails.userBean.userType === expectedRolesArray[index]) {
        expectedRole = expectedRolesArray[index];
      }
    }
    if (userDetails && userDetails.userBean.userType === expectedRole) {
      return true;
    } else {
      return false;
    }
  }
}

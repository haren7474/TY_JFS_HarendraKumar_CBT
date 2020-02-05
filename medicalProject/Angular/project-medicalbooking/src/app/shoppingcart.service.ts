import { Injectable } from '@angular/core';
import { ShoppingCart } from './shoppingcart';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';

@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService {

  myCart: ShoppingCart;

  api = 'http://localhost:8080/medicalbookingboot';

  constructor(private http: HttpClient) { }

  addCartData(product): Observable<any> {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails) {
     this.myCart= new ShoppingCart();
      this.myCart.orderQuantity = product.productQuantity;
      this.myCart.userBean = userDetails.userBean[0];
      this.myCart.productBean = product;
      return this.http.post<any>(
        `${this.api}/addToCart`, this.myCart);
    }
  }

  viewCart(userId): Observable<any> {
    return this.http.get<any>(`${this.api}/viewCart/${userId}`);
  }
}

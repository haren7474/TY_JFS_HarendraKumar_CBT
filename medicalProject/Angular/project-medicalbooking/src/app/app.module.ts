import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { UsersComponent } from './users/users.component';
import { AddUsersComponent } from './add-users/add-users.component';
import { UpdateUsersComponent } from './update-users/update-users.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProductsComponent } from './products/products.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ContactusComponent } from './contactus/contactus.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    UsersComponent,
    AddUsersComponent,
    UpdateUsersComponent,
    HomeComponent,
    AboutComponent,
    PagenotfoundComponent,
    LoginComponent,
    RegisterComponent,
    ProductsComponent,
    AddProductComponent,
    UpdateProductComponent,
    ContactusComponent,
    ShoppingCartComponent,
    MyOrdersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'aboutUs', component: AboutComponent },
      { path: 'contactUs', component: ContactusComponent },
      { path: 'login', component: LoginComponent },
      { path: 'users', component: UsersComponent },
      { path: 'addUser', component: AddUsersComponent },
      { path: 'updateUser', component: UpdateUsersComponent },
      { path: 'products', component: ProductsComponent },
      { path: 'addProduct', component: AddProductComponent },
      { path: 'updateProduct', component: UpdateProductComponent },
      { path: 'myOrders', component: MyOrdersComponent },
      { path: 'shoppingCart', component: ShoppingCartComponent },
      { path: '**', component: PagenotfoundComponent }
    ]) 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

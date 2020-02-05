import { User } from './users';
import { Product } from './product';

export class ShoppingCart {
    cartId: number;
    createDateTime: Date;
    updateDateTime: Date;
    userBean: User;
    productBean: Product;
    orderQuantity: number;
}
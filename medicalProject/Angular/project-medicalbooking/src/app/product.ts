import { User } from './users';

export interface Product {
    productId: number;
    productName: string;
    productQuantity: number;
    productPrice: number;
    productComments: string;
    productImageUrl: string;
    userBean: User;
}

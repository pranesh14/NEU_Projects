export class Cart {
    productname: string;
    quantity: number;
    price: number;
    constructor(productname: string, quantity: number, price: number) {
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
    }
}

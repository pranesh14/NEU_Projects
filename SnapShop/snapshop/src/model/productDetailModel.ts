export class ProductDetail {
    _id:string;
    name: string;
    description: string;    
    price: number;
    inventorycount: number;
    rating: number;
    imageURL: string;
    constructor(_id:string,name: string, description: string, inventorycount: number, price: number, rating: number, imageURL: string) {
        this._id=_id;
        this.name = name;
        this.description = description;
        this.inventorycount = inventorycount;
        this.price = price;
        this.rating = rating;
        this.imageURL = imageURL;
    }
}

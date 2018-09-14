export class SearchProduct{
    id: string;
}

export class Product {
    id:string;
    name: string;
    description: string;
    price:number;
    quantity:number;
    image:string;
}

export class SearchProductByName{
    name: String;

    constructor(search:String){
        this.name = search;
    }
}
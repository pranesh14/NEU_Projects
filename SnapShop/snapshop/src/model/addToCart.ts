export class Product {
    id:string;
    name: string;
    description: string;
    price:number;
    quantity:number;
    image:string;
}

export const products: Product[] = [
    {
        id:"1234",
        name: "Beats Headphone 27X",
        description: "Best bass headphones",
        price:1200,
        quantity:0,
        image:"../images/product1.jpg",
    }
];

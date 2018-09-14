//sample data

//create DB
use snapshopDB;
//create user collection
db.createCollection("user");
//insert document
db.user.insert({
    username: "tara",
    password: "tara",
    lastname: "sarathy",
    firtsname: "tara",
    email: "tarangini.1191@yahoo.co.in",
    phonenumber: "9076894555"
});
//select documents
db.user.find({});
//create product collection
db.createCollection("product");
//insert document
db.product.insert({
    name: "PS4",
    description: "console + 1 controller",
    price: 300,
    inventorycount: 1,
    rating: 5,
    imageurl: "https://psmedia.playstation.com/is/image/psmedia/ps4-pro-two-column-buy-02-au-09sep15?$TwoColumn_Image$"
});
//select documents
db.product.find();
///create cart collection
db.createCollection("cart");
//insert document
db.cart.insert({
    productname: "PS4",
    quantity: 1,
    price: 300
});
//select documents
db.cart.find();
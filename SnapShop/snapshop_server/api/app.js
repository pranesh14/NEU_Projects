'use strict';
module.exports = function(app) {
    //Initialize models
    let loginModel = require('./model/login-model');
    //let scanProductModel = require('./model/scan-product-model');
    let paymentModel = require('./model/payment-model');
    let productDetailModel = require('./model/productDetail-model');

    //Initialize routes
    let loginRoutes = require('./routes/login-route');
    loginRoutes(app);
    let registerRoutes = require('./routes/register-route');
    registerRoutes(app);
    let scanProductRoutes = require('./routes/scan-product-route');
    scanProductRoutes(app);
    let paymentRoutes = require('./routes/payment-route');
    paymentRoutes(app);
    let addToCartRoutes = require('./routes/addToCart-route');
    addToCartRoutes(app);
    let searchProductsRoutes = require('./routes/search-product-route');
    searchProductsRoutes(app);
    let cartDisplayRoutes = require('./routes/cart-display-route');
    cartDisplayRoutes(app);
    let deleteCartRoutes = require('./routes/deleteCart-route');
    deleteCartRoutes(app);
    let productDetailRoutes = require('./routes/productDetail-route');
    productDetailRoutes(app);
    let removeFromCartRoutes = require('./routes/removeFromCart-route');
    removeFromCartRoutes(app);
};

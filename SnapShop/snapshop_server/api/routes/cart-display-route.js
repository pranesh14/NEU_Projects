/**
 * Sticky endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const cartDisplayController = require('../controller/cart-display-controller');
    // Sticky Routes for search and create.
    app.route('/cart')
        .get(cartDisplayController.get)
        
    // app.route('/cart/:cartId')
    //     .delete(cartDisplayController.delete)
};
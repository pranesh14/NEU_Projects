/**
 * Sticky endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const addToCartController = require('../controller/addToCart-controller');
    // Sticky Routes for search and create.
    app.route('/cart')
        .post(addToCartController.post);

};
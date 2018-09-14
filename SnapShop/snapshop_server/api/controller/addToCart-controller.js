/**
 * Controller for sticky endpoints.
 */

'use strict';
const addToCartService = require('../service/addToCart-service');

/**
 * Returns a list of stickies in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.post = function(request, response) {
    let addToCart = Object.assign({}, request.body);
    addToCartService.findOne(addToCart, function(cart) {
        if (cart != null && cart != '' && cart != []) {
            response.status(200);
            response.json(cart);
            console.log("Cart");
        } else {
            response.status(401);
            console.log("Cart addition error");
        }
    });
};
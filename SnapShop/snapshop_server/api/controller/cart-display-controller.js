/**
 * Controller for search product endpoints.
 */

'use strict';
//import search product service.
const cartDisplayService = require('../service/cart-display-service');

/**
 * Returns a list of products in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function(request, response) {

    console.log("A " + JSON.stringify(request.body))
    console.log("search Product Controller");
    let productName = Object.assign({}, request.body);
    console.log("I" + productName);

    cartDisplayService.find(productName, function(product) {
        // console.log(product);
        if (product != null && product != '' && product != []) {
            response.status(200);
            response.json(product);
            console.log("Product Found\n" + JSON.stringify(product));
        } else {
            console.log(product);
            response.status(204);
            console.log("Product not found");
        }
    });
};


exports.delete = function(request, response) {
    console.log(request.params.productId);
    cartDisplayService.remove(request.params.productId, function(product) {
        response.status(200);
        response.json(product);
    });
    console.log("Delete" + JSON.stringify(response.body))
};
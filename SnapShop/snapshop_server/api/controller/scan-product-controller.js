/**
 * Controller for search product endpoints.
 */

'use strict';
//import search product service.
const scanProductService = require('../service/scan-product-service');

/**
 * Returns a list of products in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function(request, response) {

    console.log("Ab "+JSON.stringify(request.body))
    console.log("scan Product Controller");
    let product = Object.assign({}, request.body);
    // console.log(product);

    scanProductService.findOne(product, function(product) {
        // console.log(product);
        if (product != null && product != '' && product != []) {
            response.status(200);
            response.json(product);
            console.log("Product Found");
        } else {
            console.log(product);
            response.status(204);
            // response.json(null);
            console.log("Product not found");
        }
    });
};
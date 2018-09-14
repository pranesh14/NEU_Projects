'use strict';
const productDetailService = require('../service/productDetail-service');

/**
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function(request, response) {
    productDetailService.find(request.params.productId, function(product) {
        // console.log(product);
        response.status(200);
        response.json(product);
    });
};
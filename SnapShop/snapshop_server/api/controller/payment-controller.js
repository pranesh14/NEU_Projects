'use strict';
const paymentService = require('../service/payment-service');

/**
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function(request, response) {
    let cart = Object.assign({}, request.body);
    paymentService.find(cart, function(cart) {
        response.status(200);
        response.json(cart);
    });
};
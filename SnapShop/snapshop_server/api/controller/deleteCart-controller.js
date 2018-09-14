'use strict';
const deleteCartService = require('../service/deleteCart-service');

/**
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.delete = function(request, response) {
    deleteCartService.delete(function(cart) {
        response.status(200);
        response.json(cart);
    });
};
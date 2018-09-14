'use strict';
const mongoose = require('mongoose'),
    Cart = mongoose.model('cart');

/**
 * Throws error if error object is present.
 *
 * @param {Object} error {Error object}
 */
let throwError = function(error) {
    if (error) {
        throw Error(error);
    }
};

exports.delete = function(callback) {
    Cart.remove({}, function(err, foundCart) {
        throwError(err);
        callback(foundCart);
    });
};
'use strict';
const mongoose = require('mongoose'),
    Product = mongoose.model('product');

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

exports.find = function(productID, callback) {
    // console.log(productID);
    Product.findById(productID, function(err, foundProduct) {
        throwError(err);
        callback(foundProduct);
    });
};
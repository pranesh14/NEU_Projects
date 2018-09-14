/**
 * Service for search-product operations.
 */

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

/**
 * Returns an array of sticky object matching the search parameters.
 *
 * @param {Object} productName {Search parameters}
 *
 * @param {function} callback {Sucess callback function}
 */
exports.find = function(productName, callback) {

    // var test = "";
    // test = test + productObj.id;
    Cart.find({ name: new RegExp(productName.name, 'i') }, function(err, foundProduct) {
        console.log(err);
        throwError(err);

        console.log(foundProduct);
        callback(foundProduct);

    });
};
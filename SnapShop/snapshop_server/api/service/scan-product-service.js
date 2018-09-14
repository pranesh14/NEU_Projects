/**
 * Service for search-product operations.
 */

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

/**
 * Returns an array of sticky object matching the search parameters.
 *
 * @param {Object} productObj {Search parameters}
 *
 * @param {function} callback {Sucess callback function}
 */
exports.findOne = function(productObj, callback) {

    // var test = "";
    // test = test + productObj.id;
    // Product.findById(test, function(err, foundProduct) {
    //     console.log(err);
    //     throwError(err);

    //     console.log(foundProduct);
    //     callback(foundProduct);

    // });

    Product.find({id:productObj.id}, function (err, foundProduct) {
        console.log(err);
        throwError(err);

        console.log(foundProduct);
        callback(foundProduct);

    });
};
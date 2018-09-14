/**
 * Service for sticky operations.
 */

'use strict';
const mongoose = require('mongoose'),
    Cart = mongoose.model('cart');
    
    //console.log(User);
/**
 * Throws error if error object is present.
 *
 * @param {Object} error {Error object}
 */
let throwError = function (error) {
    if (error) {
        throw Error(error);
    }
};

/**
 * Returns an array of sticky object matching the search parameters.
 *
 * @param {Object} userObj {Search parameters}
 *
 * @param {function} callback {Sucess callback function}
 */
exports.remove = function (userObj, callback) {
    Cart.remove({name:userObj.name}, function(product){
    });

};



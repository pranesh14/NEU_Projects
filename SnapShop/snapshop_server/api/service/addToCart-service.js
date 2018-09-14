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
let throwError = function(error) {
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
exports.findOne = function(userObj, callback) {
    // let addToCart = new Cart(userObj);
    // addToCart.save(function (err, userObj) {
    //     throwError(err);
    //     callback(userObj);

    // });

    // console.log(userObj);
    // Cart.find({username:userObj.username,password:userObj.password}, function (err, foundUser) {
    //     console.log(err);
    //    // console.log(username_1+"Username"+password_1);
    //     throwError(err);
    //     console.log(foundUser);
    //     callback(foundUser);
    // });
    //     var test = "";
    //     test = test + userObj.name;
    //     console.log("Abc "+userObj.name);        
    //     Cart.findOne({name:userObj.name}, function (err, cart) {
    //             console.log("mila"+cart);        
    //         cart.quantity =userObj.quantity;
    //         console.log("mila2"+userObj.quantity);  
    //         console.log("mila3"+JSON.stringify(cart))
    //             let addToCart = new Cart(cart);             
    //             addToCart.save(function (err, userObj) {
    //         throwError(err);
    //         callback(userObj);

    // });
    //       });
    // var query = { quantity: userObj.quantity };
    // Cart.update(query, { name: userObj.name }, function (err, doc) {})
    // console.log(doc)
    // is sent as

    // Model.update(query, { $set: { name: 'jason bourne' }}, options, callback)
    console.log("fuck");
    Cart.findOne({ name: userObj.name }, function(err, cart) {
        if (cart != null) {
            cart.quantity = Number(userObj.quantity) + cart.quantity;
            cart.save(function(err, userObj) {
                if (err) {
                    console.error('ERROR!');
                }
                callback(userObj);
            });
        } else {
            let addToCart = new Cart(userObj);
            addToCart.save(function(err, userObj) {
                throwError(err);
                callback(userObj);

            });

        }

    });

};